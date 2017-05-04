package com.schoolpal.ajax.controller;

import java.util.List;

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
import com.schoolpal.service.ActivityService;
import com.schoolpal.service.UserService;

@Controller
@RequestMapping("/ajax/mkt/activity")
public class AjaxActivityController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private ActivityService actServ;
	
	private Gson gson = new Gson();

//	@RequestMapping(value = "list.do", method = RequestMethod.POST)
//	@ResponseBody
//	public String list(Integer id) {
//		AjaxResponse res = new AjaxResponse(200);
//		do {
//			if (!AuthorizationHelper.CheckPermissionById("1-1")) {
//				res.setCode(400);
//				res.setDetail("No permission");
//				break;
//			}
//			
//			if (id == null) {
//				res.setCode(401);
//				res.setDetail("Id cannot be empty");
//				break;
//			}
//			
//			List<TActivity> acts = null;
//			if (id <= 0){
//				acts = actServ.queryTopLevelActivities();
//			}else{
//				acts = actServ.queryActivitiesByParentId(id);
//			}
//			res.setData(acts);
//
//		} while (false);
//
//		return gson.toJson(res);
//	}
	
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public String list() {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("1-1")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			List<TActivity> acts = null;
			acts = actServ.queryActivityList();
			res.setData(acts);

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
			
			if (act == null) {
				res.setCode(401);
				res.setDetail("From data cannot be empty");
				break;
			}
			
			if (act.getParentId() == null){
				res.setCode(402);
				res.setDetail("Parent id cannot be empty");
				break;
			}
			if (act.getParentId() <= 0){
				act.setRootId(0);
				act.setParentId(0);
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
			if(act.getExectiveId() == null){
				act.setExectiveId(user.getcId());
			}
			
			if (actServ.addActivity(act) <= 0){
				res.setCode(500);
				res.setDetail("Failed to add activity");
				break;
			}
			if (act.getRootId() <= 0){
				act.setParentId(act.getId());
				act.setRootId(act.getId());
				if (!actServ.modActivity(act)){
					res.setCode(500);
					res.setDetail("Failed to add activity");
					break;
				}
			}
			
			res.setData(act.getId());
			
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
			if (act.getParentId() == null){
				res.setCode(402);
				res.setDetail("Parent id cannot be empty");
				break;
			}

			TActivity current = actServ.queryActivityById(act.getId());
			if (current == null){
				res.setCode(406);
				res.setDetail("Failed to find activity");
				break;
			}
			
			TActivity parent = actServ.queryActivityById(act.getParentId());
			if (parent == null){
				res.setCode(407);
				res.setDetail("Failed to find parent activity");
				break;
			}
			
			if (current.getRootId() != parent.getRootId()){
				act.setRootId(parent.getRootId());
			}
			
			if (!actServ.modActivity(act)){
				res.setCode(500);
				res.setDetail("Failed to mod activity");
				break;
			}
						
		} while (false);

		return gson.toJson(res);
	}
	
	@RequestMapping(value = "del.do", method = RequestMethod.POST)
	@ResponseBody
	public String del(int id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (id <= 0) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			
			if (!actServ.delActivity(id)){
				res.setCode(500);
				res.setDetail("Failed to del activity");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}
	
}
