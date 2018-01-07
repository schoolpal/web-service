package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TParent;
import com.schoolpal.web.ajax.exception.AjaxException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajax/sales/customer/parent")
public class AjaxSalesParentController extends AjaxBaseParentController{

    @AjaxControllerLog
    @RequiresPermissions("2-3")
    @RequestMapping(value = "query.do", method = RequestMethod.POST)
    @Override
    public Object query(String id) throws AjaxException {

        return super.query(id);
    }

    @AjaxControllerLog
    @RequiresPermissions("2-3")
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    @Override
    public Object list() throws AjaxException {

        return super.list();
    }

    @AjaxControllerLog
    @RequiresPermissions("2-3-4")
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    @Override
    public Object add(TParent parent) throws AjaxException {

        return super.add(parent);
    }

    @AjaxControllerLog
    @RequiresPermissions("2-3-5")
    @RequestMapping(value = "mod.do", method = RequestMethod.POST)
    @Override
    public Object mod(TParent parent) throws AjaxException {

        return super.mod(parent);
    }

    @AjaxControllerLog
    @RequiresPermissions("2-3-6")
    @RequestMapping(value = "del.do", method = RequestMethod.POST)
    @Override
    public Object del(String id) throws AjaxException {

        return super.del(id);
    }

}
