package com.schoolpal.ajax.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.ajax.AuthorizationHelper;
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
@RequestMapping("/ajax/org")
public class AjaxOrgController {

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
