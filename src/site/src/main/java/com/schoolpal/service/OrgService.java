package com.schoolpal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.*;
import com.schoolpal.db.model.*;
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

	public List<TOrg> queryOrgListByRootId(String id){
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

	public List<TOrg> queryOrgListByRootIdLite(String id){
		List<TOrg> orgRows = orgDao.selectAllLite();
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

	public List<String> queryOrgIdListByRootId(String id){
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

	public TOrg queryOrgByCode(String code){
		TOrg org = orgDao.selectOneByCode(code);
		return org;
	}

	public TOrg queryOrgByCodeWithExclusion(String code, String excludeId){
		TOrg org = orgDao.selectOneByCodeWithExcludeId(code, excludeId);
		return org;
	}

	public TOrg queryOrgById(String code){
		TOrg org = orgDao.selectOneById(code);
		return org;
	}
	
	public boolean orgExistsById(String id){
		return  orgDao.ifExistsById(id) > 0;
		
	}
	
	public boolean isOrgBelongToTargetOrg(String targetId, String id){
		List<String> orgList = this.queryOrgIdListByRootId(targetId);
		return orgList.contains(id);
	}
	
	public String addOrg(OrgForm form, String rootOrgId, String creatorId){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_org");
			TOrg org = this.orgFormToTOrg(form);
			org.setcId(id);
			org.setcRootId(rootOrgId);
			org.setcCreator(creatorId);
			org.setcAvailable(true);
			org.setcOrderNum(1);
			org.setcCreateTime(new Date());
			org.setcModifyTime(new Date());
			if (orgDao.insertOne(org) > 0){
				ret = id;
			}
		}catch(Exception e){
			logServ.log("", LogLevel.ERROR, "OrgService.AddOrg()", "", e.getMessage());
		}
		return ret;
	}
	
	public boolean modOrgById(OrgForm form){
		boolean ret = false;
		try{
			TOrg org = this.orgFormToTOrg(form);
			ret = orgDao.updateOneById(org) > 0;
		}catch(Exception e){
			logServ.log("", LogLevel.ERROR, "OrgService.ModOrg()", "", e.getMessage());
		}
		return ret;
	}
		
	public boolean delOrgById(String id){
		boolean ret = false;
		try{
			ret = orgDao.deleteOneById(id) > 0;
		}catch(Exception e){
			logServ.log("", LogLevel.ERROR, "OrgService.DelOrgById()", "", e.getMessage());
		}
		return ret;
	}
	
	public boolean delOrgByCode(String code){
		return false;
	}
	
	private TOrg orgFormToTOrg(OrgForm form){
		if (form == null) {
			return null;
		}
		
		TOrg org = new TOrg();
		org.setcId(form.getId());
		org.setcCode(form.getCode());
		org.setcName(form.getName());
		
		org.setcState(form.getState());
		org.setcCity(form.getCity());
		org.setcCounty(form.getCounty());
		org.setcStateCode(form.getStateCode());
		org.setcCityCode(form.getCityCode());
		org.setcCountyCode(form.getCountyCode());
		org.setcAddress(form.getAddress());
	
		org.setcParentId(form.getParentId());
		org.setcOwner(form.getOwner());
		org.setcOwnerPhone(form.getPhone());
		
		return org; 
	}
}
