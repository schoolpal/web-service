package com.schoolpal.web.controller.ajax.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.schoolpal.web.controller.ajax.helper.AuthorizationHelper;
import com.schoolpal.web.controller.ajax.model.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import com.google.gson.Gson;
import com.schoolpal.db.model.*;
import com.schoolpal.service.*;
import com.schoolpal.web.model.*;

@Controller
@RequestMapping("/ajax/sys/")
public class AjaxSystemController {

	// @Autowired
	// private LogService logServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private OrgService orgServ;
	@Autowired
	private RoleService roleServ;
	@Autowired
	private FunctionService funcServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "org/list.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse listOrgs() {
		
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("7-1")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			List<TOrg> orgList = orgServ.queryOrgListByRootId(user.getcOrgId());
			res.setData(orgList);

		} while (false);

		return res;
	}

	@RequestMapping(value = "org/add.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse addOrg(OrgForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (form == null) {
				res.setCode(401);
				res.setDetail("Form data cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			TOrg org = orgServ.queryOrgByCode(form.getCode());
			if (org != null) {
				res.setCode(402);
				res.setDetail("Duplicated orgnization code");
				break;
			}

			TOrg parentOrg = orgServ.queryOrgById(form.getParentId());
			if (parentOrg == null) {
				res.setCode(403);
				res.setDetail("Parent orgnization not exist");
				break;
			}

			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), form.getParentId())) {
				res.setCode(404);
				res.setDetail("No permission to add orgnization under parent orgnization");
			}

			String id = orgServ.addOrg(form, parentOrg.getcRootId(), user.getcLoginname());
			if (id == null) {
				res.setCode(500);
				res.setDetail("Failed to add orgnization");
				break;
			}

			res.setData(id);

		} while (false);

		return res;
	}

	@RequestMapping(value = "org/mod.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse modOrg(OrgForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (form == null || form.getId() == null || form.getId().isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			if (form.getParentId() == null || form.getParentId().isEmpty()) {
				res.setCode(402);
				res.setDetail("Parent id cannot be empty");
				break;
			}

			TOrg org = orgServ.queryOrgByCodeWithExclusion(form.getCode(), form.getId());
			if (org != null) {
				res.setCode(403);
				res.setDetail("Duplicated orgnization code");
				break;
			}

			TOrg parentOrg = orgServ.queryOrgById(form.getParentId());
			if (parentOrg == null) {
				res.setCode(404);
				res.setDetail("Parent orgnization not exist");
				break;
			}

			if (form.getId() != parentOrg.getcRootId() && form.getParentId() == form.getId()) {
				res.setCode(403);
				res.setDetail("Parent orgnization cannot be self");
				break;
			}

			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), form.getParentId())) {
				res.setCode(405);
				res.setDetail("No permission to move orgnization to this parent orgnization");
				break;
			}

			if (!orgServ.modOrgById(form)) {
				res.setCode(500);
				res.setDetail("Failed to add orgnization");
				break;
			}

		} while (false);

		return res;
	}

	@RequestMapping(value = "org/del.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse delOrg(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			if (id == user.getcOrgId()) {
				res.setCode(402);
				res.setDetail("No permission to del self-orgnization");
				break;
			}
			
			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), id)) {
				res.setCode(403);
				res.setDetail("No permission to del parent orgnization");
				break;
			}

			if (!orgServ.delOrgById(id)) {
				res.setCode(500);
				res.setDetail("Failed to del orgnization");
				break;
			}

		} while (false);

		return res;
	}

	@RequestMapping(value = "role/list.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse listRoles(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();

			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionById("7-2")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), id)) {
				res.setCode(402);
				res.setDetail("No permission to query orgnization");
				break;
			}

			List<TRole> roles = null;
			try {
				roles = roleServ.queryRoleListByOrgId(id);
				if (roles == null) {
					res.setCode(403);
					res.setDetail("Cannot find orgnization");
					break;
				}
			} catch (Exception e) {
				res.setCode(500);
				res.setDetail("Unexpect error");
				break;
			}

			res.setData(roles);

		} while (false);

		return res;
	}

	@RequestMapping(value = "role/add.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse addRole(RoleForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (form == null) {
				res.setCode(401);
				res.setDetail("Form data cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			TOrg org = orgServ.queryOrgById(form.getOrgId());
			if (org == null) {
				res.setCode(402);
				res.setDetail("Parent orgnization not exist");
				break;
			}

			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), form.getOrgId())) {
				res.setCode(403);
				res.setDetail("No permission to add role under parent orgnization");
			}

			String id = roleServ.addRole(form, user.getcLoginname());
			if (id == null) {
				res.setCode(501);
				res.setDetail("Failed to add role");
				break;
			}

			if (form.getStrFuncIds() != null) {
				form.setStrFuncIds(form.getStrFuncIds().replaceAll(" ",  "").replaceAll(",,", ",").replaceAll(",$", "").replaceAll("^,", ""));
				if (!form.getStrFuncIds().isEmpty()){
					String[] funcIds = form.getStrFuncIds().split(",");
					if (funcIds.length > 0) {
						if (!roleServ.addRoleRootFuncs(id, funcIds)) {
							res.setCode(502);
							res.setDetail("Failed to add role functions");
							break;
						}
					}
				}
			}
			res.setData(id);

		} while (false);

		return res;
	}

	@RequestMapping(value = "role/mod.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse modRole(RoleForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (form == null || form.getId() == null || form.getId().isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			if (form.getId() == null || form.getId().isEmpty()) {
				res.setCode(402);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (form.getOrgId() == null || form.getOrgId().isEmpty()) {
				res.setCode(403);
				res.setDetail("Parent orgnization cannot be empty");
				break;
			}

			TOrg org = orgServ.queryOrgById(form.getOrgId());
			if (org == null) {
				res.setCode(404);
				res.setDetail("Parent orgnization not exist");
				break;
			}

			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), form.getOrgId())) {
				res.setCode(405);
				res.setDetail("No permission to move orgnization to this parent orgnization");
				break;
			}

			if (!roleServ.modRoleById(form)) {
				res.setCode(500);
				res.setDetail("Failed to mod orgnization");
				break;
			}

			roleServ.delRootFuncsByRoleId(form.getId());
			if (form.getStrFuncIds() != null) {
				form.setStrFuncIds(form.getStrFuncIds().replaceAll(" ",  "").replaceAll(",,", ",").replaceAll(",$", "").replaceAll("^,", ""));
				if (!form.getStrFuncIds().isEmpty()){
					String[] funcIds = form.getStrFuncIds().split(",");
					if (funcIds.length > 0) {
						if (!roleServ.addRoleRootFuncs(form.getId(), funcIds)) {
							res.setCode(502);
							res.setDetail("Failed to add role functions");
							break;
						}
					}
				}
			}

		} while (false);

		return res;
	}

	@RequestMapping(value = "role/del.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse delRole(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			TRole role = null;
			try {
				role = roleServ.queryRoleById(id);
			} catch (Exception e) {
				res.setCode(502);
				res.setDetail("Unexpect error");
				break;
			}
			if (role == null) {
				res.setCode(402);
				res.setDetail("Cannot find role");
				break;
			}
			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), role.getcOrgId())) {
				res.setCode(403);
				res.setDetail("No permission to del role under parent orgnization");
			}

			roleServ.delExcFuncsByRoleId(id);
			roleServ.delRootFuncsByRoleId(id);
			if (!roleServ.delRoleById(id)) {
				res.setCode(500);
				res.setDetail("Failed to del orgnization");
				break;
			}

		} while (false);

		return res;
	}

	@RequestMapping(value = "role/auth.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse addRoleFunc(String id, String funcIds, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			// Validate param
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}
			if (funcIds == null) {
				res.setCode(402);
				res.setDetail("Func ids cannot be empty");
				break;
			}
			funcIds = funcIds.replaceAll(" ",  "").replaceAll(",,", ",").replaceAll(",$", "").replaceAll("^,", "");
			if (funcIds.isEmpty()) {
				res.setCode(402);
				res.setDetail("Func ids cannot be empty");
				break;
			}

			// Validate permission
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();

			// Validate role
			TRole role = roleServ.queryRoleById(id);
			if (role == null) {
				res.setCode(403);
				res.setDetail("Role not exist");
				break;
			}
			// Validate organization relation
			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), role.getcOrgId())) {
				res.setCode(404);
				res.setDetail("No permission to access parent orgnization");
				break;
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
					if (!roleServ.addRoleExcFunc(id, funcId, user.getcLoginname())) {
						res.setCode(405);
						res.setDetail("Failed to authorize to current role");
						break;
					}
				}
			}

		} while (false);

		return res;
	}
	
	@RequestMapping(value = "user/checkName.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse checkLoginname(String loginName, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (loginName == null || loginName.isEmpty()) {
				res.setCode(401);
				res.setDetail("name cannot be empty");
				break;
			}
			if (!AuthorizationHelper.CheckPermissionById("7-4")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			boolean exists = userServ.checkLoginnameExists(loginName);
			res.setData(exists);
		} while (false);

		return res;
	}
	
	@RequestMapping(value = "user/add.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse addUser(UserForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (form == null) {
				res.setCode(401);
				res.setDetail("Form data cannot be empty");
				break;
			}
			if (form.getOrgId() == null || form.getOrgId().isEmpty()) {
				res.setCode(402);
				res.setDetail("Org id cannot be empty");
				break;
			}
			form.setRoles(form.getRoles().replaceAll(" ",  "").replaceAll(",,", ",").replaceAll(",$", "").replaceAll("^,", ""));
			if (form.getRoles() == null && form.getRoles().isEmpty()) {
				res.setCode(403);
				res.setDetail("Role ids cannot be empty");
				break;
			}
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			String[] roleIds = form.getRoles().split(",");
			if (roleIds.length > 1 && roleServ.systemRoleCoexistWithOtherRoles(roleIds)) {
				res.setCode(405);
				res.setDetail("System role cannot coexist with other roles");
				break;
			}			

			TUser user = userServ.getCachedUser();

			TOrg org = orgServ.queryOrgById(form.getOrgId());
			if (org == null) {
				res.setCode(404);
				res.setDetail("Parent orgnization not exist");
				break;
			}

			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), form.getOrgId())) {
				res.setCode(405);
				res.setDetail("No permission to add user under parent orgnization");
				break;
			}

			TUser newUser = this.userFormToTUser(form);
			newUser.setcOrgId(org.getcId());
			newUser.setcOrgRootId(org.getcRootId());

			String id = userServ.addUser(newUser, newUser.getcLoginname());
			if (id == null) {
				res.setCode(501);
				res.setDetail("Failed to add user");
				break;
			}

			for (String roleId : roleIds) {
				if (roleServ.roleExists(roleId)) {
					// Add user/role relation
					if (!userServ.addUserRole(id, roleId)) {
						res.setCode(502);
						res.setDetail("Failed to add user-role relation");
						break;
					}
				}
			}

			res.setData(id);
		} while (false);

		return res;
	}

	@RequestMapping(value = "user/mod.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse modUser(UserForm form, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (form == null) {
				res.setCode(401);
				res.setDetail("Form data cannot be empty");
				break;
			}
			if (form.getUserId() == null || form.getUserId().isEmpty()) {
				res.setCode(402);
				res.setDetail("User id cannot be empty");
				break;
			}
			if (form.getOrgId() == null || form.getOrgId().isEmpty()) {
				res.setCode(403);
				res.setDetail("Org id cannot be empty");
				break;
			}
			form.setRoles(form.getRoles().replaceAll(" ",  "").replaceAll(",,", ",").replaceAll(",$", "").replaceAll("^,", ""));
			if (form.getRoles() == null && form.getRoles().isEmpty()) {
				res.setCode(404);
				res.setDetail("System role cannot coexist with other roles");
				break;
			}			
			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			String[] roleIds = form.getRoles().split(",");
			if (roleIds.length > 1 && roleServ.systemRoleCoexistWithOtherRoles(roleIds)) {
				res.setCode(405);
				res.setDetail("Role ids cannot be empty");
				break;
			}			

			TUser user = userServ.getCachedUser();

			TOrg org = orgServ.queryOrgById(form.getOrgId());
			if (org == null) {
				res.setCode(405);
				res.setDetail("Parent orgnization not exist");
				break;
			}

			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), form.getOrgId())) {
				res.setCode(406);
				res.setDetail("No permission to add user under parent orgnization");
				break;
			}
				
			TUser newUser = this.userFormToTUser(form);
			newUser.setcOrgId(org.getcId());
			newUser.setcOrgRootId(org.getcRootId());
			//user loginname cannot be modified
			newUser.setcLoginname(null);
			
			if (!userServ.modUserById(newUser)) {
				res.setCode(501);
				res.setDetail("Failed to add role");
				break;
			}

			userServ.delUserRolesByUserId(newUser.getcId());
			for (String roleId : roleIds) {
				if (roleServ.roleExists(roleId)) {
					// Add user/role relation
					if (!userServ.addUserRole(form.getUserId(), roleId)) {
						res.setCode(502);
						res.setDetail("Failed to add user-role relation");
						break;
					}
				}
			}

		} while (false);

		return res;
	}

	@RequestMapping(value = "user/del.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse delUser(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}


			TUser user = userServ.getCachedUser();
			TUser targetUser = userServ.queryUserById(id);

			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), targetUser.getcOrgId())) {
				res.setCode(406);
				res.setDetail("No permission to del user under parent orgnization");
				break;
			}

			userServ.delUserRolesByUserId(id);
			if (!userServ.delUserById(id)) {
				res.setCode(501);
				res.setDetail("Failed to delete user");
				break;
			}

		} while (false);

		return res;
	}

	@RequestMapping(value = "user/enable.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse enableUser(String id, boolean enabled, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionByMappedPath(
					(String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE))) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();
			TUser targetUser = userServ.queryUserById(id);

			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), targetUser.getcOrgId())) {
				res.setCode(406);
				res.setDetail("No permission to access user under parent orgnization");
				break;
			}
			
			if (enabled){
				if (!userServ.enableUserById(id)) {
					res.setCode(501);
					res.setDetail("Failed to enable user");
					break;
				}
			}else{
				if (!userServ.disableUserById(id)) {
					res.setCode(501);
					res.setDetail("Failed to disable user");
					break;
				}
			}

		} while (false);

		return res;
	}

	@RequestMapping(value = "user/query.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse queryUser(String id, HttpServletRequest request) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (id == null || id.isEmpty()) {
				res.setCode(401);
				res.setDetail("Id cannot be empty");
				break;
			}

			if (!AuthorizationHelper.CheckPermissionById("7-4")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}

			TUser user = userServ.getCachedUser();
			TUser targetUser = userServ.queryUserById(id);

			if (targetUser == null) {
				res.setCode(501);
				res.setDetail("Failed to find user");
				break;
			}

			if (!orgServ.isOrgBelongToTargetOrg(user.getcOrgId(), targetUser.getcOrgId())) {
				res.setCode(406);
				res.setDetail("No permission to access user under parent orgnization");
				break;
			}

			res.setData(targetUser);
		} while (false);

		return res;
	}

	public TUser userFormToTUser(UserForm form){
		TUser user = new TUser();
		user.setcId(form.getUserId());
		user.setcLoginname(form.getLoginName());
		user.setcLoginpass(form.getLoginPass());
		user.setcNickname(form.getNickName());
		user.setcAvailable(true);
		user.setcOrgId(form.getOrgId());
		user.setcEmail(form.getEmail());
		user.setcPhone(form.getPhone());
		user.setcQq(form.getIm());
		user.setcRealname(form.getRealName());
		return user;
	}
	
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
}
