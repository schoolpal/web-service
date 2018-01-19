package com.schoolpal.service;

import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.inf.TCourseSessionMapper;
import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.model.TCourseSession;
import com.schoolpal.db.model.TStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseSessionService {

    @Autowired
    private LogService logServ;

    //	@Autowired
//	private TIndexMapper idxDao;
    @Autowired
    private TCourseSessionMapper courseSessionDao;

    public TCourseSession queryCourseSessionById(String id) {
        return courseSessionDao.selectOneById(id);
    }

    public List<TCourseSession> queryCourseSessionListByTypeId(Integer typeId) {
        return courseSessionDao.selectManyByTypeId(typeId);
    }
/*
    public String addStudent(TStudent student){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_student");
			student.setId(id);
			student.setCreateTime(new Date());
			student.setLastUpdate(new Date());
			if (courseSessionDao.insertOne(student) > 0){
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
			ret = courseSessionDao.updateOne(student) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean delStudentById(String id){
		boolean ret = false;
		try{
			ret = courseSessionDao.deleteOneById(id) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
*/
}
