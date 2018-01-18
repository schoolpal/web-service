package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TFunction;
import com.schoolpal.service.FunctionService;
import com.schoolpal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ajax/func")
@Validated
public class AjaxFuncController extends AjaxBaseController{

    @Autowired
    private UserService userServ;
    @Autowired
    private FunctionService funcServ;

//    @AjaxControllerLog
    @RequestMapping(value = "listRootFuncs.do", method = RequestMethod.POST)
    public Object listRootFuncs() {

        List<TFunction> rootFuncs = funcServ.queryRootFuncList();

        return rootFuncs;
    }

//    @AjaxControllerLog
    @RequestMapping(value = "listAllFuncs.do", method = RequestMethod.POST)
    public Object listAllFuncs() {

        List<TFunction> rootFuncs = funcServ.queryAllFuncList();

        return rootFuncs;
    }

//    @AjaxControllerLog
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public Object listFuncs(@NotEmpty String ids) {

            List<TFunction> funcList = new ArrayList<TFunction>();
            for (String id : ids.split(",")) {
                if (!id.isEmpty()) {
                    List<TFunction> funcs = funcServ.queryFuncListByRootId(id);
                    if (funcs != null && funcs.size() > 0) {
                        funcList.addAll(funcs);
                    }
                }
            }

        return funcList;
    }

}
