package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.consts.ParentRelation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ajax/mkt/relation")
public class AjaxParentRelationController extends AjaxBaseController {

    @AjaxControllerLog
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public Object list() {

        Map<Integer, String> data = new HashMap<Integer, String>();
        for (ParentRelation g : ParentRelation.values()) {
            data.put(g.getValue(), g.getName());
        }

        return data;
    }

}

