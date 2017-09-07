package com.schoolpal.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.inf.TParStuMapper;
import com.schoolpal.db.inf.TParentMapper;
import com.schoolpal.db.model.TParStu;
import com.schoolpal.db.model.TParStuKey;
import com.schoolpal.db.model.TParent;
import com.schoolpal.web.consts.LogLevel;

@Service
public class RelationService {

	@Autowired
	private LogService logServ;
	
	@Autowired
	private TParStuMapper relationDao; 

	public boolean addRelation(String parId, String stuId, String relationDesc){
		boolean ret = false;
		try{
			TParStu relation = new TParStu();
			relation.setParId(parId);
			relation.setStuId(stuId);
			relation.setRelation(relationDesc);
			ret = relationDao.insertOne(relation) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean delRelation(String parId, String stuId){
		boolean ret = false;
		try{
			TParStuKey key = new TParStuKey();
			key.setParId(parId);
			key.setStuId(stuId);
			ret = relationDao.deleteOneByPrimaryKey(key) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean delRelationsByParId(String parId){
		boolean ret = false;
		try{
			ret = relationDao.deleteManyByParId(parId) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean delRelationsByStuId(String stuId){
		boolean ret = false;
		try{
			ret = relationDao.deleteManyByStuId(stuId) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
}
