package com.schoolpal.web.ajax.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import com.schoolpal.web.ajax.model.AjaxResponse;
import com.schoolpal.web.helper.AuthorizationHelper;
import com.schoolpal.db.model.TActivity;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.ActivityService;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.UserService;

@Controller
@RequestMapping("/ajax/mkt/activity")
public class AjaxActivityController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private ActivityService actServ;
	@Autowired
	private OrgService orgServ;
	
	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse query(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("1-1")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (id == null){
				res.setCode(401);
				res.setDetail("Orgnization id cannot be empty");
				break;
			}
			
			TActivity act = actServ.queryActivityById(id);
			if (act == null){
				res.setCode(500);
				res.setDetail("Failed to query activity");
				break;
			}
			res.setData(act);

		} while (false);

		return res;
	}
	
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse list(String orgnizationId) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("1-1")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (orgnizationId == null){
				res.setCode(401);
				res.setDetail("Orgnization id cannot be empty");
				break;
			}
			
			List<TActivity> acts = null;
			acts = actServ.queryActivitiesByOrgId(orgnizationId);
			res.setData(acts);

		} while (false);

		return res;
	}

	protected class listTreeResponse{
		private List<TOrg> orgList = null;
		private Map<String, List<TActivity>> actListMap = null;
		
		public listTreeResponse(List<TOrg> orgList, Map<String, List<TActivity>> actListMap){
			this.orgList = orgList;
			this.actListMap = actListMap;
		}
	}

	@RequestMapping(value = "listTree.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse listTree(String orgId) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("1")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (orgId == null){
				res.setCode(401);
				res.setDetail("Orgnization id cannot be empty");
				break;
			}
			
			List<TOrg> orgList = orgServ.queryUpperOrgListByIdLite(orgId);
			Map<String, List<TActivity>> actListMap = new HashMap<String, List<TActivity>>();
			
			for (TOrg org : orgList){
				List<TActivity> actList = actServ.queryActivitiesByOrgId(org.getcId());
				actListMap.put(org.getcId(), actList);
			}
			
			listTreeResponse data = new listTreeResponse(orgList, actListMap);
			res.setData(data);

		} while (false);

		return res;
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse add(TActivity act, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (act == null) {
				res.setCode(401);
				res.setDetail("From data cannot be empty");
				break;
			}

			if (act.getOrgnizationId() == null){
				res.setCode(402);
				res.setDetail("Orgnization id cannot be empty");
				break;
			}
			
			if (act.getParentId() == null){
				act.setRootId(null);
			}else{
				TActivity parent = actServ.queryActivityById(act.getParentId());
				if (parent == null){
					res.setCode(403);
					res.setDetail("Invalid parent id");
					break;
				}
				act.setRootId(parent.getRootId());
			}
			
			TUser user = userServ.getCachedUser();
			act.setCreatorId(user.getcId());
			
			if (actServ.addActivity(act) == null){
				res.setCode(500);
				res.setDetail("Failed to add activity");
				break;
			}
			if (act.getRootId() == null){
				act.setParentId(act.getId());
				act.setRootId(act.getId());
				if (!actServ.modActivity(act)){
					res.setCode(501);
					res.setDetail("Failed to add activity");
					break;
				}
			}
			
			res.setData(act.getId());
			
		} while (false);

		return res;
	}
	
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse mod(TActivity act, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (act == null) {
				res.setCode(401);
				res.setDetail("From data cannot be empty");
				break;
			}

			if (act.getId() == null) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			TActivity current = actServ.queryActivityById(act.getId());
			if (current == null){
				res.setCode(406);
				res.setDetail("Failed to find activity");
				break;
			}
			
			if (act.getParentId() != null){
				TActivity parent = actServ.queryActivityById(act.getParentId());
				if (parent == null){
					res.setCode(407);
					res.setDetail("Failed to find parent activity");
					break;
				}
				
				if (!current.getRootId().equals(parent.getRootId())){
					res.setCode(409);
					res.setDetail("Invalid parent");
					break;
				}
				
				act.setRootId(parent.getRootId());
			}
			
			if (!actServ.modActivity(act)){
				res.setCode(500);
				res.setDetail("Failed to mod activity");
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
			
			if (!actServ.delActivityById(id)){
				res.setCode(500);
				res.setDetail("Failed to del activity");
				break;
			}

		} while (false);

		return res;
	}
	
}
