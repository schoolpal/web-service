package com.schoolpal.service;

import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.inf.TCourseTypeMapper;
import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.model.TCourseSession;
import com.schoolpal.db.model.TCourseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTypeService {

	@Autowired
	private LogService logServ;
	
	@Autowired
	private TIndexMapper idxDao; 
	@Autowired
	private TCourseTypeMapper courseTypeSessionDao;

	public TCourseType queryCourseTypeById(Integer id){
		TCourseType ret = null;
		try{
			ret = courseTypeSessionDao.selectOneById(id);
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}

	public List<TCourseType> queryCourseTypeList(){
		List<TCourseType> ret = null;
		try{
			ret = courseTypeSessionDao.selectAll();
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}

/*
	public String addStudent(TStudent student){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_student");
			student.setId(id);
			student.setCreateTime(new Date());
			student.setLastUpdate(new Date());
			if (courseTypeSessionDao.insertOne(student) > 0){
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
			ret = courseTypeSessionDao.updateOne(student) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean delStudentById(String id){
		boolean ret = false;
		try{
			ret = courseTypeSessionDao.deleteOneById(id) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
*/
}