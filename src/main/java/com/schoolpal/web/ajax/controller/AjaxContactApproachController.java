package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TContactApproach;
import com.schoolpal.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ajax/contact/approach")
public class AjaxContactApproachController extends AjaxBaseController{

    @Autowired
    private ContactService contactServ;

    @AjaxControllerLog
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public Object list() {

        List<TContactApproach> approaches = contactServ.queryContactApproaches();

        return approaches;
    }

}
