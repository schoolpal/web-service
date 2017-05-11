package com.schoolpal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.inf.TLeadsMapper;
import com.schoolpal.db.inf.TLeadsParentMapper;
import com.schoolpal.db.inf.TLeadsStudentMapper;
import com.schoolpal.db.model.TLeads;
import com.schoolpal.db.model.TLeadsParent;
import com.schoolpal.db.model.TLeadsStudent;
import com.schoolpal.web.consts.LogLevel;

@Service
public class LeadsService {

	@Autowired
	private LogService logServ;
	
	@Autowired
	private TIndexMapper idxDao; 
	@Autowired
	private TLeadsMapper leadsDao; 
	@Autowired
	private TLeadsParentMapper parentDao; 
	@Autowired
	private TLeadsStudentMapper studentDao; 

	public List<TLeads> queryLeadsByOrgId(String id){
		return null;
		
	}
	
	public TLeads queryLeadsById(String id){
		return null;
		
	}
	
	public String addLeads(TLeads leads){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_leads");
			leads.setId(id);
			
			leads.setCreateTime(new Date());
			leads.setLastUpdate(new Date());
			
			if (leadsDao.insertOne(leads) > 0){
				ret = leads.getId();
			}
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public String modLeads(TLeads leads){
		return null;
		
	}
	
	public String delLeadsById(String id){
		return null;
		
	}
	
	public String addParent(TLeadsParent parent){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_leads_parent");
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
	
	public String modParent(TLeadsParent leads){
		return null;
		
	}
	
	public String delParentByLeadsId(String id){
		return null;
		
	}
	
	public String addStudent(TLeadsStudent student){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_leads_student");
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
	
	public String modStudent(TLeadsStudent leads){
		return null;
		
	}
	
	public String delStudentByLeadsId(String id){
		return null;
		
	}


}
