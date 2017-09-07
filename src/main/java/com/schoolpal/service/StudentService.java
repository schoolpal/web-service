package com.schoolpal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.inf.TStudentMapper;
import com.schoolpal.db.model.TStudent;
import com.schoolpal.web.consts.LogLevel;

@Service
public class StudentService {

	@Autowired
	private LogService logServ;
	
	@Autowired
	private TIndexMapper idxDao; 
	@Autowired
	private TStudentMapper studentDao; 

	public TStudent queryStudentById(String id){
		TStudent ret = null;
		try{			
			ret = studentDao.selectOneById(id);
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public TStudent queryStudentByCode(String code){
		TStudent ret = null;
		try{			
			ret = studentDao.selectOneByCode(code);
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public List<TStudent> queryStudentsByExecutiveId(String id){
		List<TStudent> ret = null;
		try{			
			ret = studentDao.selectManyByExectiveId(id);
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public String addStudent(TStudent student){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_student");
			student.setId(id);
			student.setCreateTime(new Date());
			student.setLastUpdate(new Date());
			if (studentDao.insertOne(student) > 0){
				ret = student.getId();
			}
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean modStudent(TStudent student){
		boolean ret = false;
		try{
			student.setLastUpdate(new Date());
			ret = studentDao.updateOne(student) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean delStudentById(String id){
		boolean ret = false;
		try{
			ret = studentDao.deleteOneById(id) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
}
