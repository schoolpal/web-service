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

	public List<TRole> getRoleListByOrgId(String id) {
		List<TRole> roleList = roleDao.selectRolesByOrgId(id);
		return roleList;
	}

	public TRole getRoleById(String id) {
		TRole role = roleDao.selectOneById(id);
		return role;
	}

	public String addRole(RoleForm form, String creatorId) {
		String ret = null;

		do {
			TRole role = this.roleFormToTRole(form);
			role.setcCreator(creatorId);
			role.setcAvailable(true);
			role.setcOrderNum(1);

			try {
				String id = idxDao.selectNextId("t_role");
				role.setcId(id);
				if (roleDao.insertOne(role) <= 0) {
					break;
				}

				ret = id;
			} catch (Exception e) {
				logServ.log("", LogLevel.ERROR, "RoleService.addRole()", "", e.getMessage());
			}

		} while (false);

		return ret;
	}

	public boolean modRoleById(RoleForm form) {
		boolean ret = false;
		do {
			TRole role = this.roleFormToTRole(form);
			role.setcAvailable(true);
			role.setcOrderNum(1);

			try {
				ret = roleDao.updateOneById(role) > 0;
			} catch (Exception e) {
				logServ.log("", LogLevel.ERROR, "RoleService.modRoleById()", "", e.getMessage());
				ret = false;
				break;
			}
		} while (false);

		return ret;
	}

	public boolean delRoleById(String id) {
		boolean ret = false;
		try {
			ret = roleDao.deleteOneById(id) > 0;
		} catch (Exception e) {
			logServ.log("", LogLevel.ERROR, "RoleService.deleteRoleById()", "", e.getMessage());
		}
		return ret;
	}

	private TRole roleFormToTRole(RoleForm form) {
		if (form == null) {
			return null;
		}

		TRole role = new TRole();
		role.setcId(form.getId());
		role.setcName(form.getName());
		role.setcOrgId(form.getOrgId());
//		role.getFunctions(form.getStrFuncIds()
//		form.getRankId()
//		form.getName()
//		form.getDesc()
//		private String orgId;
//		private String orgHierarchy;
//		private String strFuncIds;
//		private int rankId;
//		private String name;
//		private String desc;

		return role;
	}
}
