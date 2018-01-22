package com.schoolpal.service;

import com.schoolpal.aop.ServiceLog;
import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.inf.*;
import com.schoolpal.db.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class LeadsService {

    @Autowired
    private LogService logServ;

    @Autowired
    private TIndexMapper idxDao;
    @Autowired
    private TLeadsMapper leadsDao;
    @Autowired
    private TLeadsParentMapper parentDao;
    @Autowired
    private TLeadsStudentMapper studentDao;
    @Autowired
    private TLeadsSourceMapper sourceDao;
    @Autowired
    private TLeadsStageMapper stageDao;
    @Autowired
    private TLeadsStatusMapper statusDao;
    @Autowired
    private TCourseSessionMapper courseSessionDao;

    public List<TLeads> queryLeadsListByOrgId(String orgId, Integer typeId) {
        List<TLeads> ret = leadsDao.selectManyByOrgAndTypeId(orgId, typeId);

        return ret;
    }

    public TLeads queryLeadsById(String id) {
        TLeads ret = leadsDao.selectOneById(id);

        return ret;
    }

    public TLeads queryLeadsStudentAndParentById(String id) {
        TLeads ret = leadsDao.selectStudentAndParentById(id);

        return ret;
    }

    @ServiceLog
    @Transactional
    public String addLeads(TLeads leads) {

        String id = idxDao.selectNextId("t_leads");
        leads.setId(id);

        if (leads.getExecutiveId() == null) {
            leads.setExecutiveId(leads.getCreatorId());
        }
        leads.setCreateTime(new Date());
        leads.setLastUpdate(new Date());

        leadsDao.insertOne(leads);
        return leads.getId();
    }

    @ServiceLog
    public void modLeads(TLeads leads) {
        leads.setLastUpdate(new Date());
        leadsDao.updateOne(leads);
    }

    @ServiceLog
    @Transactional
    public void delLeadsById(String id) throws Exception {

        TLeads leads = leadsDao.selectOneById(id);
        if (leads == null) {
            throw new Exception("Leads not exists");
        }

        if (!StringUtils.isEmpty(leads.getParentId())) {
            parentDao.deleteOneById(leads.getParentId());
        }
        if (!StringUtils.isEmpty(leads.getStudentId())) {
            studentDao.deleteOneById(leads.getStudentId());
        }
        leadsDao.deleteOneById(id);
    }

    @ServiceLog
    @Transactional
    public String add(TLeads leads, TLeadsStudent student, TLeadsParent parent, String creatorId) throws Exception {

        if(!StringUtils.isEmpty(leads.getCourseId())) {
            if (courseSessionDao.ifExistsById(leads.getCourseId()) < 1) {
                throw new Exception("Course not exists");
            }
        }

        student.setCreatorId(creatorId);
        if (this.addStudent(student) == null) {
            throw new Exception("Failed to add leads student");
        }

        parent.setCreatorId(creatorId);
        if (this.addParent(parent) == null) {
            throw new Exception("Failed to add leads parent");
        }

        leads.setCreatorId(creatorId);
        leads.setStudentId(student.getId());
        leads.setParentId(parent.getId());

        if (this.addLeads(leads) == null) {
            throw new Exception("Failed to add leads");
        }
        return leads.getId();
    }

    @ServiceLog
    @Transactional
    public void mod(TLeads leads, TLeadsStudent student, TLeadsParent parent) throws Exception {

        TLeads target = this.queryLeadsById(leads.getId());
        if (target == null) {
            throw new Exception("Leads not exists");
        }


        if(!StringUtils.isEmpty(leads.getCourseId())){
            if(courseSessionDao.ifExistsById(leads.getCourseId()) < 1){
                throw new Exception("Course not exists");
            }
        }

        student.setId(target.getStudentId());
        this.modStudent(student);

        parent.setId(target.getParentId());
        this.modParent(parent);

        this.modLeads(leads);
    }

    @ServiceLog
    @Transactional
    public void delById(String id) throws Exception {
        TLeads leads = this.queryLeadsStudentAndParentById(id);
        if (leads == null) {
            throw new Exception("Leads not exists");
        }
        if (!StringUtils.isEmpty(leads.getParentId())) {
            parentDao.deleteOneById(leads.getParentId());
        }
        if (!StringUtils.isEmpty(leads.getStudentId())) {
            studentDao.deleteOneById(leads.getStudentId());
        }

        leadsDao.deleteOneById(id);
    }

    @ServiceLog
    public void assignToExecutiveById(String id, String userId) {
        leadsDao.updateExecutiveById(id, userId);
    }

    @ServiceLog
    public void convertToOpportunityById(String id) throws Exception {

        TLeads leads = leadsDao.selectOneById(id);
        if (leads == null) {
            throw new Exception("Leads not exists");
        }

        leads.setTypeId(2);
        leads.setSourceId(leads.getSourceId() + 10);
        leads.setStageId(11);
        leads.setStatusId(11);
        leadsDao.updateOne(leads);
    }

    @ServiceLog
    @Transactional
    public String addParent(TLeadsParent parent) {

        String id = idxDao.selectNextId("t_leads_parent");
        parent.setId(id);

        parent.setCreateTime(new Date());
        parent.setLastUpdate(new Date());

        parentDao.insertOne(parent);
        return parent.getId();
    }

    @ServiceLog
    public void modParent(TLeadsParent parent) {
        parent.setLastUpdate(new Date());
        parentDao.updateOne(parent);
    }

    @ServiceLog
    public void delParentById(String id) {
        parentDao.deleteOneById(id);
    }

    @ServiceLog
    public void delParentByLeadsId(String leadsId) {
        parentDao.deleteManyByLeadsId(leadsId);
    }

    @ServiceLog
    @Transactional
    public String addStudent(TLeadsStudent student) {

        String id = idxDao.selectNextId("t_leads_student");
        student.setId(id);

        student.setCreateTime(new Date());
        student.setLastUpdate(new Date());

        studentDao.insertOne(student);

        return student.getId();
    }

    @ServiceLog
    public void modStudent(TLeadsStudent student) {
        student.setLastUpdate(new Date());
        studentDao.updateOne(student);
    }

    @ServiceLog
    public void delStudentById(String id) {
        studentDao.deleteOneById(id);
    }

    @ServiceLog
    public void delStudentByLeadsId(String leadsId) {
        studentDao.deleteManyByLeadsId(leadsId);
    }

    public List<TLeadsSource> queryLeadsSourcesByTypeId(Integer typeId) {
        return sourceDao.selectManyByTypeId(typeId);
    }

    public List<TLeadsStage> queryLeadsStagesByTypeId(Integer typeId) {
        return stageDao.selectManyByTypeId(typeId);
    }

    public List<TLeadsStatus> queryLeadsStatusByTypeId(Integer typeId) {
        return statusDao.selectManyByTypeId(typeId);
    }

}
