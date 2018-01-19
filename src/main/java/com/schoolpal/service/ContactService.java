package com.schoolpal.service;

import com.schoolpal.aop.ServiceLog;
import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.inf.TContactApproachMapper;
import com.schoolpal.db.inf.TContactMapper;
import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.model.TContact;
import com.schoolpal.db.model.TContactApproach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private LogService logServ;

    @Autowired
    private TIndexMapper idxDao;
    @Autowired
    private TContactMapper contactDao;
    @Autowired
    private TContactApproachMapper approachDao;

    public TContact queryContactById(String id) {
        TContact ret = contactDao.selectOneById(id);
        return ret;
    }

    public List<TContact> queryContactsByLeadsId(String leadsId) {
        List<TContact> ret = contactDao.selectManyByLeadsId(leadsId);
        return ret;
    }

    @ServiceLog
    @Transactional
    public String addContact(TContact contact) {

        String id = idxDao.selectNextId("t_contact");
        contact.setId(id);
        if (contact.getDatetime() == null) {
            contact.setDatetime(new Date());
        }
        contactDao.insertOne(contact);
        return contact.getId();
    }

    @ServiceLog
    public void modContact(TContact contact) {

        if (contact.getDatetime() == null) {
            contact.setDatetime(new Date());
        }
        contactDao.updateOne(contact);
    }

    @ServiceLog
    public void delContactById(String id) {
        contactDao.deleteOneById(id);
    }

    public List<TContactApproach> queryContactApproaches() {
        return approachDao.selectAll();
    }
}
