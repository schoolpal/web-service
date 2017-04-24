package com.schoolpal.service;

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
	
	public int addActivity(TActivity act){
		int ret = 0;
		if(activityDao.insertOne(act) > 0){
			ret = act.getId();
		}
		return ret;
	}
}
