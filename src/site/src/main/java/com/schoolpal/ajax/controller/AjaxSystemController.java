package com.schoolpal.ajax.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import com.google.gson.Gson;
import com.schoolpal.ajax.*;
import com.schoolpal.db.model.*;
import com.schoolpal.service.*;
import com.schoolpal.web.model.*;

@Controller
@RequestMapping("/ajax/sys/")
public class AjaxSystemController {

	// @Autowired
	// private LogService logServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private OrgService orgServ;
	@Autowired
	private RoleService roleServ;
	@Autowired
	private FunctionService funcServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "org/add.do", method = RequestMethod.POST)
	@ResponseBody
	public String addOrg(OrgForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (form == null) {
				res.setCode(401);
				res.setDetail("Form data cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			TOrg org = orgServ.queryOrgByCode(form.getCode());
			if (org != null) {
				res.setCode(402);
				res.setDetail("Duplicated orgnization code");
				break;
			}

			TOrg parentOrg = orgServ.queryOrgById(form.getParentId());
			if (parentOrg == null) {
				res.setCode(403);
				res.setDetail("Parent orgnization not exist");
				break;
			}

			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(form.getParentId())) {
				res.setCode(404);
				res.setDetail("No permission to add orgnization under parent orgnization");
			}

			String id = orgServ.addOrg(form, parentOrg.getcRootId(), user.getcLoginname());
			if (id == null) {
				res.setCode(500);
				res.setDetail("Failed to add orgnization");
				break;
			}

			res.setData(id);

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "org/mod.do", method = RequestMethod.POST)
	@ResponseBody
	public String modOrg(OrgForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (form == null || form.getId() == null || form.getId().isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			if (form.getParentId() == null || form.getParentId().isEmpty()) {
				res.setCode(402);
				res.setDetail("Parent id cannot be empty");
				break;
			}

			TOrg org = orgServ.queryOrgByCodeWithExclusion(form.getCode(), form.getId());
			if (org != null) {
				res.setCode(403);
				res.setDetail("Duplicated orgnization code");
				break;
			}

			TOrg parentOrg = orgServ.queryOrgById(form.getParentId());
			if (parentOrg == null) {
				res.setCode(404);
				res.setDetail("Parent orgnization not exist");
				break;
			}

			if (form.getId() != parentOrg.getcRootId() && form.getParentId() == form.getId()) {
				res.setCode(403);
				res.setDetail("Parent orgnization cannot be self");
				break;
			}

			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(form.getParentId())) {
				res.setCode(405);
				res.setDetail("No permission to move orgnization to this parent orgnization");
				break;
			}

			if (!orgServ.modOrgById(form)) {
				res.setCode(500);
				res.setDetail("Failed to add orgnization");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "org/del.do", method = RequestMethod.POST)
	@ResponseBody
	public String delOrg(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			if (id == user.getcOrgId()) {
				res.setCode(402);
				res.setDetail("No permission to del self-orgnization");
				break;
			}

			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(id)) {
				res.setCode(403);
				res.setDetail("No permission to del parent orgnization");
				break;
			}

			if (!orgServ.delOrgById(id)) {
				res.setCode(500);
				res.setDetail("Failed to del orgnization");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "role/add.do", method = RequestMethod.POST)
	@ResponseBody
	public String addRole(RoleForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (form == null) {
				res.setCode(401);
				res.setDetail("Form data cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			TOrg org = orgServ.queryOrgById(form.getOrgId());
			if (org == null) {
				res.setCode(402);
				res.setDetail("Parent orgnization not exist");
				break;
			}

			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(form.getOrgId())) {
				res.setCode(403);
				res.setDetail("No permission to add role under parent orgnization");
			}

			String id = roleServ.addRole(form, user.getcLoginname());
			if (id == null) {
				res.setCode(501);
				res.setDetail("Failed to add role");
				break;
			}

			if (form.getStrFuncIds() != null && !form.getStrFuncIds().isEmpty()) {
				String[] funcIds = StringUtils.delimitedListToStringArray(form.getStrFuncIds(), ",");
				if (funcIds.length > 0) {
					if (!roleServ.addRoleRootFuncs(id, funcIds)) {
						res.setCode(502);
						res.setDetail("Failed to add role functions");
						break;
					}
				}
			}
			res.setData(id);

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "role/mod.do", method = RequestMethod.POST)
	@ResponseBody
	public String modRole(RoleForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (form == null || form.getId() == null || form.getId().isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			if (form.getId() == null || form.getId().isEmpty()) {
				res.setCode(402);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (form.getOrgId() == null || form.getOrgId().isEmpty()) {
				res.setCode(403);
				res.setDetail("Parent orgnization cannot be empty");
				break;
			}

			TOrg org = orgServ.queryOrgById(form.getOrgId());
			if (org == null) {
				res.setCode(404);
				res.setDetail("Parent orgnization not exist");
				break;
			}

			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(form.getOrgId())) {
				res.setCode(405);
				res.setDetail("No permission to move orgnization to this parent orgnization");
				break;
			}

			if (!roleServ.modRoleById(form)) {
				res.setCode(500);
				res.setDetail("Failed to mod orgnization");
				break;
			}

			roleServ.delRootFuncsByRoleId(form.getId());
			if (form.getStrFuncIds() != null && !form.getStrFuncIds().isEmpty()) {
				String[] funcIds = StringUtils.delimitedListToStringArray(form.getStrFuncIds(), ",");
				if (funcIds.length > 0) {
					if (!roleServ.addRoleRootFuncs(form.getId(), funcIds)) {
						res.setCode(502);
						res.setDetail("Failed to mod role functions");
						break;
					}
				}
			}
		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "role/del.do", method = RequestMethod.POST)
	@ResponseBody
	public String delRole(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			List<String> orgList = null;
			try {
				orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			} catch (Exception e) {
				res.setCode(501);
				res.setDetail("Unexpect error");
				break;
			}

			TRole role = null;
			try {
				role = roleServ.queryRoleById(id);
			} catch (Exception e) {
				res.setCode(502);
				res.setDetail("Unexpect error");
				break;
			}
			if (role == null) {
				res.setCode(402);
				res.setDetail("Cannot find role");
				break;
			}
			if (!orgList.contains(role.getcOrgId())) {
				res.setCode(403);
				res.setDetail("No permission to del role under parent orgnization");
			}

			roleServ.delExcFuncsByRoleId(id);
			roleServ.delRootFuncsByRoleId(id);
			if (!roleServ.delRoleById(id)) {
				res.setCode(500);
				res.setDetail("Failed to del orgnization");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "role/auth.do", method = RequestMethod.POST)
	@ResponseBody
	public String addRoleFunc(String id, String funcIds, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			// Validate param
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			if (funcIds == null) {
				res.setCode(402);
				res.setDetail("Func ids cannot be empty");
				break;
			}

			// Validate permission
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			// Validate role
			TRole role = roleServ.queryRoleById(id);
			if (role == null) {
				res.setCode(403);
				res.setDetail("Role not exist");
				break;
			}
			// Validate organization relation
			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(role.getcOrgId())) {
				res.setCode(404);
				res.setDetail("No permission to access parent orgnization");
				break;
			}

			// Get all available function ids for current role
			List<String> allFuncIdList = new ArrayList<String>();
			for (String rootFuncId : role.getRootFuncIds()) {
				allFuncIdList.addAll(funcServ.queryFuncIdListByRootId(rootFuncId));
			}

			// Collect submitted functions ids
			HashSet<String> funcIdList = new HashSet<String>();
			if (!funcIds.isEmpty()) {
				funcIdList.addAll(Arrays.asList(funcIds.split(",")));
			}

			// Work out exclude-function id and insert it
			roleServ.delExcFuncsByRoleId(id);
			for (String funcId : allFuncIdList) {
				if (!funcIdList.contains(funcId)) {
					if (!roleServ.addRoleExcFunc(id, funcId, user.getcLoginname())) {
						res.setCode(405);
						res.setDetail("Failed to authorize to current role");
						break;
					}
				}
			}

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "user/add.do", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(UserForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (form == null) {
				res.setCode(401);
				res.setDetail("Form data cannot be empty");
				break;
			}
			if (form.getOrgId() == null || form.getOrgId().isEmpty()) {
				res.setCode(402);
				res.setDetail("Org id cannot be empty");
				break;
			}

			if (form.getRoles() == null && form.getRoles().isEmpty()) {
				res.setCode(403);
				res.setDetail("Role ids cannot be empty");
				break;
			}
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser currentUser = userServ.getCachedUser();

			TOrg org = orgServ.queryOrgById(form.getOrgId());
			if (org == null) {
				res.setCode(404);
				res.setDetail("Parent orgnization not exist");
				break;
			}

			List<String> orgList = orgServ.queryOrgIdListByRootId(currentUser.getcOrgId());
			if (!orgList.contains(form.getOrgId())) {
				res.setCode(405);
				res.setDetail("No permission to add user under parent orgnization");
				break;
			}

			TUser user = this.userFormToTUser(form);
			user.setcOrgId(org.getcId());
			user.setcOrgRootId(org.getcRootId());

			String id = userServ.addUser(user, user.getcLoginname());
			if (id == null) {
				res.setCode(501);
				res.setDetail("Failed to add role");
				break;
			}

			for (String roleId : form.getRoles().split(",")) {
				if (roleServ.roleExists(roleId)) {
					// Add user/role relation
					if (!userServ.addUserRole(id, roleId)) {
						res.setCode(502);
						res.setDetail("Failed to add user-role relation");
						break;
					}
				}
			}

			res.setData(id);
		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "user/mod.do", method = RequestMethod.POST)
	@ResponseBody
	public String modUser(UserForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (form == null) {
				res.setCode(401);
				res.setDetail("Form data cannot be empty");
				break;
			}
			if (form.getUserId() == null || form.getUserId().isEmpty()) {
				res.setCode(402);
				res.setDetail("User id cannot be empty");
				break;
			}
			if (form.getOrgId() == null || form.getOrgId().isEmpty()) {
				res.setCode(403);
				res.setDetail("Org id cannot be empty");
				break;
			}
			if (form.getRoles() == null && form.getRoles().isEmpty()) {
				res.setCode(404);
				res.setDetail("Role ids cannot be empty");
				break;
			}
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser currentUser = userServ.getCachedUser();

			TOrg org = orgServ.queryOrgById(form.getOrgId());
			if (org == null) {
				res.setCode(405);
				res.setDetail("Parent orgnization not exist");
				break;
			}

			List<String> orgList = orgServ.queryOrgIdListByRootId(currentUser.getcOrgId());
			if (!orgList.contains(form.getOrgId())) {
				res.setCode(406);
				res.setDetail("No permission to add user under parent orgnization");
				break;
			}

			TUser user = this.userFormToTUser(form);
			user.setcOrgId(org.getcId());
			user.setcOrgRootId(org.getcRootId());
			
			if (!userServ.modUserById(user)) {
				res.setCode(501);
				res.setDetail("Failed to add role");
				break;
			}

			userServ.delUserRolesByUserId(user.getcId());
			for (String roleId : form.getRoles().split(",")) {
				if (roleServ.roleExists(roleId)) {
					// Add user/role relation
					if (!userServ.addUserRole(form.getUserId(), roleId)) {
						res.setCode(502);
						res.setDetail("Failed to add user-role relation");
						break;
					}
				}
			}

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "user/del.do", method = RequestMethod.POST)
	@ResponseBody
	public String delUser(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}


			TUser currentUser = userServ.getCachedUser();
			TUser targetUser = userServ.queryUserById(id);

			List<String> orgList = orgServ.queryOrgIdListByRootId(currentUser.getcOrgId());
			if (!orgList.contains(targetUser.getcOrgId())) {
				res.setCode(406);
				res.setDetail("No permission to del user under parent orgnization");
				break;
			}

			userServ.delUserRolesByUserId(id);
			if (!userServ.delUserById(id)) {
				res.setCode(501);
				res.setDetail("Failed to delete user");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "user/enable.do", method = RequestMethod.POST)
	@ResponseBody
	public String enableUser(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser currentUser = userServ.getCachedUser();
			TUser targetUser = userServ.queryUserById(id);

			List<String> orgList = orgServ.queryOrgIdListByRootId(currentUser.getcOrgId());
			if (!orgList.contains(targetUser.getcOrgId())) {
				res.setCode(406);
				res.setDetail("No permission to access user under parent orgnization");
				break;
			}

			if (!userServ.enableUserById(id)) {
				res.setCode(501);
				res.setDetail("Failed to enable user");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "user/disable.do", method = RequestMethod.POST)
	@ResponseBody
	public String disableUser(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}


			TUser currentUser = userServ.getCachedUser();
			TUser targetUser = userServ.queryUserById(id);

			List<String> orgList = orgServ.queryOrgIdListByRootId(currentUser.getcOrgId());
			if (!orgList.contains(targetUser.getcOrgId())) {
				res.setCode(406);
				res.setDetail("No permission to access user under parent orgnization");
				break;
			}

			if (!userServ.disableUserById(id)) {
				res.setCode(501);
				res.setDetail("Failed to disable user");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "user/query.do", method = RequestMethod.POST)
	@ResponseBody
	public String queryUser(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionById("7-4")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}


			TUser currentUser = userServ.getCachedUser();
			TUser targetUser = userServ.queryUserById(id);

			List<String> orgList = orgServ.queryOrgIdListByRootId(currentUser.getcOrgId());
			if (!orgList.contains(targetUser.getcOrgId())) {
				res.setCode(406);
				res.setDetail("No permission to access user under parent orgnization");
				break;
			}

			TUser user = userServ.queryUserById(id);
			if (user == null) {
				res.setCode(501);
				res.setDetail("Failed to disable user");
				break;
			}

			res.setData(user);
		} while (false);

		return gson.toJson(res);
	}

	public TUser userFormToTUser(UserForm form){
		TUser user = new TUser();
		user.setcId(form.getUserId());
		user.setcLoginname(form.getLoginName());
		user.setcLoginpass(form.getLoginPass());
		user.setcNickname(form.getNickName());
		user.setcAvailable(true);
		user.setcOrgId(form.getOrgId());
		user.setcEmail(form.getEmail());
		user.setcPhone(form.getPhone());
		user.setcQq(form.getIm());
		user.setcRealname(form.getRealName());
		return user;
	}
	
	@RequestMapping(value = "func/add.do", method = RequestMethod.POST)
	@ResponseBody
	public String addFunc(OrgForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "func/mod.do", method = RequestMethod.POST)
	@ResponseBody
	public String modFunc(OrgForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "func/del.do", method = RequestMethod.POST)
	@ResponseBody
	public String delFunc(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
		} while (false);

		return gson.toJson(res);
	}
}
