package com.schoolpal.web.ajax.controller;

import com.schoolpal.db.model.TContract;
import com.schoolpal.db.model.TParent;
import com.schoolpal.db.model.TStudent;
import com.schoolpal.db.model.TUser;
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

    public Object query(@NotEmpty String id) throws AjaxException {

        TContract contract = contractServ.queryContractById(id);
        if (contract == null) {
            throw new AjaxException(402, "Invalid contact id");
        }

        return contract;
    }

    public Object list() {

        TUser user = userServ.getCachedUser();

        List<TContract> contracts = contractServ.queryContractsByExecutiveId(user.getcId());

        return contracts;
    }

    @Transactional
    public Object add(TContract contract) throws AjaxException {

        TUser user = userServ.getCachedUser();

        TStudent stu = TStudent.ParseFromContract(contract);
        stu.setCreatorId(user.getcId());
        stu.setExecutiveId(user.getcId());
        if (studentServ.addStudent(stu) == null) {
            throw new AjaxException(501, "Failed to add student");
        }

        TParent par = TParent.ParseFromContract(contract);
        par.setCreatorId(user.getcId());
        par.setExecutiveId(user.getcId());
        if (parentServ.addParent(par) == null) {
            throw new AjaxException(502, "Failed to add parent");
        }

        if (!relationServ.addRelation(par.getId(), stu.getId(), contract.getRelation())) {
            throw new AjaxException(503, "Failed to add relation");
        }

        contract.setStuId(stu.getId());
        contract.setParId(par.getId());
        contract.setCreatorId(user.getcId());
        contract.setExecutiveId(user.getcId());
        if (contractServ.addContract(contract) == null) {
            throw new AjaxException(500, "Failed to add contract");
        }

        return contract.getId();
    }

    public Object mod(TContract contract) throws AjaxException {

        TContract target = contractServ.queryContractById(contract.getId());
        if (target == null) {
            throw new AjaxException(401, "Invalid contact id");
        }

        if (!contractServ.modContract(contract)) {
            throw new AjaxException(500, "Failed to mod contract");
        }

        return true;
    }

    public Object del(@NotEmpty String id) throws AjaxException {

        TContract target = contractServ.queryContractById(id);
        if (target == null) {
            throw new AjaxException(402, "Invalid contact id");
        }

        if (!contractServ.delContractById(id)) {
            throw new AjaxException(500, "Failed to del activity");
        }

        return true;
    }
    
}
