package com.schoolpal.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.db.model.*;
import com.schoolpal.service.*;

@Controller
@RequestMapping("/ajax/org")
public class AjaxOrgController {

//	@Autowired
//	private LogService logServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private OrgService orgServ;
	@Autowired
	private RoleService roleServ;
//	@Autowired
//	private FunctionService funcServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "listRoles.do", method = RequestMethod.POST)
	@ResponseBody
	public String listRoles(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();

			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(id)) {
				res.setCode(402);
				res.setDetail("No permission to query orgnization");
				break;
			}

			List<TRole> roles = null;
			try {
				roles = roleServ.queryRoleListByOrgId(id);
				if (roles == null) {
					res.setCode(403);
					res.setDetail("Cannot find orgnization");
					break;
				}
			} catch (Exception e) {
				res.setCode(500);
				res.setDetail("Unexpect error");
				break;
			}

			res.setData(roles);

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "listUsers.do", method = RequestMethod.POST)
	@ResponseBody
	public String listUsers(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();

			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(id)) {
				res.setCode(402);
				res.setDetail("No permission to query orgnization");
				break;
			}

			List<TUser> users = null;
			try {
				users = userServ.queryUsersByOrgId(id);
				if (users == null) {
					res.setCode(403);
					res.setDetail("Cannot find orgnization");
					break;
				}
			} catch (Exception e) {
				res.setCode(500);
				res.setDetail("Unexpect error");
				break;
			}

			res.setData(users);

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@ResponseBody
	public String query(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();

			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			List<String> orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(id)) {
				res.setCode(402);
				res.setDetail("No permission to query orgnization");
			}

			TOrg org = null;
			try {
				org = orgServ.queryOrgById(id);
				if (org == null) {
					res.setCode(403);
					res.setDetail("Cannot find orgnization");
					break;
				}
			} catch (Exception e) {
				res.setCode(500);
				res.setDetail("Unexpect error");
				break;
			}

			res.setData(org);

		} while (false);

		return gson.toJson(res);
	}


}
