package com.schoolpal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.inf.TLeadsMapper;
import com.schoolpal.db.inf.TLeadsParentMapper;
import com.schoolpal.db.inf.TLeadsSourceMapper;
import com.schoolpal.db.inf.TLeadsStageMapper;
import com.schoolpal.db.inf.TLeadsStatusMapper;
import com.schoolpal.db.inf.TLeadsStudentMapper;
import com.schoolpal.db.model.TLeads;
import com.schoolpal.db.model.TLeadsParent;
import com.schoolpal.db.model.TLeadsSource;
import com.schoolpal.db.model.TLeadsStage;
import com.schoolpal.db.model.TLeadsStatus;
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
	@Autowired
	private TLeadsSourceMapper sourceDao; 
	@Autowired
	private TLeadsStageMapper stageDao; 
	@Autowired
	private TLeadsStatusMapper statusDao; 

	public List<TLeads> queryLeadsListByOrgId(String orgId, Integer typeId){
		List<TLeads> ret = null;
		try{			
			ret =leadsDao.selectManyByOrgAndTypeId(orgId, typeId);
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;		
	}
	
	public TLeads queryLeadsById(String id){
		TLeads ret = null;
		try{			
			ret =leadsDao.selectOneById(id);
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
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
	
	public boolean modLeads(TLeads leads){
		boolean ret = false;
		try{
			leads.setLastUpdate(new Date());
			
			ret = leadsDao.updateOne(leads) > 0;
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean delLeadsById(String id){
		boolean ret = false;
		try{
			ret = leadsDao.deleteOneById(id) > 0;
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
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
	
	public boolean modParent(TLeadsParent parent){
		boolean ret = false;
		try{
			if (StringUtils.isEmpty(parent.getId())){
				List<String> ids = parentDao.selectIdsByLeadsId(parent.getLeadsId());
				if (ids.size() > 1){
					throw new Exception("More than one student found");
				}
				parent.setId(ids.get(0));
			}
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
	
	public boolean delParentByLeadsId(String leadsId){
		boolean ret = false;
		try{
			ret = parentDao.deleteManyByLeadsId(leadsId) > 0;
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
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
	
	public boolean modStudent(TLeadsStudent student){
		boolean ret = false;
		try{
			if (StringUtils.isEmpty(student.getId())){
				List<String> ids = studentDao.selectIdsByLeadsId(student.getLeadsId());
				if (ids.size() > 1){
					throw new Exception("More than one student found");
				}
				student.setId(ids.get(0));
			}
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

	public boolean delStudentByLeadsId(String leadsId){
		boolean ret = false;
		try{
			ret = studentDao.deleteManyByLeadsId(leadsId) > 0;
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}

	public List<TLeadsSource> queryLeadsSourcesByTypeId(Integer typeId){
		List<TLeadsSource> ret = null;
		try{
			ret = sourceDao.selectManyByTypeId(typeId);
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}

	public List<TLeadsStage> queryLeadsStagesByTypeId(Integer typeId){
		List<TLeadsStage> ret = null;
		try{
			ret = stageDao.selectManyByTypeId(typeId);
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}

	public List<TLeadsStatus> queryLeadsStatusByTypeId(Integer typeId){
		List<TLeadsStatus> ret = null;
		try{
			ret = statusDao.selectManyByTypeId(typeId);
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}

}
