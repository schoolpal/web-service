package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TStudent;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajax/service/customer/student")
public class AjaxServiceStudentController extends AjaxBaseStudentController {

	@AjaxControllerLog
	@RequiresPermissions("3-2")
	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@Override
	public Object query(String id) throws AjaxException {

		return super.query(id);
	}

	@AjaxControllerLog
	@RequiresPermissions("3-2")
	@RequestMapping(value = "queryByCode.do", method = RequestMethod.POST)
	@Override
	public Object queryByCode(String code) throws AjaxException {

		return super.queryByCode(code);
	}

	@AjaxControllerLog
	@RequiresPermissions("3-2")
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@Override
	public Object list() throws AjaxException {

		return super.list();
	}

	@AjaxControllerLog
	@RequiresPermissions("3-2-1")
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	@Override
	public Object add(@Validated({AjaxControllerAdd.class}) TStudent student) throws AjaxException {

		return super.add(student);
	}

	@AjaxControllerLog
	@RequiresPermissions("3-2-2")
	@RequestMapping(value = "mod.do", method = RequestMethod.POST)
	@Override
	public Object mod(@Validated({AjaxControllerMod.class}) TStudent student) throws AjaxException {

		return super.mod(student);
	}

	@AjaxControllerLog
	@RequiresPermissions("3-2-3")
	@RequestMapping(value = "del.do", method = RequestMethod.POST)
	@Transactional
	@Override
	public Object del(String id) throws AjaxException {

		return super.del(id);
	}

}
