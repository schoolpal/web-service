package com.schoolpal.ajax.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "listRootFuncs.do", method = RequestMethod.POST)
	@ResponseBody
	public String listRootFuncs() {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro filter will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			List<TFunction> rootFuncs = funcServ.queryRootFuncList();
			res.setData(rootFuncs);
		}
		return gson.toJson(res);
	}

	@RequestMapping(value = "listAllFuncs.do", method = RequestMethod.POST)
	@ResponseBody
	public String listAllFuncs() {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro filter will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			List<TFunction> rootFuncs = funcServ.queryAllFuncList();
			res.setData(rootFuncs);
		}
		return gson.toJson(res);
	}

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public String listFuncs(String id) {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro filter will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			List<TFunction> rootFuncs = funcServ.queryFuncListByRootId(id);
			res.setData(rootFuncs);
		}
		return gson.toJson(res);
	}


}
