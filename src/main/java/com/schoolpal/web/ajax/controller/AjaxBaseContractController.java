package com.schoolpal.web.ajax.controller;

import com.schoolpal.db.model.*;
import com.schoolpal.service.*;
import com.schoolpal.web.ajax.exception.AjaxException;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Validated
public abstract class AjaxBaseContractController extends AjaxBaseController {

    @Autowired
    protected UserService userServ;
    @Autowired
    protected OrgService orgServ;
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

        List<TContract> contracts = contractServ.queryContractListByStudentId(id);

        return contracts;
    }

    public Object listDependsRank(String orgId) throws AjaxException {

        TUser user = userServ.getCachedUser();
        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), orgId)) {
            throw new AjaxException(402, "No permission to query organization");
        }

        List<TContract> ret = new ArrayList<>();

        List<String> orgList = orgServ.queryOrgIdListByRootId(orgId);
        if (orgList != null) {
            orgList.forEach(o -> {
                if (o.equals(user.getcOrgId())) {
                    if (user.getHighestRank() == 1) {
                        ret.addAll(contractServ.queryContractListByOrgId(orgId));
                    } else if (user.getHighestRank() == 3) {
                        ret.addAll(contractServ.queryContractListByExecutiveId(user.getcId()));
                    } else if (user.getHighestRank() == 2) {
                        ret.addAll(contractServ.queryContractListByExecutiveId(user.getcId()));
                        ret.addAll(contractServ.queryContractListByOrgIdForRank2(orgId));
                    } else {
                        //Unexpected user rank, no contract should be returned
                        return;
                    }
                } else {
                    ret.addAll(contractServ.queryContractListByOrgId(o));
                }
            });
        }

        ret.sort(Comparator.comparing(TContract::getId).reversed());
        return ret;
    }

    public Object listAll(String orgId) throws AjaxException {

        TUser user = userServ.getCachedUser();
        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), orgId)) {
            throw new AjaxException(402, "No permission to query organization");
        }

        List<TContract> ret = new ArrayList<>();

        List<String> orgList = orgServ.queryOrgIdListByRootId(orgId);
        if (orgList != null) {
            orgList.forEach(o -> {
                    ret.addAll(contractServ.queryContractListByOrgId(o));
            });
        }

        ret.sort(Comparator.comparing(TContract::getId).reversed());
        return ret;
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
            throw new AjaxException(402, "Contact not exists");
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
