package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TContract;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajax/service/contract")
public class AjaxServiceContractController extends AjaxBaseContractController {

    @AjaxControllerLog
    @RequiresPermissions("3-1")
    @RequestMapping(value = "query.do", method = RequestMethod.POST)
    @Override
    public Object query(String id) throws AjaxException {

        return super.query(id);
    }

    @AjaxControllerLog
    @RequiresPermissions("3-1")
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    @Override
    public Object list() {

        return super.list();
    }

    @AjaxControllerLog
    @RequiresPermissions("3-1-1")
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    @Override
    public Object add(@Validated({AjaxControllerAdd.class}) TContract contract) throws AjaxException {

        return super.add(contract);
    }

    @AjaxControllerLog
    @RequiresPermissions("3-1-2")
    @RequestMapping(value = "mod.do", method = RequestMethod.POST)
    @Override
    public Object mod(@Validated({AjaxControllerMod.class}) TContract contract) throws AjaxException {

        return super.mod(contract);
    }

    @AjaxControllerLog
    @RequiresPermissions("3-1-3")
    @RequestMapping(value = "del.do", method = RequestMethod.POST)
    @Override
    public Object del(String id) throws AjaxException {

        return super.del(id);
    }

}
