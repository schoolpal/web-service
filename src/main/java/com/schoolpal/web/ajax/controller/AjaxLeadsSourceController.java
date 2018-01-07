package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TLeadsSource;
import com.schoolpal.service.LeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/ajax/mkt/leads/source")
public class AjaxLeadsSourceController extends AjaxBaseController{

    @Autowired
    private LeadsService leadsServ;

    @AjaxControllerLog
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public Object list(@NotEmpty Integer typeId) {

        List<TLeadsSource> sources = leadsServ.queryLeadsSourcesByTypeId(typeId);

        return sources;
    }

}
