package com.schoolpal.ajax.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.db.model.*;
import com.schoolpal.service.*;

@Controller
@RequestMapping("/ajax/func")
public class AjaxFuncController {

	// @Autowired
	// private LogService logServ;
	@Autowired
	private UserService userServ;
	// @Autowired
	// private OrgService orgServ;
	// @Autowired
	// private RoleService roleServ;
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
	public String listFuncs(String ids) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (ids == null || ids.isEmpty()){
				res.setCode(401);
				res.setDetail("Cannot find cached profile data, not login?");
				break;
			}
			
			TUser user = userServ.getCachedUser();
			if (user == null) {
				// Since shiro filter will intercept if not login, this code
				// should
				// never be reached
				res.setCode(500);
				res.setDetail("Cannot find cached profile data, not login?");
				break;
			}
			
			List<TFunction> funcList = new ArrayList<TFunction>();
			for (String id : StringUtils.split(ids, ",")) {
				if (!id.isEmpty()) {
					List<TFunction> funcs = funcServ.queryFuncListByRootId(id);
					if (funcs != null && funcs.size() > 0) {
						funcList.addAll(funcs);
					}
				}
			}
			res.setData(funcList);
		} while (false);

		return gson.toJson(res);
	}

}
