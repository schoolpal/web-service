package com.schoolpal.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.schoolpal.web.model.Log;
import com.schoolpal.web.model.User;
import com.schoolpal.web.model.page.Button;
import com.schoolpal.web.model.page.FuncRow;
import com.schoolpal.web.model.page.config.OrgForm;
import com.schoolpal.web.model.page.config.OrgPage;
import com.schoolpal.web.model.page.config.RoleForm;
import com.schoolpal.web.model.page.config.RolePage;
import com.schoolpal.web.model.page.config.UserForm;
import com.schoolpal.web.model.page.config.UserPage;
import com.schoolpal.web.model.page.OrgRow;
import com.schoolpal.web.service.ConfigService;
import com.schoolpal.web.service.LogService;
import com.schoolpal.web.service.UserService;

@Controller
@RequestMapping("/config/")
public class ConfigController {
	
	@Autowired
	private LogService logServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private ConfigService configServ;
	private Gson gson = new Gson();
	
	@RequestMapping("org.html")
	public ModelAndView org(String id) {
		User user = userServ.getCachedUser();
		List<Button> buttons = userServ.buildButtons(user.getWidgets(), id);
		OrgPage page = new OrgPage();
		page.setButtons(buttons);
		page.setOrgRows(configServ.getAvailableOrgRows(user.getOrg().getCode()));
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.org(String)", "", String.format("Id: %s, Page: %s", id, gson.toJson(page)));
		return new ModelAndView("config/org/index", "page", page);
	}
	
	@RequestMapping("org/segment.html")
	public ModelAndView orgSegment() {
		User user = userServ.getCachedUser();
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.orgSegment()", "");
		return new ModelAndView("config/org/segment", "orgRows", configServ.getAvailableOrgRows(user.getOrg().getCode()));
	}
	
	@RequestMapping("org/remove.do")
	@ResponseBody
	public String orgRemove(String id) {
		User user = userServ.getCachedUser();
		String msg = "";
		if (msg.equals("")) {
			try {
				msg = "非法操作！";
				List<OrgRow> orgRows = configServ.getAvailableOrgRows(user.getOrg().getCode());
				for (OrgRow row : orgRows) {
					if (row.getId().equals(id)) {
						msg = "";
						break;
					}
				}
				
				if (msg.equals("") && !configServ.disableOrg(id, user.getLoginName())) {
					msg = "删除组织机构失败，系统未给出明确的错误信息！";
				}
			} catch (Exception ex) {
				msg = "数据库操作失败！";
				logServ.log(user.getLoginName(), Log.ERROR, "ConfigController.orgRemove(String)", ex.getMessage(), "Id: " + id);
			}
		}
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.orgRemove(String)", "Id: " + id);
		return msg;
	}
	
	@RequestMapping("org/new.html")
	public String orgNew() {
		User user = userServ.getCachedUser();
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.orgNew()", "");
		return "config/org/new";
	}
	
	@RequestMapping("org/newSegment.html")
	public ModelAndView orgNewSegment() {
		User user = userServ.getCachedUser();
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.orgNewSegment()", "");
		return new ModelAndView("config/org/newSegment", "orgRows", configServ.getAvailableOrgRows(user.getOrg().getCode()));
	}
	
	@RequestMapping(value="org/new.do", method=RequestMethod.POST)
	@ResponseBody
	public String orgNew(OrgForm form) {
		User user = userServ.getCachedUser();
		String msg = "";
		String orgId = configServ.getOrgId(form.getOrgCode());
		if (!orgId.equals("")) {
			msg = "组织代码已存在，请换用其他代码！";
		}
		
		if (msg.equals("")) {
			try {
				msg = "非法操作！";
				List<OrgRow> orgRows = configServ.getAvailableOrgRows(user.getOrg().getCode());
				for (OrgRow row : orgRows) {
					if (row.getId().equals(form.getParentId())) {
						msg = "";
						break;
					}
				}
				
				if (msg.equals("") && !configServ.addOrg(form, user.getLoginName())) {
					msg = "新增组织机构失败，系统未给出明确的错误信息！";
				}
			} catch (Exception ex) {
				msg = "数据库操作失败！";
				logServ.log(user.getLoginName(), Log.ERROR, "ConfigController.orgNew(ConfigOrgNewForm)", ex.getMessage(), String.format("Form: %s", gson.toJson(form)));
			}
		}
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.orgNew(ConfigOrgNewForm)", msg, String.format("Form: %s", gson.toJson(form)));
		return msg;
	}
	
