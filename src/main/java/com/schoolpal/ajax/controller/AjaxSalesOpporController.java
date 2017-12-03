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
import com.schoolpal.ajax.model.AjaxResponse;
import com.schoolpal.ajax.helper.AuthorizationHelper;
import com.schoolpal.db.model.TLeads;
import com.schoolpal.db.model.TLeadsParent;
import com.schoolpal.db.model.TLeadsStudent;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.LeadsService;
import com.schoolpal.service.UserService;

@Controller
@RequestMapping("/ajax/sales/oppor")
public class AjaxSalesOpporController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private LeadsService leadsServ;
	
	private Gson gson = new Gson();

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse list(String orgId, Integer typeId) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("2-1")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (orgId == null){
				res.setCode(401);
				res.setDetail("Orgnization id cannot be empty");
				break;
			}
			
			List<TLeads> leadsList = null;
			leadsList = leadsServ.queryLeadsListByOrgId(orgId, typeId);
			res.setData(leadsList);

		} while (false);

		return res;
	}

	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse query(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("2-1")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (StringUtils.isEmpty(id)){
				res.setCode(401);
				res.setDetail("Orgnization id cannot be empty");
				break;
			}
			
			TLeads leads = null;
			leads = leadsServ.queryLeadsById(id);
			res.setData(leads);

		} while (false);

		return res;
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse add(TLeads leads, TLeadsStudent student, TLeadsParent parent, HttpServletRequest request) {
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
			if (leads.getSourceId() == null){
				res.setCode(412);
				res.setDetail("Source cannot be empty");
				break;
			}
			if (leads.getStageId() == null){
				res.setCode(413);
				res.setDetail("Stage cannot be empty");
				break;
			}
			if (leads.getChannelId() == null){
				res.setCode(414);
				res.setDetail("Channel cannot be empty");
				break;
			}
			if (leads.getStatusId() == null){
				res.setCode(415);
				res.setDetail("Status cannot be empty");
				break;
			}
			if (leads.getTypeId() == null || (leads.getTypeId() != 2 && leads.getTypeId() != 3) ){
				res.setCode(411);
				res.setDetail("Type id cannot be empty");
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
			if(leadsServ.add(leads, student, parent, user.getcId()) == null){
				res.setCode(500);
				res.setDetail("Failed to add leads");
				break;
			}
			res.setData(leads.getId());
			
		} while (false);

		return res;
	}
	
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse mod(TLeads leads, TLeadsStudent student, TLeadsParent parent, HttpServletRequest request) {
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
			
			leads.setTypeId(null);
			if (!leadsServ.mod(leads, student, parent)){
				res.setCode(500);
				res.setDetail("Failed to mod leads");
				break;
			}
			
		} while (false);

		return res;
	}
	
	@RequestMapping(value = "del.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse del(String id, HttpServletRequest request) {
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
			
			if (!leadsServ.delById(id)){
				res.setCode(500);
				res.setDetail("Failed to del leads");
				break;
			}

		} while (false);

		return res;
	}
	
	@RequestMapping(value = "assign.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse assign(String id, String assigneeId, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (StringUtils.isEmpty(id)) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			if (StringUtils.isEmpty(assigneeId)) {
				res.setCode(402);
				res.setDetail("Assignee id cannot be empty");
				break;
			}
			
			if (!leadsServ.assignToExecutiveById(id, assigneeId)){
				res.setCode(500);
				res.setDetail("Failed to assign leads");
				break;
			}

		} while (false);

		return res;
	}

}
