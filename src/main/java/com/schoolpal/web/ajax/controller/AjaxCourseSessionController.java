package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TCourseSession;
import com.schoolpal.db.model.TStudent;
import com.schoolpal.service.CourseSessionService;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/ajax/course/session")
public class AjaxCourseSessionController extends AjaxBaseStudentController{

    @Autowired
    private CourseSessionService courseSessionService;

    @AjaxControllerLog
    @RequestMapping(value = "queryListByTypeId.do", method = RequestMethod.POST)
    public Object queryListByTypeId(@NotNull Integer id) throws AjaxException {

        List<TCourseSession> courseSessions = courseSessionService.queryCourseSessionListByTypeId(id);

        return courseSessions;
    }
/*
    @AjaxControllerLog
    @RequiresPermissions("2-3-1")
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    @Override
    public Object add(@Validated({AjaxControllerAdd.class}) TStudent student) throws AjaxException {

        return super.add(student);
    }

    @AjaxControllerLog
    @RequiresPermissions("2-3-2")
    @RequestMapping(value = "mod.do", method = RequestMethod.POST)
    @Override
    public Object mod(@Validated({AjaxControllerMod.class}) TStudent student) throws AjaxException {

        return super.mod(student);
    }

    @AjaxControllerLog
    @RequiresPermissions("2-3-3")
    @RequestMapping(value = "del.do", method = RequestMethod.POST)
    @Transactional
    @Override
    public Object del(String id) throws AjaxException {

        return super.del(id);
    }
*/
}