	@RequestMapping("org/edit.html")
	public ModelAndView orgEdit(String id) {
		User user = userServ.getCachedUser();
		OrgForm form = null;
		
		List<OrgRow> orgRows = configServ.getAvailableOrgRows(user.getOrg().getCode());
		for (OrgRow row : orgRows) {
			if (row.getId().equals(id)) {
				form = configServ.getOrgInfo(id);
				form.setId(id);
				break;
			}
		}
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.orgEdit(String)", "", "Id: " + id);
		return new ModelAndView("config/org/edit", "form", form);
	}
	
	@RequestMapping(value="org/mod.do", method=RequestMethod.POST)
	@ResponseBody
	public String orgMod(OrgForm form) {
		User user = userServ.getCachedUser();
		String msg = "";
		String orgId = configServ.getOrgId(form.getOrgCode());
		if (!orgId.equals("") && !orgId.equals(form.getId())) {
			msg = "组织代码已存在，请换用其他代码！";
		}

		if (msg.equals("")) {
			try {
				msg = "非法操作！";
				List<OrgRow> orgRows = configServ.getAvailableOrgRows(user.getOrg().getCode());
				for (OrgRow row : orgRows) {
					if (row.getId().equals(form.getParentId())) {
						msg = "";
						break;
					}
				}
				
				if (msg.equals("") && !configServ.updateOrg(form, user.getLoginName())) {
					msg = "修改组织机构失败，系统未给出明确的错误信息！";
				}
			} catch (Exception ex) {
				msg = "数据库操作失败！";
				logServ.log(user.getLoginName(), Log.ERROR, "ConfigController.orgMod(ConfigOrgNewForm)", ex.getMessage(), String.format("Form: %s", gson.toJson(form)));
			}
		}
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.orgMod(ConfigOrgNewForm)", msg, String.format("Form: %s", gson.toJson(form)));
		return msg;
	}
	
	@RequestMapping("role.html")
	public ModelAndView role(String id) {
		User user = userServ.getCachedUser();
		List<Button> buttons = userServ.buildButtons(user.getWidgets(), id);
		OrgPage page = new OrgPage();
		page.setButtons(buttons);
		page.setOrgRows(configServ.getAvailableOrgRows(user.getOrg().getCode()));
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.role(String)", "", String.format("Id: %s, Page: %s", id, gson.toJson(page)));
		return new ModelAndView("config/role/index", "page", page);
	}
	
