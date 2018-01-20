package com.schoolpal.service;

import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.inf.TParentMapper;
import com.schoolpal.db.model.TParent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ParentService {

    @Autowired
    private LogService logServ;

    @Autowired
    private TIndexMapper idxDao;
    @Autowired
    private TParentMapper parentDao;

    public TParent queryParentById(String id) {
        TParent ret = parentDao.selectOneById(id);
        return ret;
    }

    public List<TParent> queryParentsByExecutiveId(String id) {
        List<TParent> ret = parentDao.selectManyByExecutiveId(id);
        return ret;
    }

    public List<TParent> queryParentsByStudentId(String id) {
        List<TParent> ret = parentDao.selectManyByStudentId(id);
        return ret;
    }

    public String addParent(TParent parent) {

        String id = idxDao.selectNextId("t_parent");
        parent.setId(id);
        parent.setCreateTime(new Date());
        parent.setLastUpdate(new Date());
        parentDao.insertOne(parent);

        return parent.getId();
    }

    public void modParent(TParent parent) {
        parent.setLastUpdate(new Date());
        parentDao.updateOne(parent);
    }

    public void delParentById(String id) {
        parentDao.deleteOneById(id);
    }

}
