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
import com.schoolpal.web.model.RoleForm;

@Service
public class RoleService {

	@Autowired
	private TIndexMapper idxDao; 
	@Autowired
	private TRoleMapper roleDao; 

	@Autowired
	private LogService logServ;

	public List<TRole> getRoleListByOrgId(String id){
		List<TRole> roleList = roleDao.selectRolesByOrgId(id);
		return roleList;
	}
	
	public TRole getRoleById(String id){
		TRole role = roleDao.selectOneById(id);
		return role;
	}
	
	public String AddRole(RoleForm form, String creatorId){
		String ret = null;
		try{
			String id = idxDao.selectNextId("t_role");
			TRole org = this.RoleFormToTRole(form);
			org.setcId(id);
			org.setcCreator(creatorId);
			org.setcAvailable(true);
			org.setcOrderNum(1);
//			if (orgDao.insertOne(org) > 0){
//				ret = id;
//			}
		}catch(Exception e){
			logServ.log("", LogLevel.ERROR, "AjaxOrgController.AddOrg()", "", e.getMessage());
		}
		return ret;
	}
	
	public boolean ModRoleById(RoleForm form){
		boolean ret = false;
		try{
			TRole role = this.RoleFormToTRole(form);
//			ret = orgDao.updateOneById(role) > 0;
		}catch(Exception e){
			logServ.log("", LogLevel.ERROR, "AjaxOrgController.ModOrg()", "", e.getMessage());
		}
		return ret;
	}
		
	public boolean DeleteRoleById(String id){
		boolean ret = false;
		try{
//			ret = orgDao.deleteOneById(id) > 0;
		}catch(Exception e){
			logServ.log("", LogLevel.ERROR, "AjaxOrgController.DelOrgById()", "", e.getMessage());
		}
		return ret;
	}
	
	private TRole RoleFormToTRole(RoleForm form){
		if (form == null) {
			return null;
		}
		
		TRole role = new TRole();
		role.setcId(form.getId());
/*		role.setcCode(form.getCode());
		role.setcName(form.getName());
		
		role.setcState(form.getState());
		role.setcCity(form.getCity());
		role.setcCounty(form.getCounty());
		role.setcAddress(form.getAddress());
	
		role.setcParentId(form.getParentId());
		role.setcOwner(form.getOwner());
		role.setcOwnerPhone(form.getPhone());
*/		
		return role; 
	}
}
