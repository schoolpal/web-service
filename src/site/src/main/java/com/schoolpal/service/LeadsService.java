package com.schoolpal.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.TActivityMapper;
import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.inf.TLeadsMapper;
import com.schoolpal.db.model.TActivity;
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

	public List<TLeads> queryLeadsByOrgId(String id){
		return null;
		
	}
	
	public TLeads queryLeadsById(String id){
		return null;
		
	}
	
	public String addParent(TLeadsParent leads){
		return null;
		
	}
	
	public String modParent(TLeadsParent leads){
		return null;
		
	}
	
	public String delParentByLeadsId(String id){
		return null;
		
	}
	
	public String addStudent(TLeadsStudent leads){
		return null;
		
	}
	
	public String modStudent(TLeadsStudent leads){
		return null;
		
	}
	
	public String delStudentByLeadsId(String id){
		return null;
		
	}

	public String addLeads(TLeads leads){
		return null;
		
	}
	
	public String modLeads(TLeads leads){
		return null;
		
	}
	
	public String delLeadsById(String id){
		return null;
		
	}
}
