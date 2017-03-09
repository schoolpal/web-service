package com.schoolpal.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.inf.*;
import com.schoolpal.db.model.*;
import com.schoolpal.web.consts.LogLevel;
import com.schoolpal.web.model.RoleForm;

@Service
public class RoleService {

	@Autowired
	private TIndexMapper idxDao;
	@Autowired
	private TRoleMapper roleDao;
	@Autowired
	private TRoleFunctionMapper roleFuncDao;
	@Autowired
	private TRoleFunctionExcludeMapper roleExcFuncDao;
	@Autowired
	private TFunctionMapper funcDao;
	@Autowired
	private TRankMapper rankDao;

	@Autowired
	private LogService logServ;

	public List<TRole> queryRoleListByOrgId(String id) {
		List<TRole> roleList = roleDao.selectRolesByOrgId(id);
		for (TRole role : roleList) {
			role.setRootFuncs(roleFuncDao.selectRootFuncsByRoleId(role.getcId()));
		}
		return roleList;
	}

	public TRole queryRoleById(String id) {
		TRole role = roleDao.selectOneById(id);
		role.setRootFuncs(roleFuncDao.selectRootFuncsByRoleId(id));
		role.setFunctions(roleFuncDao.selectAllFuncsByRoleId(id));
		return role;
	}

	public boolean roleExists(String id){
		return roleDao.ifExistsById(id) > 0;
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
		role.setcRankId(form.getRankId());
		role.setcDesc(form.getDesc());

		return role;
	}

	public boolean addRoleRootFunc(String roleId, String rootFuncId) {
		boolean ret = true;

		TRoleFunction roleFunc = new TRoleFunction();
		roleFunc.setcRoleId(roleId);
		roleFunc.setcFunctionRootId(rootFuncId);
		roleFunc.setcOrderNum(1);

		try {
			roleFuncDao.insertOne(roleFunc);
		} catch (Exception e) {
			ret = false;
		}

		return ret;
	}

	public boolean addRoleRootFuncs(String roleId, String[] rootFuncIds) {
		boolean ret = true;
		for (String rootFuncId : rootFuncIds) {
			if (rootFuncId.length() == 0) {
				continue;
			}

			if (funcDao.ifExistsById(rootFuncId) < 1) {
				logServ.log("", LogLevel.ERROR, "RoleService.addRoleRootFuncs()", "", "Function id not exists");
				continue;
			}

			if(!this.addRoleRootFunc(roleId, rootFuncId)){
				ret = false;
				break;
			}
		}

		return ret;
	}

	public boolean delRootFuncsByRoleId(String roleId) {
		return roleFuncDao.deleteManyByRoleId(roleId) > 0;
	}

	public boolean addRoleExcFunc(String roleId, String funcId, String creatorId) {
		boolean ret = true;

		TRoleFunctionExclude roleExcFunc = new TRoleFunctionExclude();
		roleExcFunc.setcRoleId(roleId);
		roleExcFunc.setcFunctionId(funcId);
		roleExcFunc.setcCreator(creatorId);

		try {
			roleExcFuncDao.insertOne(roleExcFunc);
		} catch (Exception e) {
			ret = false;
		}

		return ret;
	}

	public boolean addRoleExcFuncs(String roleId, String[] funcIds, String creatorId) {
		boolean ret = true;
		for (String funcId : funcIds) {
			if (funcId.length() == 0) {
				continue;
			}

			if (funcDao.ifExistsById(funcId) < 1) {
				logServ.log("", LogLevel.ERROR, "RoleService.addRoleExcFuncs()", "", "Function id not exists");
				continue;
			}

			if(!this.addRoleExcFunc(roleId, funcId, creatorId)){
				ret = false;
				break;
			}
		}

		return ret;
	}

	public boolean delExcFuncsByRoleId(String roleId) {
		return roleExcFuncDao.deleteManyByRoleId(roleId) > 0;
	}

	public List<TRank> queryRankList() {
		return rankDao.selectAll();
	}
}
