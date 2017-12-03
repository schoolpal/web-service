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
import com.schoolpal.db.model.TStudent;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.RelationService;
import com.schoolpal.service.StudentService;
import com.schoolpal.service.UserService;

@Controller
@RequestMapping("/ajax/sales/customer/student")
public class AjaxSalesStudentController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private StudentService stuServ;
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
			
			if (!AuthorizationHelper.CheckPermissionById("2-3")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			TStudent contract = stuServ.queryStudentById(id);
			if (contract == null){
				res.setCode(402);
				res.setDetail("Invalid student id");
				break;
			}
			
			res.setData(contract);

		} while (false);

		return res;
	}
	
	@RequestMapping(value = "queryByCode.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse queryByCode(String code, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (StringUtils.isEmpty(code)) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			
			if (!AuthorizationHelper.CheckPermissionById("2-3")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			TStudent target = stuServ.queryStudentByCode(code);
			if (target == null){
				res.setCode(402);
				res.setDetail("Invalid student code");
				break;
			}
			
			res.setData(target);

		} while (false);

		return res;
	}
	
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse list(HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("2-3")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			List<TStudent> students = null;
			TUser user = userServ.getCachedUser();
			students = stuServ.queryStudentsByExecutiveId(user.getcId());
			res.setData(students);

		} while (false);

		return res;
	}

	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse add(TStudent student, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (!this.validateForm(student, res)){
				break;
			}
			
			TUser user = userServ.getCachedUser();
			if (user == null){
				res.setCode(500);
				res.setDetail("Not login");
				break;
			}
			
			student.setCreatorId(user.getcId());
			student.setExecutiveId(user.getcId());
			if (stuServ.addStudent(student) == null){
				res.setCode(501);
				res.setDetail("Failed to add student");
				break;
			}
			
			res.setData(student.getId());
			
		} while (false);

		return res;
	}
	
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse mod(TStudent student, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (StringUtils.isEmpty(student.getId())){
				res.setCode(411);
				res.setDetail("Invalid contact id");
				break;
			}
			
			if (!this.validateForm(student, res)){
				break;
			}

			TStudent target = stuServ.queryStudentById(student.getId());
			if (target == null){
				res.setCode(412);
				res.setDetail("Invalid contact id");
				break;
			}
			
			if (!stuServ.modStudent(student)){
				res.setCode(500);
				res.setDetail("Failed to mod student");
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
			
			TStudent target = stuServ.queryStudentById(id);
			if (target == null){
				res.setCode(402);
				res.setDetail("Invalid contact id");
				break;
			}
			
			if (!stuServ.delStudentById(id)){
				res.setCode(500);
				res.setDetail("Failed to del activity");
				break;
			}
			relationServ.delRelationsByStuId(id);

		} while (false);

		return res;
	}
	
	private boolean validateForm(TStudent student, AjaxResponse res){
		boolean ret = false;
		do {
			if (student == null) {
				res.setCode(401);
				res.setDetail("From data cannot be empty");
				break;
			}
			if (StringUtils.isEmpty(student.getName())){
				res.setCode(402);
				res.setDetail(" Student cannot be empty");
				break;
			}
			if (student.getGenderId() == null){
				res.setCode(403);
				res.setDetail("Student gender cannot be empty");
				break;
			}
			if (student.getBirthday() == null){
				res.setCode(404);
				res.setDetail("Student birthday cannot be empty");
				break;
			}
			if (StringUtils.isEmpty(student.getClassGrade())){
				res.setCode(405);
				res.setDetail("Student grade cannot be empty");
				break;
			}

			ret = true;
		}while(false);
		return ret;
	}
}
