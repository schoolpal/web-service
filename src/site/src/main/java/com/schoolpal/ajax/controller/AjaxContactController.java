package com.schoolpal.ajax.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.ajax.AuthorizationHelper;
import com.schoolpal.db.model.TActivity;
import com.schoolpal.db.model.TContact;
import com.schoolpal.db.model.TLeads;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.ActivityService;
import com.schoolpal.service.ContactService;
import com.schoolpal.service.LeadsService;
import com.schoolpal.service.UserService;

@Controller
@RequestMapping("/ajax/contact")
public class AjaxContactController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private LeadsService leadsServ;
	@Autowired
	private ContactService contactServ;
	
	private Gson gson = new Gson();

	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@ResponseBody
	public String query(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (StringUtils.isEmpty(id)) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			
			TContact contact = contactServ.queryContactById(id);
			if (contact == null){
				res.setCode(402);
				res.setDetail("Invalid contact id");
				break;
			}
			
			String permId = this.getModPermIdByLeadsId(contact.getLeadsId());
			if (!AuthorizationHelper.CheckPermissionById(permId)){
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			res.setData(contact);

		} while (false);

		return gson.toJson(res);
	}
	
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public String list(String leadsId) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (StringUtils.isEmpty(leadsId)){
				res.setCode(401);
				res.setDetail("Leads id cannot be empty");
				break;
			}
			
			String permId = this.getQueryPermIdByLeadsId(leadsId);
			if (!AuthorizationHelper.CheckPermissionById(permId)){
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			List<TContact> acts = null;
			acts = contactServ.queryContactsByLeadsId(leadsId);
			res.setData(acts);

		} while (false);

		return gson.toJson(res);
	}

	private String getQueryPermIdByLeadsId(String id){
		String permId = "";
		
		TLeads leads = leadsServ.queryLeadsById(id);
		if (leads != null){		
			switch (leads.getTypeId()){
			case 1:
				permId = "1-2";
				break;
			case 2:
				permId = "2-1";
				break;
			case 3:
				permId = "2-2";
				break;
			default:
				permId = "";
				break;
			}
		}
		
		return permId;
	}
	
	private String getModPermIdByLeadsId(String id){
		String permId = "";
		
		TLeads leads = leadsServ.queryLeadsById(id);
		if (leads != null){		
			switch (leads.getTypeId()){
			case 1:
				permId = "1-2-2";
				break;
			case 2:
				permId = "2-1-2";
				break;
			case 3:
				permId = "2-2-2";
				break;
			default:
				permId = "";
				break;
			}
		}
		
		return permId;
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(TContact contact, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (contact == null) {
				res.setCode(401);
				res.setDetail("From data cannot be empty");
				break;
			}

			if (contact.getLeadsId() == null){
				res.setCode(402);
				res.setDetail("Leads id cannot be empty");
				break;
			}
			if (contact.getApproach() == null){
				res.setCode(403);
				res.setDetail("Approach id cannot be empty");
				break;
			}
			if (contact.getExecutiveId() == null){
				res.setCode(404);
				res.setDetail("Executive id cannot be empty");
				break;
			}
			
			String permId = this.getModPermIdByLeadsId(contact.getLeadsId());
			if (!AuthorizationHelper.CheckPermissionById(permId)){
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			TUser user = userServ.getCachedUser();
			contact.setExecutiveId(user.getcId());
			
			if (contactServ.addContact(contact) == null){
				res.setCode(500);
				res.setDetail("Failed to add activity");
				break;
			}
			
			res.setData(contact.getId());
			
		} while (false);

		return gson.toJson(res);
	}
	
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@ResponseBody
	public String mod(TContact contact, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (contact == null) {
				res.setCode(401);
				res.setDetail("From data cannot be empty");
				break;
			}

			if (StringUtils.isEmpty(contact.getId())) {
				res.setCode(401);
				res.setDetail("Contact id cannot be empty");
				break;
			}

			String permId = this.getModPermIdByLeadsId(contact.getLeadsId());
			if (!AuthorizationHelper.CheckPermissionById(permId)){
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (!contactServ.modConact(contact)){
				res.setCode(500);
				res.setDetail("Failed to mod activity");
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
			if (StringUtils.isEmpty(id)) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			
			TContact contact = contactServ.queryContactById(id);
			if (contact == null){
				res.setCode(402);
				res.setDetail("Invalid contact id");
				break;
			}
			
			String permId = this.getModPermIdByLeadsId(contact.getLeadsId());
			if (!AuthorizationHelper.CheckPermissionById(permId)){
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (!contactServ.delContactById(id)){
				res.setCode(500);
				res.setDetail("Failed to del activity");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}
	
}
