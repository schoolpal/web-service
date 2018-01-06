package com.schoolpal.web.ajax.controller;

import com.google.gson.Gson;
import com.schoolpal.db.model.TFunction;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.FunctionService;
import com.schoolpal.service.UserService;
import com.schoolpal.web.ajax.model.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ajax/func")
public class AjaxFuncController {

	@Autowired
	private UserService userServ;
	@Autowired
	private FunctionService funcServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "listRootFuncs.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse listRootFuncs() {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro shiro will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			List<TFunction> rootFuncs = funcServ.queryRootFuncList();
			res.setData(rootFuncs);
		}
		return res;
	}

	@RequestMapping(value = "listAllFuncs.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse listAllFuncs() {
		TUser user = userServ.getCachedUser();
		AjaxResponse res = new AjaxResponse(200);
		if (user == null) {
			// Since shiro shiro will intercept if not login, this code should
			// never be reached
			res.setCode(500);
			res.setDetail("Cannot find cached profile data, not login?");
		} else {
			List<TFunction> rootFuncs = funcServ.queryAllFuncList();
			res.setData(rootFuncs);
		}
		return res;
	}

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse listFuncs(String ids) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (ids == null || ids.isEmpty()){
				res.setCode(401);
				res.setDetail("Cannot find cached profile data, not login?");
				break;
			}
			
			TUser user = userServ.getCachedUser();
			if (user == null) {
				// Since shiro shiro will intercept if not login, this code
				// should
				// never be reached
				res.setCode(500);
				res.setDetail("Cannot find cached profile data, not login?");
				break;
			}
			
			List<TFunction> funcList = new ArrayList<TFunction>();
			for (String id : ids.split(",")) {
				if (!id.isEmpty()) {
					List<TFunction> funcs = funcServ.queryFuncListByRootId(id);
					if (funcs != null && funcs.size() > 0) {
						funcList.addAll(funcs);
					}
				}
			}
			res.setData(funcList);
		} while (false);

		return res;
	}

}
