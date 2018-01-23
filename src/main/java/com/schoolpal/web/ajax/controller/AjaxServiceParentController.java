package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TParent;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajax/service/customer/parent")
public class AjaxServiceParentController extends AjaxBaseParentController{

	@AjaxControllerLog
	@RequiresPermissions("3-2")
	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@Override
	public Object query(String id) throws AjaxException {

		return super.query(id);
	}

	@AjaxControllerLog
	@RequiresPermissions("3-2")
	@RequestMapping(value = "queryListByStudentId.do", method = RequestMethod.POST)
	@Override
	public Object queryListByStudentId(String id) throws AjaxException {

		return super.queryListByStudentId(id);
	}

	@AjaxControllerLog
	@RequiresPermissions("3-2")
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@Override
	public Object list() throws AjaxException {

		return super.list();
	}

	@AjaxControllerLog
	@RequiresPermissions("3-2-4")
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@Override
	public Object add(@Validated({AjaxControllerAdd.class}) TParent parent, String studentId) throws AjaxException {

		return super.add(parent, studentId);
	}

	@AjaxControllerLog
	@RequiresPermissions("3-2-5")
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@Override
	public Object mod(@Validated({AjaxControllerMod.class}) TParent parent, String studentId) throws AjaxException {

		return super.mod(parent, studentId);
	}

	@AjaxControllerLog
	@RequiresPermissions("3-2-6")
	@RequestMapping(value = "del.do", method = RequestMethod.POST)
	@Override
	public Object del(String id) throws AjaxException {

		return super.del(id);
	}

}
