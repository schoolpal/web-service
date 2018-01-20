package com.schoolpal.service;

import com.schoolpal.aop.ServiceLog;
import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.inf.TParStuMapper;
import com.schoolpal.db.model.TParStu;
import com.schoolpal.db.model.TParStuKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationService {

    @Autowired
    private LogService logServ;

    @Autowired
    private TParStuMapper relationDao;

    @ServiceLog
    public void addRelation(String parId, String stuId, String relationDesc) {
        TParStu relation = new TParStu();
        relation.setParId(parId);
        relation.setStuId(stuId);
        relation.setRelation(relationDesc);
        relationDao.insertOne(relation);
    }

    @ServiceLog
    public void delRelation(String parId, String stuId) {
        TParStuKey key = new TParStuKey();
        key.setParId(parId);
        key.setStuId(stuId);
        relationDao.deleteOneByPrimaryKey(key);
    }

    @ServiceLog
    public void delRelationsByParId(String parId) {
        relationDao.deleteManyByParId(parId);
    }

    @ServiceLog
    public void delRelationsByStuId(String stuId) {
        relationDao.deleteManyByStuId(stuId);
    }

}
