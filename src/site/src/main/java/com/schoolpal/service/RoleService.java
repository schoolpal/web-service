package com.schoolpal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.TOrgMapper;
import com.schoolpal.db.inf.TRoleMapper;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TRole;

@Service
public class RoleService {

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
}
