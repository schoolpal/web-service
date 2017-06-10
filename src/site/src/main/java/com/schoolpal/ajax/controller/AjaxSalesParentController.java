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
import com.schoolpal.db.model.TParent;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.ParentService;
import com.schoolpal.service.RelationService;
import com.schoolpal.service.UserService;

@Controller
@RequestMapping("/ajax/sales/customer/parent")
public class AjaxSalesParentController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private ParentService parServ;
	@Autowired
	private RelationService relationServ;
	
	private Gson gson = new Gson();

	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@ResponseBody
	public String query(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (StringUtils.isEmpty(id)) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			
			if (!AuthorizationHelper.CheckPermissionById("2-3")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			TParent parent = parServ.queryParentById(id);
			if (parent == null){
				res.setCode(402);
				res.setDetail("Invalid contact id");
				break;
			}
			
			res.setData(parent);

		} while (false);

		return gson.toJson(res);
	}
	
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public String list(HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("2-3")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			List<TParent> contracts = null;
			TUser user = userServ.getCachedUser();
			contracts = parServ.queryParentsByExecutiveId(user.getcId());
			res.setData(contracts);

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(TParent parent, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (!this.validateForm(parent, res)){
				break;
			}
			
			TUser user = userServ.getCachedUser();
			if (user == null){
				res.setCode(500);
				res.setDetail("Not login");
				break;
			}
			
			parent.setCreatorId(user.getcId());
			parent.setExecutiveId(user.getcId());
			if (parServ.addParent(parent) == null){
				res.setCode(504);
				res.setDetail("Failed to add contract");
				break;
			}
			
			res.setData(parent.getId());
			
		} while (false);

		return gson.toJson(res);
	}
	
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@ResponseBody
	public String mod(TParent parent, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (StringUtils.isEmpty(parent.getId())) {
				res.setCode(404);
				res.setDetail("Id cannot be empty");
				break;
			}
			
			if (!this.validateForm(parent, res)){
				break;
			}

			TParent target = parServ.queryParentById(parent.getId());
			if (target == null){
				res.setCode(401);
				res.setDetail("Invalid contact id");
				break;
			}
			
			if (!parServ.modParent(parent)){
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
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (StringUtils.isEmpty(id)) {
				res.setCode(411);
				res.setDetail("Id cannot be empty");
				break;
			}
			
			TParent target = parServ.queryParentById(id);
			if (target == null){
				res.setCode(412);
				res.setDetail("Invalid contact id");
				break;
			}
			
			if (!parServ.delParentById(id)){
				res.setCode(500);
				res.setDetail("Failed to del activity");
				break;
			}
			relationServ.delRelationsByParId(id);

		} while (false);

		return gson.toJson(res);
	}
	
	private boolean validateForm(TParent parent, AjaxResponse res){
		boolean ret = false;
		do {
			if (parent == null) {
				res.setCode(401);
				res.setDetail("From data cannot be empty");
				break;
			}

			if (StringUtils.isEmpty(parent.getName())){
				res.setCode(402);
				res.setDetail("Parent name cannot be empty");
				break;
			}
			if (StringUtils.isEmpty(parent.getCellphone())){
				res.setCode(403);
				res.setDetail("Course type cannot be empty");
				break;
			}

			ret = true;
		}while(false);
		return ret;
	}
}
