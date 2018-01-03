package com.schoolpal.web.controller.ajax.controller;

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
import com.schoolpal.web.controller.ajax.model.AjaxResponse;
import com.schoolpal.web.controller.ajax.helper.AuthorizationHelper;
import com.schoolpal.db.model.TContract;
import com.schoolpal.db.model.TParent;
import com.schoolpal.db.model.TStudent;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.ContractService;
import com.schoolpal.service.ParentService;
import com.schoolpal.service.RelationService;
import com.schoolpal.service.StudentService;
import com.schoolpal.service.UserService;

@Controller
@RequestMapping("/ajax/service/contract")
public class AjaxServiceContractController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private ContractService contractServ;
	@Autowired
	private StudentService studentServ;
	@Autowired
	private ParentService parentServ;
	@Autowired
	private RelationService relationServ;
	
	private Gson gson = new Gson();

	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse query(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (StringUtils.isEmpty(id)) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			
			if (!AuthorizationHelper.CheckPermissionById("3-1")) {
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

		return res;
	}
	
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse list(HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("3-1")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			List<TContract> contracts = null;
			TUser user = userServ.getCachedUser();
			contracts = contractServ.queryContractsByExecutiveId(user.getcId());
			res.setData(contracts);

		} while (false);

		return res;
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse add(TContract contract, HttpServletRequest request) {
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
			if (user == null){
				res.setCode(500);
				res.setDetail("Not login");
				break;
			}
			
			TStudent stu = TStudent.ParseFromContract(contract);
			stu.setCreatorId(user.getcId());
			stu.setExecutiveId(user.getcId());
			if (studentServ.addStudent(stu) == null){
				res.setCode(501);
				res.setDetail("Failed to add student");
				break;
			}
			
			TParent par = TParent.ParseFromContract(contract);
			par.setCreatorId(user.getcId());
			par.setExecutiveId(user.getcId());
			if (parentServ.addParent(par) == null){
				res.setCode(502);
				res.setDetail("Failed to add parent");
				break;
			}
			
			if (!relationServ.addRelation(par.getId(), stu.getId(), contract.getRelation())){
				res.setCode(503);
				res.setDetail("Failed to add relation");
				break;
			}
			
			contract.setStuId(stu.getId());
			contract.setParId(par.getId());
			contract.setCreatorId(user.getcId());
			contract.setExecutiveId(user.getcId());
			if (contractServ.addContract(contract) == null){
				res.setCode(504);
				res.setDetail("Failed to add contract");
				break;
			}
			
			res.setData(contract.getId());
			
		} while (false);

		return res;
	}
	
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse mod(TContract contract, HttpServletRequest request) {
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
			
			if (StringUtils.isEmpty(id)) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			
			TContract target = contractServ.queryContractById(id);
			if (target == null){
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

		return res;
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
				res.setDetail(" Student cannot be empty");
				break;
			}
			if (contract.getStuGenderId() == null){
				res.setCode(403);
				res.setDetail("Student gender cannot be empty");
				break;
			}
			if (contract.getStuBirthday() == null){
				res.setCode(404);
				res.setDetail("Student birthday cannot be empty");
				break;
			}
			if (StringUtils.isEmpty(contract.getStuGrade())){
				res.setCode(405);
				res.setDetail("Student grade cannot be empty");
				break;
			}
			if (StringUtils.isEmpty(contract.getParName())){
				res.setCode(406);
				res.setDetail("Parent name cannot be empty");
				break;
			}
			if (StringUtils.isEmpty(contract.getParCellphone())){
				res.setCode(407);
				res.setDetail("Parent cellphone cannot be empty");
				break;
			}
			if (StringUtils.isEmpty(contract.getCourseType())){
				res.setCode(408);
				res.setDetail("Course type cannot be empty");
				break;
			}
			if (contract.getCourseSesId() == null){
				res.setCode(409);
				res.setDetail("Course session cannot be empty");
				break;
			}
			if (contract.getOriPrice() == null){
				res.setCode(410);
				res.setDetail("Original price cannot be empty");
				break;
			}
			if (contract.getDiscPrice() == null){
				res.setCode(411);
				res.setDetail("Discount cannot be empty");
				break;
			}
			if (contract.getFinalPrice() == null){
				res.setCode(412);
				res.setDetail("Final price cannot be empty");
				break;
			}
			if (contract.getPaid() == null){
				res.setCode(413);
				res.setDetail("Paid cannot be empty");
				break;
			}
			if (StringUtils.isEmpty(contract.getCode())){
				res.setCode(414);
				res.setDetail("Code cannot be empty");
				break;
			}
			if (StringUtils.isEmpty(contract.getType())){
				res.setCode(415);
				res.setDetail("Type cannot be empty");
				break;
			}
			ret = true;
		}while(false);
		return ret;
	}
}
