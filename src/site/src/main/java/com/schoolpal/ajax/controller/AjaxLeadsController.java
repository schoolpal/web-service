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
import com.schoolpal.db.model.TLeads;
import com.schoolpal.db.model.TLeadsParent;
import com.schoolpal.db.model.TLeadsStudent;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.LeadsService;
import com.schoolpal.service.UserService;

@Controller
@RequestMapping("/ajax/mkt/leads")
public class AjaxLeadsController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private LeadsService leadsServ;
	
	private Gson gson = new Gson();

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public String list(String orgnizationId) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("1-2")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (orgnizationId == null){
				res.setCode(401);
				res.setDetail("Orgnization id cannot be empty");
				break;
			}
			
			List<TLeads> acts = null;
			acts = leadsServ.queryLeadsByOrgId(orgnizationId);
			res.setData(acts);

		} while (false);

		return gson.toJson(res);
	}

	protected class LeadsAddResponse{
		private String leads_id;
		private String parent_id;
		private String student_id;
		
		public LeadsAddResponse(String leads_id, String parent_id, String student_id){
			this.leads_id = leads_id;
			this.parent_id = parent_id;
			this.student_id = student_id;
		}
	}
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(TLeads leads, TLeadsStudent student, TLeadsParent parent, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (leads == null) {
				res.setCode(401);
				res.setDetail("Leads data cannot be empty");
				break;
			}
			if (student == null) {
				res.setCode(402);
				res.setDetail("Student data cannot be empty");
				break;
			}
			if (parent == null) {
				res.setCode(403);
				res.setDetail("Parent data cannot be empty");
				break;
			}

			if (leads.getOrgnizationId() == null){
				res.setCode(411);
				res.setDetail("Orgnization id cannot be empty");
				break;
			}			
			if (leads.getSource() == null){
				res.setCode(412);
				res.setDetail("Source cannot be empty");
				break;
			}
			if (leads.getStage() == null){
				res.setCode(413);
				res.setDetail("Stage cannot be empty");
				break;
			}
			if (leads.getChannel() == null){
				res.setCode(414);
				res.setDetail("Channel cannot be empty");
				break;
			}
			if (leads.getStatus() == null){
				res.setCode(415);
				res.setDetail("Status cannot be empty");
				break;
			}
			
			if (student.getName() == null){
				res.setCode(421);
				res.setDetail("Student name cannot be empty");
				break;
			}
			if (student.getAge() == null){
				res.setCode(422);
				res.setDetail("Student age cannot be empty");
				break;
			}
			
			if (parent.getName() == null){
				res.setCode(423);
				res.setDetail("parent name cannot be empty");
				break;
			}
			if (parent.getCellphone() == null){
				res.setCode(424);
				res.setDetail("Parent phone cannot be empty");
				break;
			}
			
			TUser user = userServ.getCachedUser();
			
			leads.setCreatorId(user.getcId());			
			if(leads.getExecutiveId() == null){
				leads.setExecutiveId(user.getcId());
			}
			if (leadsServ.addLeads(leads) == null){
				res.setCode(500);
				res.setDetail("Failed to add leads");
				break;
			}
			
			student.setLeadsId(leads.getId());
			student.setCreatorId(user.getcId());
			if (leadsServ.addStudent(student) == null){
				res.setCode(501);
				res.setDetail("Failed to add student");
				break;
			}
			
			parent.setLeadsId(leads.getId());
			parent.setCreatorId(user.getcId());
			if (leadsServ.addParent(parent) == null){
				res.setCode(502);
				res.setDetail("Failed to add parent");
				break;
			}
			
			LeadsAddResponse data = new LeadsAddResponse(leads.getId(), parent.getId(), student.getId());
			res.setData(data);
			
		} while (false);

		return gson.toJson(res);
	}
	
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@ResponseBody
	public String mod(TLeads leads, TLeadsStudent student, TLeadsParent parent, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (leads == null) {
				res.setCode(401);
				res.setDetail("Leads data cannot be empty");
				break;
			}
			if (student == null) {
				res.setCode(402);
				res.setDetail("Student data cannot be empty");
				break;
			}
			if (parent == null) {
				res.setCode(403);
				res.setDetail("Parent data cannot be empty");
				break;
			}

			if (leads.getId() == null){
				res.setCode(411);
				res.setDetail("Leads id cannot be empty");
				break;
			}
			if (StringUtils.isEmpty(student.getId())){
				student.setLeadsId(leads.getId());
			}
			if (StringUtils.isEmpty(parent.getId())){
				parent.setLeadsId(leads.getId());
			}
			
			if (!leadsServ.modLeads(leads)){
				res.setCode(500);
				res.setDetail("Failed to mod leads");
				break;
			}
			
			if (!leadsServ.modStudent(student)){
				res.setCode(501);
				res.setDetail("Failed to mod student");
				break;
			}
			
			if (!leadsServ.modParent(parent)){
				res.setCode(502);
				res.setDetail("Failed to mod parent");
				break;
			}
			
			res.setData(leads.getId());
			
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
			
			if (id == null || id.length() <= 0) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			
			if (!leadsServ.delLeadsById(id) || !leadsServ.delParentByLeadsId(id) || !leadsServ.delStudentByLeadsId(id)){
				res.setCode(500);
				res.setDetail("Failed to del leads");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}
}
