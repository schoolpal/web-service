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
import com.schoolpal.db.model.TContact;
import com.schoolpal.db.model.TContract;
import com.schoolpal.db.model.TLeads;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.ContactService;
import com.schoolpal.service.ContractService;
import com.schoolpal.service.LeadsService;
import com.schoolpal.service.UserService;

@Controller
@RequestMapping("/ajax/sales/contract")
public class AjaxSalesContractController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private ContractService contractServ;
	
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
			
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			TContract contract = contractServ.queryContractById(id);
			if (contract == null){
				res.setCode(402);
				res.setDetail("Invalid contact id");
				break;
			}
			
			res.setData(contract);

		} while (false);

		return gson.toJson(res);
	}
	
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public String list(HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			List<TContract> contracts = null;
			TUser user = userServ.getCachedUser();
			contracts = contractServ.queryContractsByExecutiveId(user.getcId());
			res.setData(contracts);

		} while (false);

		return gson.toJson(res);
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public String add(TContract contract, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (!this.validateForm(contract, res)){
				break;
			}
			
			TUser user = userServ.getCachedUser();
			contract.setExecutiveId(user.getcId());
			
			if (contractServ.addContract(contract) == null){
				res.setCode(500);
				res.setDetail("Failed to add activity");
				break;
			}
			
			res.setData(contract.getId());
			
		} while (false);

		return gson.toJson(res);
	}
	
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@ResponseBody
	public String mod(TContract contract, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (!this.validateForm(contract, res)){
				break;
			}

			TContract target = contractServ.queryContractById(contract.getId());
			if (target == null){
				res.setCode(401);
				res.setDetail("Invalid contact id");
				break;
			}
			
			if (!contractServ.modContract(contract)){
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
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			
			TContract contract = contractServ.queryContractById(id);
			if (contract == null){
				res.setCode(402);
				res.setDetail("Invalid contact id");
				break;
			}
			
			if (!contractServ.delContractById(id)){
				res.setCode(500);
				res.setDetail("Failed to del activity");
				break;
			}

		} while (false);

		return gson.toJson(res);
	}
	
	private boolean validateForm(TContract contract, AjaxResponse res){
		boolean ret = false;
		do {
			if (contract == null) {
				res.setCode(401);
				res.setDetail("From data cannot be empty");
				break;
			}
			if (StringUtils.isEmpty(contract.getStuName())){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			if (contract.getStuGender() == null){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			if (contract.getStuBirthday() == null){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			if (contract.getStuGrade() == null){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			if (contract.getParName() == null){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			if (contract.getCourseType() == null){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			if (contract.getCourseSesId() == null){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			if (contract.getOriPrice() == null){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			if (contract.getDiscPrice() == null){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			if (contract.getFinalPrice() == null){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			if (contract.getPaid() == null){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			if (contract.getCode() == null){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			if (contract.getType() == null){
				res.setCode(402);
				res.setDetail("cannot be empty");
				break;
			}
			ret = true;
		}while(false);
		return ret;
	}
}
