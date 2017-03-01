package com.schoolpal.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TRole;
import com.schoolpal.db.model.TRoleFunction;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.FunctionService;
import com.schoolpal.service.LogService;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.RoleService;
import com.schoolpal.service.UserService;
import com.schoolpal.web.consts.LogLevel;
import com.schoolpal.web.model.OrgForm;
import com.schoolpal.web.model.RoleForm;

@Controller
@RequestMapping("/ajax/role")
public class AjaxRoleController {

	@Autowired
	private LogService logServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private OrgService orgServ;
	@Autowired
	private RoleService roleServ;
	@Autowired
	private FunctionService funcServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@ResponseBody
	public String query(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();
			
			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(id)) {
				res.setCode(401);
				res.setDetail("No permission to query role under parent orgnization");
			}
			
			TRole role = null;
			try{
				role = roleServ.queryRoleById(id);
				if (role == null){
					res.setCode(402);
					res.setDetail("Cannot find role");
					break;
				}
			}catch(Exception e){
				res.setCode(500);
				res.setDetail("Unexpect error");
				break;
			}
			
			res.setData(role);
			
		} while (false);
		
		return gson.toJson(res);
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(RoleForm form) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();
			
			TOrg org = orgServ.queryOrgById(form.getOrgId());
			if (org == null) {
				res.setCode(401);
				res.setDetail("Parent orgnization not exist");
				break;
			}
			
			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(form.getOrgId())) {
				res.setCode(402);
				res.setDetail("No permission to add role under parent orgnization");
			}
			
			String id = roleServ.addRole(form, user.getcLoginname());
			if (id == null){
				res.setCode(501);
				res.setDetail("Failed to add role");
				break;
			}
			
			if(form.getStrFuncIds()!= null && !form.getStrFuncIds().isEmpty()){
				String[] funcIds = StringUtils.delimitedListToStringArray(form.getStrFuncIds(), ",");
				if (funcIds.length > 0){
					if (!roleServ.addRoleFuncs(id, funcIds)){
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

	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@ResponseBody
	public String mod(RoleForm form) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();
			
			if (form.getId() == null || form.getId().isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			
			if (form.getOrgId() == null || form.getOrgId().isEmpty()) {
				res.setCode(402);
				res.setDetail("Parent orgnization cannot be empty");
				break;
			}
			
			TOrg org = orgServ.queryOrgById(form.getOrgId());
			if (org == null) {
				res.setCode(403);
				res.setDetail("Parent orgnization not exist");
				break;
			}
			
			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(form.getOrgId())) {
				res.setCode(404);
				res.setDetail("No permission to move orgnization to this parent orgnization");
				break;
			}
			
			if (!roleServ.modRoleById(form)){
				res.setCode(500);
				res.setDetail("Failed to mod orgnization");
				break;
			}
			
			roleServ.delRoleFuncs(form.getId());
			if(form.getStrFuncIds()!= null && !form.getStrFuncIds().isEmpty()){
				String[] funcIds = StringUtils.delimitedListToStringArray(form.getStrFuncIds(), ",");
				if (funcIds.length > 0){
					if (!roleServ.addRoleFuncs(form.getId(), funcIds)){
						res.setCode(502);
						res.setDetail("Failed to mod role functions");
						break;
					}
				}
			}			
		} while (false);
		
		return gson.toJson(res);
	}
	
	@RequestMapping(value = "del.do", method = RequestMethod.POST)
	@ResponseBody
	public String del(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();

			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(id)) {
				res.setCode(402);
				res.setDetail("No permission to del this role under parent orgnization");
				break;
			}
			
			roleServ.delRoleFuncs(id);
			if (!roleServ.delRoleById(id)){
				res.setCode(500);
				res.setDetail("Failed to del orgnization");
				break;
			}
			
		} while (false);
		
		return gson.toJson(res);
	}

}
