package com.schoolpal.web.ajax.controller;

import com.schoolpal.aop.AjaxControllerLog;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TRole;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.FunctionService;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.RoleService;
import com.schoolpal.service.UserService;
import com.schoolpal.validation.group.AjaxControllerAdd;
import com.schoolpal.validation.group.AjaxControllerMod;
import com.schoolpal.web.ajax.exception.AjaxException;
import com.schoolpal.web.model.OrgForm;
import com.schoolpal.web.model.RoleForm;
import com.schoolpal.web.model.UserForm;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/ajax/sys/")
public class AjaxSystemController {

    @Autowired
    private UserService userServ;
    @Autowired
    private OrgService orgServ;
    @Autowired
    private RoleService roleServ;
    @Autowired
    private FunctionService funcServ;

    @AjaxControllerLog
    @RequiresPermissions("7-1")
    @RequestMapping(value = "org/list.do", method = RequestMethod.POST)
    public Object listOrgs() {

        TUser user = userServ.getCachedUser();

        List<TOrg> orgList = orgServ.queryOrgListByRootId(user.getcOrgId());

        return orgList;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-1-1")
    @RequestMapping(value = "org/add.do", method = RequestMethod.POST)
    public Object addOrg(@Validated({AjaxControllerAdd.class}) OrgForm form) throws AjaxException {

        TUser user = userServ.getCachedUser();
        TOrg org = orgServ.queryOrgByCode(form.getCode());
        if (org != null) {
            throw new AjaxException(402, "Duplicated organization code");
        }

        TOrg parentOrg = orgServ.queryOrgById(form.getParentId());
        if (parentOrg == null) {
            throw new AjaxException(403, "Parent organization not exist");
        }

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), form.getParentId())) {
            throw new AjaxException(404, "No permission to add orgnization under parent orgnization");
        }

        String id = orgServ.addOrg(form, parentOrg.getcRootId(), user.getcLoginName());
        if (id == null) {
            throw new AjaxException(500, "Failed to add orgnization");
        }

        return id;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-1-2")
    @RequestMapping(value = "org/mod.do", method = RequestMethod.POST)
    public Object modOrg(@Validated({AjaxControllerMod.class}) OrgForm form) throws AjaxException {
        TUser user = userServ.getCachedUser();

        if (form.getParentId() == null || form.getParentId().isEmpty()) {
            throw new AjaxException(402, "Parent id cannot be empty");
        }

        TOrg org = orgServ.queryOrgByCodeWithExclusion(form.getCode(), form.getId());
        if (org != null) {
            throw new AjaxException(403, "Duplicated organization code");
        }

        TOrg parentOrg = orgServ.queryOrgById(form.getParentId());
        if (parentOrg == null) {
            throw new AjaxException(404, "Parent organization not exist");
        }

        if (form.getId() != parentOrg.getcRootId() && form.getParentId() == form.getId()) {
            throw new AjaxException(405, "Parent organization cannot be self");
        }

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), form.getParentId())) {
            throw new AjaxException(406, "No permission to move organization to the parent organization");
        }

        if (!orgServ.modOrgById(form)) {
            throw new AjaxException(500, "Failed to mod organization");
        }

        return true;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-1-3")
    @RequestMapping(value = "org/del.do", method = RequestMethod.POST)
    public Object delOrg(@NotEmpty String id) throws AjaxException {

        TUser user = userServ.getCachedUser();

        if (id == user.getcOrgId()) {
            throw new AjaxException(402, "Cannot delete self-organization");
        }

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), id)) {
            throw new AjaxException(403, "Cannot delete parent-organization");
        }

        if (!orgServ.delOrgById(id)) {
            throw new AjaxException(500, "Failed to delete organization");
        }

        return true;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-2")
    @RequestMapping(value = "role/list.do", method = RequestMethod.POST)
    public Object listRoles(@NotEmpty String id) throws AjaxException {

        TUser user = userServ.getCachedUser();

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), id)) {
            throw new AjaxException(500, "No permission to query organization");
        }

        List<TRole> roles = roleServ.queryRoleListByOrgId(id);

        return roles;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-2-1")
    @RequestMapping(value = "role/add.do", method = RequestMethod.POST)
    @Transactional
    public Object addRole(@Validated({AjaxControllerAdd.class}) RoleForm form) throws AjaxException {

        TUser user = userServ.getCachedUser();

        TOrg org = orgServ.queryOrgById(form.getOrgId());
        if (org == null) {
            throw new AjaxException(402, "Parent organization not exist");
        }

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), form.getOrgId())) {
            throw new AjaxException(403, "No permission to add role under the parent organization");
        }

        String id = roleServ.addRole(form, user.getcLoginName());
        if (id == null) {
            throw new AjaxException(501, "Failed to add role");
        }

        if (form.getStrFuncIds() != null) {
            form.setStrFuncIds(form.getStrFuncIds()
                    .replaceAll(" ", "")
                    .replaceAll(",,", ",")
                    .replaceAll(",$", "")
                    .replaceAll("^,", ""));
            if (!form.getStrFuncIds().isEmpty()) {
                String[] funcIds = form.getStrFuncIds().split(",");
                if (funcIds.length > 0) {
                    if (!roleServ.addRoleRootFuncs(id, funcIds)) {
                        throw new AjaxException(502, "Failed to add role functions");
                    }
                }
            }
        }

        return id;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-2-2")
    @RequestMapping(value = "role/mod.do", method = RequestMethod.POST)
    @Transactional
    public Object modRole(@Validated({AjaxControllerMod.class}) RoleForm form) throws AjaxException {

        TUser user = userServ.getCachedUser();

        TOrg org = orgServ.queryOrgById(form.getOrgId());
        if (org == null) {
            throw new AjaxException(404, "Organization not exist");
        }

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), form.getOrgId())) {
            throw new AjaxException(405, "No permission to move role to the organization");
        }

        if (!roleServ.modRoleById(form)) {
            throw new AjaxException(500, "Failed to mod role");
        }

        roleServ.delRootFuncsByRoleId(form.getId());
        if (form.getStrFuncIds() != null) {
            form.setStrFuncIds(form.getStrFuncIds()
                    .replaceAll(" ", "")
                    .replaceAll(",,", ",")
                    .replaceAll(",$", "")
                    .replaceAll("^,", ""));
            if (!form.getStrFuncIds().isEmpty()) {
                String[] funcIds = form.getStrFuncIds().split(",");
                if (funcIds.length > 0) {
                    if (!roleServ.addRoleRootFuncs(form.getId(), funcIds)) {
                        throw new AjaxException(502, "Failed to add role functions");
                    }
                }
            }
        }

        return true;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-2-3")
    @RequestMapping(value = "role/del.do", method = RequestMethod.POST)
    @Transactional
    public Object delRole(@NotEmpty String id) throws AjaxException {

        TUser user = userServ.getCachedUser();

        TRole role = roleServ.queryRoleById(id);
        if (role == null) {
            throw new AjaxException(402, "Role not found");
        }
        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), role.getcOrgId())) {
            throw new AjaxException(403, "No permission to delete the role under the organization");
        }

        roleServ.delExcFuncsByRoleId(id);
        roleServ.delRootFuncsByRoleId(id);
        if (!roleServ.delRoleById(id)) {
            throw new AjaxException(500, "Failed to delete the role");
        }

        return true;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-3-1")
    @RequestMapping(value = "role/auth.do", method = RequestMethod.POST)
    @Transactional
    public Object addRoleFunc(@NotEmpty String id, @NotNull String funcIds) throws AjaxException {

        funcIds = funcIds
                .replaceAll(" ", "")
                .replaceAll(",,", ",")
                .replaceAll(",$", "")
                .replaceAll("^,", "");
        if (funcIds.isEmpty()) {
            throw new AjaxException(402, "Func ids cannot be empty");
        }

        TUser user = userServ.getCachedUser();

        // Validate role
        TRole role = roleServ.queryRoleById(id);
        if (role == null) {
            throw new AjaxException(403, "Role not exist");
        }
        // Validate organization relation
        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), role.getcOrgId())) {
            throw new AjaxException(404, "No permission to mod role");
        }

        // Get all available function ids for current role
        List<String> allFuncIdList = new ArrayList<String>();
        for (String rootFuncId : role.getRootFuncIds()) {
            allFuncIdList.addAll(funcServ.queryFuncIdListByRootId(rootFuncId));
        }

        // Collect submitted functions ids
        HashSet<String> funcIdList = new HashSet<String>();
        if (!funcIds.isEmpty()) {
            funcIdList.addAll(Arrays.asList(funcIds.split(",")));
        }

        // Work out exclude-function id and insert it
        roleServ.delExcFuncsByRoleId(id);
        for (String funcId : allFuncIdList) {
            if (!funcIdList.contains(funcId)) {
                if (!roleServ.addRoleExcFunc(id, funcId, user.getcLoginName())) {
                    throw new AjaxException(500, "Failed to authorize to current role");
                }
            }
        }

        return true;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-4")
    @RequestMapping(value = "user/query.do", method = RequestMethod.POST)
    public Object queryUser(String id) throws AjaxException {

        TUser user = userServ.getCachedUser();
        TUser targetUser = userServ.queryUserById(id);

        if (targetUser == null) {
            throw new AjaxException(501, "User not exist");
        }

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), targetUser.getcOrgId())) {
            throw new AjaxException(406, "No permission to query user under the organization");
        }

        return targetUser;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-4")
    @RequestMapping(value = "user/checkName.do", method = RequestMethod.POST)
    public Object checkLoginName(@NotEmpty String loginName) throws AjaxException {

        boolean exists = userServ.checkLoginNameExists(loginName);

        return exists;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-4-1")
    @RequestMapping(value = "user/add.do", method = RequestMethod.POST)
    @Transactional
    public Object addUser(@Validated({AjaxControllerAdd.class}) UserForm form) throws AjaxException {
        if (form.getRoles() != null) {
            form.setRoles(form.getRoles()
                    .replaceAll(" ", "")
                    .replaceAll(",,", ",")
                    .replaceAll(",$", "")
                    .replaceAll("^,", ""));
        }
        TUser user = userServ.getCachedUser();

        TOrg org = orgServ.queryOrgById(form.getOrgId());
        if (org == null) {
            throw new AjaxException(404, "Organization not exist");
        }

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), form.getOrgId())) {
            throw new AjaxException(405, "No permission to add user under the organization");
        }

        TUser newUser = this.userFormToTUser(form);
        newUser.setcOrgId(org.getcId());
        newUser.setcOrgRootId(org.getcRootId());

        String id = userServ.addUser(newUser, newUser.getcLoginName());
        if (id == null) {
            throw new AjaxException(500, "Failed to add user");
        }

        String[] roleIds = form.getRoles().split(",");
        if (roleIds.length > 1) {
            if (roleServ.systemRoleCoexistWithOtherRoles(roleIds)) {
                throw new AjaxException(405, "System role cannot coexist with other roles");
            }

            for (String roleId : roleIds) {
                if (roleServ.roleExists(roleId)) {
                    if (!userServ.addUserRole(id, roleId)) {
                        throw new AjaxException(500, "Failed to add user-role relation");
                    }
                }
            }
        }

        return id;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-4-2")
    @RequestMapping(value = "user/mod.do", method = RequestMethod.POST)
    @Transactional
    public Object modUser(@Validated({AjaxControllerMod.class}) UserForm form) throws AjaxException {

        TUser user = userServ.getCachedUser();
        TUser targetUser = userServ.queryUserById(form.getUserId());
        if (targetUser == null) {
            throw new AjaxException(404, "User not exist");
        }

        TOrg org = orgServ.queryOrgById(form.getOrgId());
        if (org == null) {
            throw new AjaxException(405, "Organization not exist");
        }

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), targetUser.getcOrgId())) {
            throw new AjaxException(406, "No permission to add user under the organization");
        }

        TUser modUser = this.userFormToTUser(form);
        modUser.setcOrgId(org.getcId());
        modUser.setcOrgRootId(org.getcRootId());
        modUser.setcLoginName(null);

        if (!userServ.modUserById(modUser)) {
            throw new AjaxException(500, "Failed to mod user");
        }

        String[] roleIds = form.getRoles().split(",");
        if (roleIds.length > 1) {
            userServ.delUserRolesByUserId(modUser.getcId());
            if (roleServ.systemRoleCoexistWithOtherRoles(roleIds)) {
                throw new AjaxException(405, "System role cannot coexist with other roles");
            }

            for (String roleId : roleIds) {
                if (roleServ.roleExists(roleId)) {
                    if (!userServ.addUserRole(modUser.getcId(), roleId)) {
                        throw new AjaxException(500, "Failed to add user-role relation");
                    }
                }
            }
        }

        return true;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-4-3")
    @RequestMapping(value = "user/del.do", method = RequestMethod.POST)
    @Transactional
    public Object delUser(@NotEmpty String id) throws AjaxException {


        TUser user = userServ.getCachedUser();
        TUser targetUser = userServ.queryUserById(id);

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), targetUser.getcOrgId())) {
            throw new AjaxException(406, "No permission to del user under parent organization");
        }

        userServ.delUserRolesByUserId(id);
        if (!userServ.delUserById(id)) {
            throw new AjaxException(501, "Failed to delete user");
        }

        return true;
    }

    @AjaxControllerLog
    @RequiresPermissions("7-4-4")
    @RequestMapping(value = "user/enable.do", method = RequestMethod.POST)
    public Object enableUser(@NotEmpty String id, @NotNull Boolean enabled) throws AjaxException {

        TUser user = userServ.getCachedUser();
        TUser targetUser = userServ.queryUserById(id);

        if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), targetUser.getcOrgId())) {
            throw new AjaxException(406, "No permission to del user under parent organization");
        }

        if (enabled) {
            if (!userServ.enableUserById(id)) {
                throw new AjaxException(501, "Failed to enable user");
            }
        } else {
            if (!userServ.disableUserById(id)) {
                throw new AjaxException(502, "Failed to disable user");
            }
        }

        return true;
    }


    public TUser userFormToTUser(UserForm form) {
        TUser user = new TUser();
        user.setcId(form.getUserId());
        user.setcLoginName(form.getLoginName());
        user.setcLoginPass(form.getLoginPass());
        user.setcNickName(form.getNickName());
        user.setcAvailable(true);
        user.setcOrgId(form.getOrgId());
        user.setcEmail(form.getEmail());
        user.setcPhone(form.getPhone());
        user.setcQq(form.getIm());
        user.setcRealName(form.getRealName());
        return user;
    }

    /* Not implement yet
    @RequestMapping(value = "func/add.do", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse addFunc(OrgForm form, HttpServletRequest request) {
        AjaxResponse res = new AjaxResponse(200);
        do {
        } while (false);

        return res;
    }

    @RequestMapping(value = "func/mod.do", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse modFunc(OrgForm form, HttpServletRequest request) {
        AjaxResponse res = new AjaxResponse(200);
        do {
        } while (false);

        return res;
    }

    @RequestMapping(value = "func/del.do", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse delFunc(String id, HttpServletRequest request) {
        AjaxResponse res = new AjaxResponse(200);
        do {
        } while (false);

        return res;
    }
    */
}
