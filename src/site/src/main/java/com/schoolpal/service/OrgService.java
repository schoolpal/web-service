package com.schoolpal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.TIndexMapper;
import com.schoolpal.db.inf.TOrgMapper;
import com.schoolpal.db.inf.TRoleMapper;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TRole;
import com.schoolpal.web.consts.LogLevel;
import com.schoolpal.web.model.OrgForm;

@Service
public class OrgService {

	@Autowired
	private TIndexMapper idxDao; 
	@Autowired
	private TOrgMapper orgDao; 

	@Autowired
	private LogService logServ;

	public List<TOrg> getOrgListByRootId(String id){
		List<TOrg> orgRows = orgDao.selectAll();
		List<TOrg> results = new ArrayList<TOrg>();

		for (TOrg row : orgRows) {
			if (row.getcId().equals(id)) {
				row.setLevel(0);
				results.add(row);
				break;
			}
		}

		int ind = 0;
		while (ind < results.size()) {
			int offset = 0;
			TOrg currRow = results.get(ind);

			for (TOrg row : orgRows) {
				if (row.getcParentId().equals(currRow.getcId()) && !results.contains(row)) {
					row.setLevel(currRow.getLevel() + 1);
					results.add(ind + (++offset), row);
					currRow.setParent(true);
				}
			}

			if (ind < results.size()) {
				ind++;
			}
		}
		return results;
	}

	public List<String> getOrgIdListByRootId(String id){
		List<TOrg> orgRows = orgDao.selectAll();
		List<String> results = new ArrayList<String>();

		for (TOrg row : orgRows) {
			if (row.getcId().equals(id)) {
				results.add(row.getcId());
				break;
			}
		}

		int ind = 0;
		while (ind < results.size()) {
			int offset = 0;
			String currId = results.get(ind);

			for (TOrg row : orgRows) {
				if (row.getcParentId().equals(currId) && !results.contains(row.getcId())) {
					results.add(ind + (++offset), row.getcId());
				}
			}

			if (ind < results.size()) {
				ind++;
			}
		}
		return results;
	}

	public TOrg getOrgByCode(String code){
		TOrg org = orgDao.selectOneByCode(code);
		return org;
	}
	
	public TOrg getOrgById(String code){
		TOrg org = orgDao.selectOneById(code);
		return org;
	}
	
	public String AddOrg(OrgForm form, String rootOrgId, String creatorId){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_org");
			TOrg org = this.OrgFormToTOrg(form);
			org.setcId(id);
			org.setcRootId(rootOrgId);
			org.setcCreator(creatorId);
			org.setcAvailable(true);
			org.setcOrderNum(1);
			if (orgDao.insertOne(org) > 0){
				ret = id;
			}
		}catch(Exception e){
			logServ.log("", LogLevel.ERROR, "AjaxOrgController.AddOrg()", "", e.getMessage());
		}
		return ret;
	}
	
	public boolean ModifyOrg(){
		return false;
	}
	
	public boolean DeleteOrgById(String id){
		boolean ret = false;
		try{
			ret = orgDao.deleteOneById(id) > 0;
		}catch(Exception e){
			logServ.log("", LogLevel.ERROR, "AjaxOrgController.DelOrgById()", "", e.getMessage());
		}
		return ret;
	}
	
	public boolean DelOrgByCode(String code){
		return false;
	}
	
	private TOrg OrgFormToTOrg(OrgForm form){
		if (form == null) {
			return null;
		}
		
		TOrg org = new TOrg();
		org.setcAddress(form.getAddress());
		org.setcCity(form.getCity());
		org.setcCode(form.getCode());
		org.setcCounty(form.getCounty());
		org.setcId(form.getId());
		org.setcName(form.getName());
		org.setcOwner(form.getOwner());
		org.setcParentId(form.getParentId());
		org.setcOwnerPhone(form.getPhone());
		org.setcState(form.getState());
		
		return org; 
	}
}
