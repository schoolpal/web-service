package com.schoolpal.web.ajax.controller;

import com.google.gson.Gson;
import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TLeadsStatus;
import com.schoolpal.service.LeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/ajax/mkt/leads/status")
@Validated
public class AjaxLeadsStatusController extends AjaxBaseController{

    @Autowired
    private LeadsService leadsServ;

    @AjaxControllerLog
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public Object list(@NotNull Integer typeId) {

        List<TLeadsStatus> status = leadsServ.queryLeadsStatusByTypeId(typeId);

        return status;
    }

}
