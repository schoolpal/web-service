package com.schoolpal.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.TActivityMapper;
import com.schoolpal.db.model.TActivity;

@Service
public class ActivityService {

	@Autowired
	private TActivityMapper activityDao; 

	public List<TActivity> queryTopLevelActivities(){
		return activityDao.selectManyByTopLevel();
	}
	
	public List<TActivity> queryActivitiesByParentId(int id){
		return activityDao.selectManyByParentId(id);
	}
	
	public boolean addActivity(TActivity act){
		act.setLeads(0);
		act.setOpportunities(0);
		act.setContracts(0);
		act.setTotalAmount(new BigDecimal(0));

		return activityDao.insertOne(act) > 0;
	}
	
	public boolean modActivity(TActivity act){
		return activityDao.updateOneById(act) > 0;
	}
	
	public boolean delActivity(int id){
		return activityDao.deleteOneById(id) > 0;
	}
}
