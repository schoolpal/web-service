package com.schoolpal.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.user.db.ConfigDB;
import com.schoolpal.user.model.page.FuncRow;
import com.schoolpal.user.model.page.OrgRow;
import com.schoolpal.user.model.page.RoleRow;
import com.schoolpal.user.model.page.config.OrgForm;
import com.schoolpal.user.model.page.config.RoleForm;
import com.schoolpal.user.model.page.config.UserForm;
import com.schoolpal.user.model.page.config.UserPage;

@Service
public class ConfigService {

	@Autowired
	private ConfigDB configDB;

	public List<OrgRow> getAvailableOrgRows(String code) {
		List<OrgRow> orgRows = configDB.getOrgRows();
		List<OrgRow> results = new ArrayList<OrgRow>();

		for (OrgRow row : orgRows) {
			if (row.getCode().equals(code)) {
				row.setLevel(0);
				results.add(row);
				break;
			}
		}

		int ind = 0;
		while (ind < results.size()) {
			int offset = 0;
			OrgRow currRow = results.get(ind);

			for (OrgRow row : orgRows) {
				if (row.getParentId().equals(currRow.getId()) && !results.contains(row)) {
					row.setLevel(currRow.getLevel() + 1);
					results.add(ind + (++offset), row);
					currRow.setFather(true);
				}
			}

			if (ind < results.size()) {
				ind++;
			}
		}
		return results;
	}

	public List<OrgRow> getOrgHierarchy(String orgId) {
		List<OrgRow> hierarchy = new ArrayList<OrgRow>();
		List<OrgRow> allOrgRows = configDB.getOrgRows();

		OrgRow last = null;
		for (OrgRow row : allOrgRows) {
			if (row.getId().equals(orgId)) {
				hierarchy.add(row);
				last = row;
			}
		}

		while (!last.getId().equals(last.getRootId())) {
			for (OrgRow row : allOrgRows) {
				if (hierarchy.contains(row)) {
					continue;
				}

				if (row.getId().equals(last.getParentId())) {
					hierarchy.add(row);
					last = row;
				}
			}
		}

		return hierarchy;
	}

	public boolean addOrg(OrgForm form, String creator) {
		Map<String, String> parentIdMap = configDB.getOrgIdMapById(form.getParentId());
		return configDB.addOrg(form.getOrgCode(), form.getName(), "", form.getState(), form.getCity(), form.getCounty(),
				form.getAddress(), form.getOwner(), form.getPhone(), form.getParentId(), parentIdMap.get("parent_id"),
				parentIdMap.get("root_id"), creator);
	}

	public boolean updateOrg(OrgForm form, String modifier) {
		String orgRootId = configDB.getOrgRootId(form.getParentId());
		return configDB.updateOrg(form.getId(), form.getOrgCode(), form.getName(), "", form.getState(), form.getCity(),
				form.getCounty(), form.getAddress(), form.getOwner(), form.getPhone(), form.getParentId(), orgRootId,
				modifier);
	}

	public String getOrgId(String code) {
		return configDB.getOrgIdByCode(code);
	}

	public boolean disableOrg(String id, String modifier) {
		String code = configDB.getOrgCodeById(id);
		List<OrgRow> orgRows = getAvailableOrgRows(code);
		List<String> orgIds = new ArrayList<String>();
		for (OrgRow org : orgRows) {
			orgIds.add(org.getId());
		}

		return configDB.disableOrgs(orgIds, modifier);
	}

	public OrgForm getOrgInfo(String id) {
		return configDB.getOrgById(id);
	}

	public boolean addRole(String orgId, String creatorId, String name, String desc, int rankId, int[] functionIds) {
		return configDB.addRole(orgId, creatorId, name, desc, rankId, functionIds);
	}

	public List<RoleRow> roleRows(String orgId) {
		return configDB.getRoleRows(orgId);
	}

	public boolean removeRole(String roleId) {
		return configDB.removeRole(roleId);
	}

