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

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(OrgForm form, HttpServletRequest request) {	    
		AjaxResponse res = new AjaxResponse(200);
		do {
//		    String mappedPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
//		    String permissionId = funcServ.getFunctionIdByActionPath(mappedPath);
//			Subject currentUser = SecurityUtils.getSubject();
//			if(!currentUser.isPermitted(permissionId)){
//				res.setCode(400);
//				res.setDetail("No permission");
//				break;
//			}
			
			TUser user = userServ.getCachedUser();

			if (form == null) {
				res.setCode(401);
				res.setDetail("Form data cannot be empty");
				break;
			}

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

	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@ResponseBody
	public String mod(OrgForm form) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();

			if (form == null || form.getId() == null || form.getId().isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

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

	@RequestMapping(value = "del.do", method = RequestMethod.POST)
	@ResponseBody
	public String del(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();

			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

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

}