	@RequestMapping("role/new.html")
	public ModelAndView roleNew(String orgId) {
		User user = userServ.getCachedUser();
		List<OrgRow> hierarchy = configServ.getOrgHierarchy(orgId);

		RolePage page = new RolePage();
		String strHierarchy = "";
		for (OrgRow row : hierarchy) {
			strHierarchy = row.getName() + "/" + strHierarchy;
		}
		page.setOrgHierarchy(strHierarchy.substring(0, strHierarchy.length() - 1));
		page.setId(orgId);
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.roleNew(String)", "", 
				String.format("OrgId: %s, OrgHierarchy: %s", page.getId(), page.getOrgHierarchy()));
		return new ModelAndView("config/role/new", "page", page);
	}
	
	@RequestMapping(value="role/new.do", method=RequestMethod.POST)
	@ResponseBody
	public String roleNew(RoleForm form) {
		User user = userServ.getCachedUser();
		String msg = "";
		try {
			String[] strFuncIds = form.getStrFuncIds().split(",");
			int[] funcIds = new int[strFuncIds.length];
			for (int i = 0; i < strFuncIds.length; i++) {
				funcIds[i] = Integer.parseInt(strFuncIds[i]);
			}
			
			if (!configServ.addRole(form.getOrgId(), user.getId(), form.getName(), form.getDesc(), form.getRankId(), funcIds)) {
				msg = "新增角色失败，系统未给出明确的错误信息！";
			}
		} catch(Exception ex) {
			msg = "数据库操作失败！";
			logServ.log(user.getLoginName(), Log.ERROR, "ConfigController.roleNew(RoleForm)", ex.getMessage(), String.format("RoleForm: %s", gson.toJson(form)));
		}
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.roleNew(RoleForm)", "", String.format("RoleForm: %s", gson.toJson(form)));
		return msg;
	}
	
	@RequestMapping("role/segment.html")
	public ModelAndView roleSegment(String orgId) {
		User user = userServ.getCachedUser();
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.roleSegment(String)", "", String.format("OrgId: %s", orgId));
		return new ModelAndView("config/role/segment", "roleRows", configServ.roleRows(orgId));
	}
	
	@RequestMapping("role/edit.html")
	public ModelAndView roleEdit(String orgId, String roleId) {
		User user = userServ.getCachedUser();
		RoleForm form = configServ.getRoleInfo(roleId);
		
		List<OrgRow> hierarchy = configServ.getOrgHierarchy(orgId);
		String strHierarchy = "";
		for (OrgRow row : hierarchy) {
			strHierarchy = row.getName() + "/" + strHierarchy;
		}
		form.setOrgHierarchy(strHierarchy.substring(0, strHierarchy.length() - 1));
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.roleEdit(String)", "", 
				"OrgId: " + orgId + " RoleId: " + roleId + " RoleForm: " + gson.toJson(form));
		return new ModelAndView("config/role/edit", "form", form);
	}
	
	@RequestMapping(value="role/mod.do", method=RequestMethod.POST)
	@ResponseBody
	public String roleMod(RoleForm form) {
		User user = userServ.getCachedUser();
		String msg = "";
		try {
			String[] strFuncIds = form.getStrFuncIds().split(",");
			int[] funcIds = new int[strFuncIds.length];
			for (int i = 0; i < strFuncIds.length; i++) {
				funcIds[i] = Integer.parseInt(strFuncIds[i]);
			}
			
			if (!configServ.updateRole(form.getId(), form.getName(), form.getDesc(), form.getRankId(), funcIds)) {
				msg = "编辑角色失败，系统未给出明确的错误信息！";
			}
		} catch(Exception ex) {
			msg = "数据库操作失败！";
			logServ.log(user.getLoginName(), Log.ERROR, "ConfigController.roleMod(RoleForm)", ex.getMessage(), String.format("RoleForm: %s", gson.toJson(form)));
		}
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.roleMod(RoleForm)", "", String.format("RoleForm: %s", gson.toJson(form)));
		return msg;
	}
	
	@RequestMapping("role/remove.do")
	@ResponseBody
	public String roleRemove(String roleId) {
		User user = userServ.getCachedUser();
		String msg = "";

		try {
			if (!configServ.removeRole(roleId)) {
				msg = "删除角色失败，系统未给出明确的错误信息！";
			}
		} catch (Exception ex) {
			msg = "数据库操作失败！";
			logServ.log(user.getLoginName(), Log.ERROR, "ConfigController.roleRemove(String)", "", "RoleId: " + roleId);
		}
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.roleRemove(String)", "", "RoleId: " + roleId);
		return msg;
	}
	
	@RequestMapping("auth.html")
	public ModelAndView auth(String id) {
		User user = userServ.getCachedUser();
		List<Button> buttons = userServ.buildButtons(user.getWidgets(), id);
		OrgPage page = new OrgPage();
		page.setButtons(buttons);
		page.setOrgRows(configServ.getAvailableOrgRows(user.getOrg().getCode()));
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.auth(String)", "", String.format("Id: %s, Page: %s", id, gson.toJson(page)));
		return new ModelAndView("config/auth/index", "page", page);
	}
	
	@RequestMapping("auth/roleSegment.html")
	public ModelAndView authRoleSegment(String orgId) {
		User user = userServ.getCachedUser();
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.authRoleSegment(String)", "", String.format("OrgId: %s", orgId));
		return new ModelAndView("config/auth/roleSegment", "roleRows", configServ.roleRows(orgId));
	}
	
	@RequestMapping("auth/roleSelection.html")
	public ModelAndView authRoleSelection(String roleId) {
		User user = userServ.getCachedUser();
		List<FuncRow> funcRows = configServ.getFuncHierarchy(roleId);
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.authRoleSelection(String)", "", String.format("RoleId: %s", roleId));
		return new ModelAndView("config/auth/roleSelection", "funcRows", funcRows);
	}
	
	@RequestMapping("auth/apply.html")
	@ResponseBody
	public String authApply(String roleId, String excludedIdString) {
		User user = userServ.getCachedUser();
		
		String result = "";
		try {
			configServ.updateExcludedFunctions(user.getId(), roleId, excludedIdString.split(","));
		} catch(Exception ex) {
			result = ex.getMessage();
		}
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.authApply(String, String)", "", String.format("RoleId: %s, ExcludedIdString: %s", roleId, excludedIdString));
		return result;
	}
	
	@RequestMapping("user/enable.html")
	@ResponseBody
	public String userEnable(String userId) {
		User user = userServ.getCachedUser();
		
		String result = "";
		try {
			configServ.userEnable(userId);
		} catch(Exception ex) {
			result = ex.getMessage();
		}
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.userEnable(String)", "", "UserId: " + userId);
		return result;
	}
	
	@RequestMapping("user/disable.html")
	@ResponseBody
	public String userDisable(String userId) {
		User user = userServ.getCachedUser();
		
		String result = "";
		try {
			configServ.userDisable(userId);
		} catch(Exception ex) {
			result = ex.getMessage();
		}
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.userDisable(String)", "", "UserId: " + userId);
		return result;
	}
	
	@RequestMapping("user/remove.html")
	@ResponseBody
	public String userRemove(String userId) {
		User user = userServ.getCachedUser();
		
		String result = "";
		if (user.getId().equals(userId)) {
			result = "不允许删除当前操作用户！";
		} else {
			try {
				configServ.userRemove(userId);
			} catch(Exception ex) {
				result = ex.getMessage();
			}
		}
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.userRemove(String)", "", "UserId: " + userId);
		return result;
	}
	
	@RequestMapping("user.html")
	public ModelAndView user(String id) {
		User user = userServ.getCachedUser();
		List<Button> buttons = userServ.buildButtons(user.getWidgets(), id);
		OrgPage page = new OrgPage();
		page.setButtons(buttons);
		page.setOrgRows(configServ.getAvailableOrgRows(user.getOrg().getCode()));
		
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.user(String)", "", String.format("Id: %s, Page: %s", id, gson.toJson(page)));
		return new ModelAndView("config/user/index", "page", page);
	}
	
	@RequestMapping("user/list.html")
	public ModelAndView userList(String orgId) {
		User user = userServ.getCachedUser();
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.userList()", "", "OrgId: " + orgId);
		
		List<UserPage> users = configServ.getUsers(orgId);
		return new ModelAndView("config/user/list", "users", users);
	}
	
	@RequestMapping("user/new.html")
	public ModelAndView userNew(String orgId) {
		User user = userServ.getCachedUser();
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.userNew(String)", "", "OrgId: " + orgId);
		
		List<OrgRow> hierarchy = configServ.getOrgHierarchy(orgId);
		String strHierarchy = "";
		for (OrgRow row : hierarchy) {
			strHierarchy = row.getName() + "/" + strHierarchy;
		}

		Map<String, Object> page = new HashMap<String, Object>();
		page.put("roleRows", configServ.roleRows(orgId));
		page.put("orgHierarchy", strHierarchy.substring(0, strHierarchy.length() - 1));
		page.put("orgId", orgId);
		return new ModelAndView("config/user/new", "page", page);
	}
	
	@RequestMapping(value="user/new.do", method=RequestMethod.POST)
	@ResponseBody
	public String userNew(UserForm form) {
		User user = userServ.getCachedUser();
		String msg = "";
		try {
			configServ.addUser(user.getId(), form);
		} catch(Exception ex) {
			msg = "数据库操作失败！";
			logServ.log(user.getLoginName(), Log.ERROR, "ConfigController.userNew(UserForm)", ex.getMessage(), String.format("UserForm: %s", gson.toJson(form)));
		}
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.userNew(UserForm)", "", String.format("UserForm: %s", gson.toJson(form)));
		return msg;
	}
	
	@RequestMapping("user/edit.html")
	public ModelAndView userEdit(String orgId, String userId) {
		User user = userServ.getCachedUser();
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.userEdit(String, String)", "", "OrgId: " + orgId + " UserId: " + userId);
		
		List<OrgRow> hierarchy = configServ.getOrgHierarchy(orgId);
		String strHierarchy = "";
		for (OrgRow row : hierarchy) {
			strHierarchy = row.getName() + "/" + strHierarchy;
		}

		Map<String, Object> page = new HashMap<String, Object>();
		page.put("roleRows", configServ.roleRows(orgId));
		page.put("orgHierarchy", strHierarchy.substring(0, strHierarchy.length() - 1));
		page.put("form", configServ.getUserForm(userId));
		page.put("orgId", orgId);
		page.put("userId", userId);
		return new ModelAndView("config/user/edit", "page", page);
	}
	
	@RequestMapping(value="user/edit.do", method=RequestMethod.POST)
	@ResponseBody
	public String userEdit(UserForm form) {
		User user = userServ.getCachedUser();
		String msg = "";
		try {
			configServ.modUser(user.getId(), form);
		} catch(Exception ex) {
			msg = "数据库操作失败！";
			logServ.log(user.getLoginName(), Log.ERROR, "ConfigController.userEdit(UserForm)", ex.getMessage(), String.format("UserForm: %s", gson.toJson(form)));
		}
		logServ.log(user.getLoginName(), Log.TRACE, "ConfigController.userEdit(UserForm)", "", String.format("UserForm: %s", gson.toJson(form)));
		return msg;
	}
	
}