	public RoleForm getRoleInfo(String roleId) {
		RoleForm form = new RoleForm();
		Map<String, String> roleMap = configDB.getRoleMapById(roleId);
		form.setId(roleId);
		form.setName(roleMap.get("name"));
		form.setDesc(roleMap.get("desc"));
		form.setRankId(Integer.parseInt(roleMap.get("rank_id")));

		List<String> funcIds = configDB.getRoleFunctionIds(roleId);
		String strFuncIds = "";
		for (String funcId : funcIds) {
			strFuncIds += funcId + ",";
		}
		form.setStrFuncIds(strFuncIds.substring(0, strFuncIds.length() - 1));
		return form;
	}

	public boolean updateRole(String roleId, String name, String desc, int rankId, int[] functionIds) {
		configDB.removeRoleFunctions(roleId);
		return configDB.updateRole(roleId, name, desc, rankId, functionIds);
	}

	public List<FuncRow> getFuncHierarchy(String roleId) {
		List<FuncRow> hierarchy = new ArrayList<FuncRow>();

		List<String> excludedFuncIds = configDB.getRoleExcludedFunctionIds(roleId);
		List<String> funcIds = configDB.getRoleFunctionIds(roleId);
		for (String funcId : funcIds) {
			List<FuncRow> funcRows = configDB.getFuncRows(funcId);

			for (FuncRow funcRow : funcRows) {
				if (funcRow.getId().equals(funcRow.getParentId())) {
					funcRow.setExcluded(excludedFuncIds.contains(funcRow.getId()));
					hierarchy.add(funcRow);
					break;
				}
			}

			int ind = 0;
			while (ind < hierarchy.size()) {
				FuncRow curr = hierarchy.get(ind);
				funcRows.remove(curr);

				for (FuncRow row : funcRows) {
					if (row.getParentId().equals(curr.getId())) {
						row.setExcluded(curr.isExcluded() || excludedFuncIds.contains(row.getId()));
						row.setLevel(curr.getLevel() + 1);
						hierarchy.add(row);
					}
				}
				ind++;
			}
		}

		return hierarchy;
	}

	public void updateExcludedFunctions(String creatorId, String roleId, String[] excludedFuncIds) {
		configDB.clearRoleExcludedFunctionIds(roleId);
		if (excludedFuncIds.length > 0) {
			configDB.addRoleExcludedFunctionIds(creatorId, roleId, excludedFuncIds);
		}
	}

	public List<UserPage> getUsers(String orgId) {
		List<UserPage> users = configDB.getUsers(orgId);
		for (UserPage user : users) {
			List<String> roles = configDB.getUserRoles(user.getId());
			String roleString = "";
			for (String role : roles) {
				roleString += role + ", ";
			}

			if (roleString.length() > 0) {
				user.setRoles(roleString.substring(0, roleString.length() - 2));
			}
		}
		return users;
	}

	public void userEnable(String userId) {
		configDB.userEnable(userId);
	}

	public void userDisable(String userId) {
		configDB.userDisable(userId);
	}

	public void userRemove(String userId) {
		configDB.userRemove(userId);
	}

	public void addUser(String creatorId, UserForm form) {
		String rootOrgId = configDB.getOrgRootId(form.getOrgId());
		String userId = configDB.addUser(form.getLoginName(), form.getLoginPass(), form.getRealName(), form.getNickName(), form.getPhone(),
				form.getEmail(), form.getIm(), form.getOrgId(), rootOrgId, creatorId);

		configDB.addUserRole(creatorId, userId, form.getOrgId(), form.getRoles().split(","));
	}

	public UserForm getUserForm(String userId) {
		UserForm form = configDB.getUserForm(userId);
		List<String> roleIds = configDB.getUserRoleIds(userId);
		String strRoleId = "";
		for (String id : roleIds) {
			strRoleId += id + ",";
		}
		if (strRoleId.length() > 0) {
			form.setRoles(strRoleId.substring(0, strRoleId.length() - 1));
		}

		return form;
	}

	public void modUser(String creatorId, UserForm form) {
		configDB.modUser(form.getUserId(), form.getLoginName(), form.getLoginPass(), form.getRealName(), form.getNickName(),
				form.getPhone(), form.getEmail(), form.getIm(), creatorId);

		configDB.clearUserRole(form.getUserId(), form.getOrgId());
		configDB.addUserRole(creatorId, form.getUserId(), form.getOrgId(), form.getRoles().split(","));
	}

}
