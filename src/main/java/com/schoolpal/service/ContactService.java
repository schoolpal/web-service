package com.schoolpal.service;

import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.inf.TContactApproachMapper;
import com.schoolpal.db.inf.TContactMapper;
import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.model.TContact;
import com.schoolpal.db.model.TContactApproach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContactService {

	@Autowired
	private LogService logServ;
	
	@Autowired
	private TIndexMapper idxDao; 
	@Autowired
	private TContactMapper contactDao; 
	@Autowired
	private TContactApproachMapper approachDao; 

	public TContact queryContactById(String id){
		TContact ret = null;
		try{			
			ret = contactDao.selectOneById(id);
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public List<TContact> queryContactsByLeadsId(String leadsId){
		List<TContact> ret = null;
		try{
			ret = contactDao.selectManyByLeadsId(leadsId);
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;		
	}

	public String addContact(TContact contact){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_contact");
			contact.setId(id);
			if(contact.getDatetime() == null){
				contact.setDatetime(new Date());
			}
			if (contactDao.insertOne(contact) > 0){
				ret = contact.getId();
			}
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean modContact(TContact contact){
		boolean ret = false;
		try{
			if(contact.getDatetime() == null){
				contact.setDatetime(new Date());
			}
			ret = contactDao.updateOne(contact) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean delContactById(String id){
		boolean ret = false;
		try{
			ret = contactDao.deleteOneById(id) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public List<TContactApproach> queryContactApproaches(){
		List<TContactApproach> ret = null;
		try{
			ret = approachDao.selectAll();
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;		
	}
}
