package com.schoolpal.service;

import com.schoolpal.aop.ServiceLog;
import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.inf.TOrgMapper;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.web.model.OrgForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class OrgService {

    @Autowired
    private TIndexMapper idxDao;
    @Autowired
    private TOrgMapper orgDao;

    @Autowired
    private LogService logServ;

    public List<TOrg> queryOrgListByRootId(String id) {
        List<TOrg> orgRows = orgDao.selectAll();
        List<TOrg> results = new ArrayList<TOrg>();

        for (TOrg row : orgRows) {
            if (row.getcId().equals(id)) {
                row.setLevel(0);
                results.add(row);
                break;
            }
        }

        int ind = 0;
        while (ind < results.size()) {
            int offset = 0;
            TOrg currRow = results.get(ind);

            for (TOrg row : orgRows) {
                if (row.getcParentId().equals(currRow.getcId()) && !results.contains(row)) {
                    row.setLevel(currRow.getLevel() + 1);
                    results.add(ind + (++offset), row);
                    currRow.setParent(true);
                }
            }

            if (ind < results.size()) {
                ind++;
            }
        }
        return results;
    }

    public List<TOrg> queryOrgListByRootIdLite(String id) {
        List<TOrg> orgRows = orgDao.selectAllLite();
        List<TOrg> results = new ArrayList<TOrg>();

        for (TOrg row : orgRows) {
            if (row.getcId().equals(id)) {
                row.setLevel(0);
                results.add(row);
                break;
            }
        }

        int ind = 0;
        while (ind < results.size()) {
            int offset = 0;
            TOrg currRow = results.get(ind);

            for (TOrg row : orgRows) {
                if (row.getcParentId().equals(currRow.getcId()) && !results.contains(row)) {
                    row.setLevel(currRow.getLevel() + 1);
                    results.add(ind + (++offset), row);
                    currRow.setParent(true);
                }
            }

            if (ind < results.size()) {
                ind++;
            }
        }
        return results;
    }

    public List<String> queryOrgIdListByRootId(String id) {
        List<TOrg> orgRows = orgDao.selectAllIds();
        List<String> results = new ArrayList<String>();

        for (TOrg row : orgRows) {
            if (row.getcId().equals(id)) {
                results.add(row.getcId());
                break;
            }
        }

        int ind = 0;
        while (ind < results.size()) {
            int offset = 0;
            String currId = results.get(ind);

            for (TOrg row : orgRows) {
                if (row.getcParentId().equals(currId) && !results.contains(row.getcId())) {
                    results.add(ind + (++offset), row.getcId());
                }
            }

            if (ind < results.size()) {
                ind++;
            }
        }
        return results;
    }

    public List<TOrg> queryUpperOrgListByIdLite(String id) {
        List<TOrg> results = new LinkedList<TOrg>();

        do {

            TOrg org = orgDao.selectOneByIdLite(id);
            if (org == null) {
                break;
            }
            results.add(org);

            String rootId = org.getcRootId();
            do {
                org = orgDao.selectOneByIdLite(org.getcParentId());
                if (org == null) {
                    break;
                }
                results.add(org);
            } while (!org.getcId().equals(rootId));

        }
        while (false);

        return results;
    }

    public TOrg queryOrgByCode(String code) {
        TOrg org = orgDao.selectOneByCode(code);
        return org;
    }

    public TOrg queryOrgByCodeWithExclusion(String code, String excludeId) {
        TOrg org = orgDao.selectOneByCodeWithExcludeId(code, excludeId);
        return org;
    }

    public TOrg queryOrgById(String code) {
        TOrg org = orgDao.selectOneById(code);
        return org;
    }

    public boolean orgExistsById(String id) {
        return orgDao.ifExistsById(id) > 0;

    }

    public boolean isOrgBelongToTargetOrg(String targetId, String id) {
        List<String> orgList = this.queryOrgIdListByRootId(targetId);
        return orgList.contains(id);
    }

    @ServiceLog
    @Transactional
    public String addOrg(TOrg org, String rootOrgId, String creatorId) {

        String id = idxDao.selectNextId("t_org");

        org.setcId(id);
        org.setcRootId(rootOrgId);
        org.setcCreator(creatorId);
        org.setcAvailable(true);
        org.setcOrderNum(1);
        org.setcCreateTime(new Date());
        org.setcModifyTime(new Date());
        orgDao.insertOne(org);

        return org.getcId();
    }

    @ServiceLog
    public void modOrgById(TOrg org) {
        orgDao.updateOneById(org);
    }

    @ServiceLog
    public void delOrgById(String id) {
        orgDao.deleteOneById(id);
    }

}
