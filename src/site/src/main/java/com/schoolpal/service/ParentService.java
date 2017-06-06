package com.schoolpal.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.inf.TParentMapper;
import com.schoolpal.db.model.TParent;
import com.schoolpal.web.consts.LogLevel;

@Service
public class ParentService {

	@Autowired
	private LogService logServ;
	
	@Autowired
	private TIndexMapper idxDao; 
	@Autowired
	private TParentMapper parentDao; 

	public TParent queryParentById(String id){
		TParent ret = null;
		try{			
			ret = parentDao.selectOneById(id);
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public String addParent(TParent parent){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_parent");
			parent.setId(id);
			parent.setCreateTime(new Date());
			parent.setLastUpdate(new Date());
			if (parentDao.insertOne(parent) > 0){
				ret = parent.getId();
			}
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean modParent(TParent parent){
		boolean ret = false;
		try{
			parent.setLastUpdate(new Date());
			ret = parentDao.updateOne(parent) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean delParentById(String id){
		boolean ret = false;
		try{
			ret = parentDao.deleteOneById(id) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
}
