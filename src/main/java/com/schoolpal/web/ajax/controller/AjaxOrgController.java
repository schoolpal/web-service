package com.schoolpal.web.ajax.controller;

import com.google.gson.Gson;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TRole;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.RoleService;
import com.schoolpal.service.UserService;
import com.schoolpal.web.ajax.model.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
	public AjaxResponse listRoles(String id) {
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
				roles = roleServ.queryRoleListByOrgIdLite(id);
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

		return res;
	}

	@RequestMapping(value = "listUsers.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse listUsers(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();

			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), id)) {
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

		return res;
	}

	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse query(String id) {
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
				org.setParentOrg(orgServ.queryOrgById(org.getcId()));
			} catch (Exception e) {
				res.setCode(500);
				res.setDetail("Unexpect error");
				break;
			}

			res.setData(org);

		} while (false);

		return res;
	}


}
