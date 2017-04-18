package com.schoolpal.ajax.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.ajax.AuthorizationHelper;
import com.schoolpal.db.model.TActivity;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.UserService;

@Controller
@RequestMapping("/ajax/mkt/activity")
public class AjaxActivityController {
	
	@Autowired
	private UserService userServ;
	
	private Gson gson = new Gson();

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public String listRoles(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("1-1")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			TUser user = userServ.getCachedUser();

			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(TActivity act, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			TUser user = userServ.getCachedUser();

			if (act == null) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}
	
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@ResponseBody
	public String mod(TActivity act, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			TUser user = userServ.getCachedUser();

			if (act == null) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}
	
	@RequestMapping(value = "del.do", method = RequestMethod.POST)
	@ResponseBody
	public String del(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			TUser user = userServ.getCachedUser();

			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}
	
}
