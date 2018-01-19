package com.schoolpal.service;

import com.schoolpal.aop.ServiceLog;
import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.inf.TActivityMapper;
import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.model.TActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private TIndexMapper idxDao;
    @Autowired
    private TActivityMapper activityDao;

    public List<TActivity> queryTopLevelActivities() {
        return activityDao.selectManyByTopLevel();
    }

    public List<TActivity> queryActivitiesByParentId(String id) {
        return activityDao.selectManyByParentId(id);
    }

    public TActivity queryActivityById(String id) {
        return activityDao.selectOneById(id);
    }

    public List<TActivity> queryActivitiesByOrgId(String orgId) {
        List<TActivity> allRows = activityDao.selectManyByOrgId(orgId);
        List<TActivity> results = new ArrayList<TActivity>();

        for (TActivity row : allRows) {
            if (row.getId().equals(row.getRootId())) {
                row.setLevel(0);
                results.add(row);
            }
        }

        int i = 0;
        while (i < results.size()) {
            int offset = 0;
            TActivity currRow = results.get(i);

            for (TActivity row : allRows) {
                if (row.getParentId().equals(currRow.getId()) && !results.contains(row)) {
                    row.setLevel(currRow.getLevel() + 1);
                    results.add(i + (++offset), row);
                    currRow.setParent(true);
                }
            }

            if (i < results.size()) {
                i++;
            }
        }
        return results;
    }

    @ServiceLog
    @Transactional
    public String addActivity(TActivity act) {
        String ret = null;

        String id = idxDao.selectNextId("t_activity");
        act.setId(id);
        if (act.getParentId() == null) {
            act.setParentId(id);
        }
        if (act.getRootId() == null) {
            act.setRootId(id);
        }
        act.setLeads(0);
        act.setOpportunities(0);
        act.setContracts(0);
        act.setTotalAmount(new BigDecimal(0));

        act.setCreateTime(new Date());
        act.setLastUpdate(new Date());

        if (activityDao.insertOne(act) > 0) {
            ret = act.getId();
        }

        return ret;
    }

    @ServiceLog
    public void modActivity(TActivity act) {

        act.setLastUpdate(new Date());
        activityDao.updateOneById(act);
    }

    @ServiceLog
    public void delActivityById(String id) {

        activityDao.deleteOneById(id);
    }

    @ServiceLog
    public void updateLeadsCountsById(String id) {

        activityDao.updateLeadsCountsById(id);
    }

}
