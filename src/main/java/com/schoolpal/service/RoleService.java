package com.schoolpal.service;

import com.schoolpal.aop.ServiceLog;
import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.inf.*;
import com.schoolpal.db.model.TRank;
import com.schoolpal.db.model.TRole;
import com.schoolpal.db.model.TRoleFunction;
import com.schoolpal.db.model.TRoleFunctionExclude;
import com.schoolpal.web.model.RoleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

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

    public List<TRole> queryRoleListByOrgIdLite(String id) {
        List<TRole> roleList = roleDao.selectRolesByOrgIdLite(id);
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

    public boolean roleExists(String id) {
        return roleDao.ifExistsById(id) > 0;
    }

    public boolean systemRoleCoexistWithOtherRoles(String[] ids) {
        return roleDao.getCountByPrimaryIdsAndRankId(ids, 4) > 0;
    }

    @ServiceLog
    @Transactional
    public String addRole(TRole role, String creatorId) {

        role.setcCreator(creatorId);
        role.setcAvailable(true);
        role.setcOrderNum(1);

        String id = idxDao.selectNextId("t_role");
        role.setcId(id);
        roleDao.insertOne(role);

        return role.getcId();
    }

    @ServiceLog
    public void modRoleById(TRole role) {
        role.setcAvailable(true);
        role.setcOrderNum(1);
        roleDao.updateOneById(role);
    }

    @ServiceLog
    public void delRoleById(String id) {
        roleDao.deleteOneById(id);
    }

    @ServiceLog
    public void addRoleRootFunc(String roleId, String rootFuncId) {

        TRoleFunction roleFunc = new TRoleFunction();
        roleFunc.setcRoleId(roleId);
        roleFunc.setcFunctionRootId(rootFuncId);
        roleFunc.setcOrderNum(1);

        roleFuncDao.insertOne(roleFunc);
    }

    @ServiceLog
    @Transactional
    public void addRoleRootFuncs(String roleId, String[] rootFuncIds) {
        for (String rootFuncId : rootFuncIds) {
            if (StringUtils.isEmpty(rootFuncId.length())) {
                continue;
            }

            if (funcDao.ifExistsById(rootFuncId) < 1) {
                continue;
            }

            this.addRoleRootFunc(roleId, rootFuncId);
        }
    }

    @ServiceLog
    public void delRootFuncsByRoleId(String roleId) {
        roleFuncDao.deleteManyByRoleId(roleId);
    }

    @ServiceLog
    public void addRoleExcFunc(String roleId, String funcId, String creatorId) {

        TRoleFunctionExclude roleExcFunc = new TRoleFunctionExclude();
        roleExcFunc.setcRoleId(roleId);
        roleExcFunc.setcFunctionId(funcId);
        roleExcFunc.setcCreator(creatorId);

        roleExcFuncDao.insertOne(roleExcFunc);
    }

    @ServiceLog
    @Transactional
    public void addRoleExcFuncs(String roleId, String[] funcIds, String creatorId) {
        for (String funcId : funcIds) {
            if (StringUtils.isEmpty(funcId.length())) {
                continue;
            }

            if (funcDao.ifExistsById(funcId) < 1) {
                continue;
            }

            this.addRoleExcFunc(roleId, funcId, creatorId);
        }
    }

    @ServiceLog
    public void delExcFuncsByRoleId(String roleId) {
        roleExcFuncDao.deleteManyByRoleId(roleId);
    }

    public List<TRank> queryRankList() {
        return rankDao.selectAll();
    }
}
