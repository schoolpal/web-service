package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TCourseType;
import com.schoolpal.db.model.TLeadsSource;
import com.schoolpal.service.CourseTypeService;
import com.schoolpal.service.LeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/ajax/course/type")
@Validated
public class AjaxCourseTypeController extends AjaxBaseController{

    @Autowired
    private CourseTypeService courseTypeService;

    @AjaxControllerLog
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public Object list() {

        List<TCourseType> courseTypes = courseTypeService.queryCourseTypeList();

        return courseTypes;
    }

}
