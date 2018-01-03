package com.schoolpal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.TContractMapper;
import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.model.TContract;
import com.schoolpal.consts.LogLevel;

@Service
public class ContractService {

	@Autowired
	private LogService logServ;
	
	@Autowired
	private TIndexMapper idxDao; 
	@Autowired
	private TContractMapper contractDao; 

	public TContract queryContractById(String id){
		TContract ret = null;
		try{			
			ret = contractDao.selectOneById(id);
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public List<TContract> queryContractsByExecutiveId(String id){
		List<TContract> ret = null;
		try{			
			ret = contractDao.selectManyByExecutiveId(id);
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public String addContract(TContract contract){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_contract");
			contract.setId(id);
			contract.setCreateTime(new Date());
			if (contractDao.insertOne(contract) > 0){
				ret = contract.getId();
			}
			
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean modContract(TContract contract){
		boolean ret = false;
		try{
			ret = contractDao.updateOne(contract) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
	public boolean delContractById(String id){
		boolean ret = false;
		try{
			ret = contractDao.deleteOneById(id) > 0;
		}catch(Exception e){
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
			logServ.log("", LogLevel.ERROR, stacks[2].getClassName() + "." + stacks[2].getMethodName(), "", e.getMessage());
		}
		return ret;
	}
	
}
