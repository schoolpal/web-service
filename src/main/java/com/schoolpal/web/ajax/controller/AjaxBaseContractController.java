package com.schoolpal.web.ajax.controller;

import com.schoolpal.db.model.*;
import com.schoolpal.service.*;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public abstract class AjaxBaseContractController extends AjaxBaseController {

    @Autowired
    protected UserService userServ;
    @Autowired
    protected ContractService contractServ;
    @Autowired
    protected StudentService studentServ;
    @Autowired
    protected ParentService parentServ;
    @Autowired
    protected RelationService relationServ;
    @Autowired
    protected CourseSessionService courseSessionServ;

    public Object query(@NotEmpty String id) throws AjaxException {

        TContract contract = contractServ.queryContractById(id);
        if (contract == null) {
            throw new AjaxException(402, "Invalid contact id");
        }

        return contract;
    }

    public Object queryListByStudentId(@NotEmpty String id) {

        List<TContract> contracts = contractServ.queryContractsByStudentId(id);

        return contracts;
    }

    public Object list() {

        TUser user = userServ.getCachedUser();

        List<TContract> contracts = contractServ.queryContractsByExecutiveId(user.getcId());

        return contracts;
    }

    @Transactional
    public Object add(TContract contract) throws AjaxException {

        TUser user = userServ.getCachedUser();

        try {
            TStudent stu = TStudent.ParseFromContract(contract);
            stu.setCreatorId(user.getcId());
            stu.setExecutiveId(user.getcId());
            studentServ.addStudent(stu);
            contract.setStuId(stu.getId());

            TParent par = TParent.ParseFromContract(contract);
            par.setCreatorId(user.getcId());
            par.setExecutiveId(user.getcId());
            parentServ.addParent(par);
            contract.setParId(par.getId());

            relationServ.addRelation(par.getId(), stu.getId(), contract.getRelation());

            contract.setCreatorId(user.getcId());
            contract.setExecutiveId(user.getcId());
            contractServ.addContract(contract);

        } catch (Exception e) {
            throw new AjaxException(500, "Failed to add contract", e);
        }

        return contract.getId();
    }

    public Object mod(TContract contract) throws AjaxException {

        TContract target = contractServ.queryContractById(contract.getId());
        if (target == null) {
            throw new AjaxException(401, "Contact not exists");
        }

        try {
            contractServ.modContract(contract);
        } catch (Exception e) {
            throw new AjaxException(500, "Failed to mod contract", e);
        }


        return true;
    }

    public Object del(@NotEmpty String id) throws AjaxException {

        TContract target = contractServ.queryContractById(id);
        if (target == null) {
            throw new AjaxException(402, "Invalid contract id");
        }

        try {
            contractServ.delContractById(id);
        } catch (Exception e) {
            throw new AjaxException(500, "Failed to del contract", e);
        }

        return true;
    }

}
