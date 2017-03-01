package com.schoolpal.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.db.model.TOrg;
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

	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@ResponseBody
	public String query(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();
			
			List<String> orgList = orgServ.getOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(id)) {
				res.setCode(401);
				res.setDetail("No permission to query orgnization");
			}
			
			TOrg org = null;
			try{
				org = orgServ.getOrgById(id);
				if (org == null){
					res.setCode(402);
					res.setDetail("Failed to query orgnization");
					break;
				}
			}catch(Exception e){
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
	public String add(OrgForm form) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();
			
			TOrg org = orgServ.getOrgByCode(form.getCode());
			if (org != null) {
				res.setCode(401);
				res.setDetail("Duplicated orgnization code");
				break;
			}
			
			TOrg parentOrg = orgServ.getOrgById(form.getParentId());
			if (parentOrg == null) {
				res.setCode(402);
				res.setDetail("Parent orgnization not exist");
				break;
			}
			
			List<String> orgList = orgServ.getOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(form.getParentId())) {
				res.setCode(403);
				res.setDetail("No permission to add orgnization under parent orgnization");
			}
			
			String id = orgServ.AddOrg(form, parentOrg.getcRootId(), user.getcLoginname());
			if (id == null){
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
			
			TOrg org = orgServ.getOrgByCodeWithExclusion(form.getCode(), form.getId());
			if (org != null) {
				res.setCode(401);
				res.setDetail("Duplicated orgnization code");
				break;
			}
			
			TOrg parentOrg = orgServ.getOrgById(form.getParentId());
			if (parentOrg == null) {
				res.setCode(402);
				res.setDetail("Parent orgnization not exist");
				break;
			}
			
			List<String> orgList = orgServ.getOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(form.getParentId())) {
				res.setCode(403);
				res.setDetail("No permission to move orgnization to this parent orgnization");
				break;
			}
			
			if (!orgServ.ModOrgById(form)){
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

			if (id == user.getcOrgId()) {
				res.setCode(401);
				res.setDetail("No permission to del self-orgnization");
				break;
			}
			
			List<String> orgList = orgServ.getOrgIdListByRootId(user.getcOrgId());
			if (!orgList.contains(id)) {
				res.setCode(402);
				res.setDetail("No permission to del parent orgnization");
				break;
			}
			
			if (!orgServ.DeleteOrgById(id)){
				res.setCode(500);
				res.setDetail("Failed to del orgnization");
				break;
			}
			
		} while (false);
		
		return gson.toJson(res);
	}

}
