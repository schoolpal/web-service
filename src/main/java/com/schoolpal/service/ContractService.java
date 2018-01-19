package com.schoolpal.service;

import com.schoolpal.aop.ServiceLog;
import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.inf.TContractMapper;
import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.model.TContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ContractService {

    @Autowired
    private LogService logServ;

    @Autowired
    private TIndexMapper idxDao;
    @Autowired
    private TContractMapper contractDao;

    public TContract queryContractById(String id) {
        return contractDao.selectOneById(id);
    }

    public List<TContract> queryContractsByExecutiveId(String id) {
        return contractDao.selectManyByExecutiveId(id);
    }

    public List<TContract> queryContractsByStudentId(String id) {
        return contractDao.selectManyByStuId(id);
    }

    @ServiceLog
    @Transactional
    public String addContract(TContract contract) {

        String id = idxDao.selectNextId("t_contract");
        contract.setId(id);
        contract.setCreateTime(new Date());
        contractDao.insertOne(contract);
        return contract.getId();
    }

    @ServiceLog
    public void modContract(TContract contract) {
        contractDao.updateOne(contract);
    }

    @ServiceLog
    public void delContractById(String id) {
        contractDao.deleteOneById(id);

    }

}
