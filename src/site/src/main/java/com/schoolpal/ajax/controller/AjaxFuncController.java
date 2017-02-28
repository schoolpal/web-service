package com.schoolpal.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.db.model.TFunction;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TRole;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.FunctionService;
import com.schoolpal.service.LogService;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.RoleService;
import com.schoolpal.service.UserService;
import com.schoolpal.web.model.OrgForm;

@Controller
@RequestMapping("/ajax/func")
public class AjaxFuncController {

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

	@RequestMapping(value = "listByRole.do", method = RequestMethod.POST)
	@ResponseBody
	public String listByRole(String roleId) {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro filter will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			TRole role = roleServ.getRoleById(roleId);
			if (!orgServ.getOrgIdListByRootId(user.getcOrgId()).contains(role.getcOrgId())) {
				res.setCode(401);
				res.setDetail("No permission for this orgnization");
			} else {
				List<TFunction> funcList = funcServ.getFuncListByRoleId(roleId);
				res.setData(funcList);
			}
		}
		return gson.toJson(res);
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(OrgForm form) {
		AjaxResponse res = new AjaxResponse(200);
		do {
		} while (false);
		
		return gson.toJson(res);
	}

	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@ResponseBody
	public String mod(OrgForm form) {
		AjaxResponse res = new AjaxResponse(200);
		do {
		} while (false);
		
		return gson.toJson(res);
	}
	
	@RequestMapping(value = "del.do", method = RequestMethod.POST)
	@ResponseBody
	public String del(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
		} while (false);
		
		return gson.toJson(res);
	}

}
