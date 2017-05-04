package com.schoolpal.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.TActivityMapper;
import com.schoolpal.db.model.TActivity;
import com.schoolpal.web.consts.LogLevel;

@Service
public class ActivityService {

	@Autowired
	private LogService logServ;
	
	@Autowired
	private TActivityMapper activityDao; 

	public List<TActivity> queryTopLevelActivities(){
		return activityDao.selectManyByTopLevel();
	}
	
	public List<TActivity> queryActivitiesByParentId(int id){
		return activityDao.selectManyByParentId(id);
	}
	
	public TActivity queryActivityById(int id){
		return activityDao.selectOneById(id);
	}
	
	public List<TActivity> queryActivityList(){
		List<TActivity> allRows = activityDao.selectAll();
		List<TActivity> results = new ArrayList<TActivity>();

		for (TActivity row : allRows) {
			if (row.getId() == row.getRootId()) {
				row.setLevel(0);
				results.add(row);
				break;
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

	public int addActivity(TActivity act){
		int ret = 0;
		try{
			act.setLeads(0);
			act.setOpportunities(0);
			act.setContracts(0);
			act.setTotalAmount(new BigDecimal(0));
			
			act.setCreateTime(new Date());
			act.setLastUpdate(new Date());
			
			if (activityDao.insertOne(act) > 0){
				ret = act.getId();
			}
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean modActivity(TActivity act){
		boolean ret = false;
		try{
			act.setLastUpdate(new Date());
			ret = activityDao.updateOneById(act) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean delActivity(int id){
		boolean ret = false;
		try{
			ret = activityDao.deleteOneById(id) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
}
