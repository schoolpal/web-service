package com.schoolpal.web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.schoolpal.web.model.page.config.OrgForm;
import com.schoolpal.web.model.page.config.UserForm;
import com.schoolpal.web.model.page.config.UserPage;
import com.schoolpal.web.model.page.FuncRow;
import com.schoolpal.web.model.page.OrgRow;
import com.schoolpal.web.model.page.RoleRow;

@Repository
public class ConfigDB {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getOrgCodeById(String id) {
		String sql = " select c_code from t_org where c_id = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, String.class);
	}

	public boolean disableOrgs(List<String> orgIds, String modifier) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("modifier", modifier);
		parameters.addValue("ids", orgIds);

		String sql = " update t_org set c_available = 0, c_modifier = :modifier, c_modify_time = now() where c_id in (:ids) ";
		int count = namedParameterJdbcTemplate.update(sql, parameters);
		return count > 0;
	}

	public List<OrgRow> getOrgRows() {
		final List<OrgRow> orgRows = new ArrayList<OrgRow>();
		String sql = " select c_code, c_id, c_parent_id, c_root_id, c_name, c_state, c_city, c_county, c_address, c_owner, c_owner_phone "
				+ " from t_org where c_available = 1 order by c_id asc ";
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				OrgRow orgRow = new OrgRow();
				orgRow.setCode(rets.getString("c_code"));
				orgRow.setId(rets.getString("c_id"));
				orgRow.setParentId(rets.getString("c_parent_id"));
				orgRow.setName(rets.getString("c_name"));
				orgRow.setArea(String.format("%s/%s/%s", rets.getString("c_state"), rets.getString("c_city"),
						rets.getString("c_county")));
				orgRow.setAddress(rets.getString("c_address"));
				orgRow.setOwner(rets.getString("c_owner"));
				orgRow.setPhone(rets.getString("c_owner_phone"));
				orgRow.setRootId(rets.getString("c_root_id"));
				orgRows.add(orgRow);
			}
		});
		return orgRows;
	}

	public Map<String, String> getOrgIdMapById(String id) {
		final Map<String, String> orgIdMap = new HashMap<String, String>();
		String sql = " select c_parent_id, c_root_id from t_org where c_id = ? ";
		jdbcTemplate.query(sql, new Object[] { id }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				orgIdMap.put("parent_id", rets.getString("c_parent_id"));
				orgIdMap.put("root_id", rets.getString("c_root_id"));
			}
		});
		return orgIdMap;
	}

	public String getOrgRootId(String id) {
		String sql = " select c_root_id from t_org where c_id = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, String.class);
	}

	public String getOrgIdByCode(String code) {
		String sql = " select count(*) from t_org where c_code = ? ";
		if (jdbcTemplate.queryForObject(sql, new Object[] { code }, int.class) > 0) {
			sql = " select c_id from t_org where c_code = ? ";
			return jdbcTemplate.queryForObject(sql, new Object[] { code }, String.class);
		} else {
			return "";
		}
	}

	public OrgForm getOrgById(String id) {
		final OrgForm form = new OrgForm();
		String sql = " select org.c_name, org.c_code, parent_org.c_id parent_id, parent_org.c_name parent_name, "
				+ " org.c_state, org.c_city, org.c_county, org.c_address, org.c_owner, org.c_owner_phone "
				+ " from t_org org left join t_org parent_org on parent_org.c_id = org.c_parent_id "
				+ " where org.c_id = ? ";
		jdbcTemplate.query(sql, new Object[] { id }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				form.setName(rets.getString("c_name"));
				form.setOrgCode(rets.getString("c_code"));
				form.setParentId(rets.getString("parent_id"));
				form.setParentName(rets.getString("parent_name"));
				form.setState(rets.getString("c_state"));
				form.setCity(rets.getString("c_city"));
				form.setCounty(rets.getString("c_county"));
				form.setAddress(rets.getString("c_address"));
				form.setOwner(rets.getString("c_owner"));
				form.setPhone(rets.getString("c_owner_phone"));
			}
		});
		return form;
	}

	public boolean addOrg(String code, String name, String nameAbbr, String state, String city, String county,
			String address, String owner, String ownerPhone, String parentId, String grandpaId, String rootId,
			String creator) {

		int count = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String sql = " insert into t_org(c_id, c_code, c_name, c_name_abbr, "
						+ " c_state, c_city, c_county, c_address, c_owner, c_owner_phone, c_parent_id, c_root_id, "
						+ " c_creator, c_create_time, c_modifier, c_modify_time, c_available, c_order_num) values( "
						+ " f_next_id('t_org'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), null, null, 1, 1) ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, code);
				ps.setString(2, name);
				ps.setString(3, nameAbbr);
				ps.setString(4, state);
				ps.setString(5, city);
				ps.setString(6, county);
				ps.setString(7, address);
				ps.setString(8, owner);
				ps.setString(9, ownerPhone);
				ps.setString(10, parentId);
				ps.setString(11, rootId);
				ps.setString(12, creator);
				return ps;
			}
		});

		if (count == 1 && grandpaId.equals(rootId)) {
			String sql = " update t_org set c_root_id = c_id where c_code = ? ";
			count = jdbcTemplate.update(sql, new Object[] { code });
		}

		return count == 1;
	}

	public boolean updateOrg(String id, String code, String name, String nameAbbr, String state, String city,
			String county, String address, String owner, String ownerPhone, String parentId, String rootId,
			String modifier) {

		String sql = " update t_org set c_code = ?, c_name = ?, c_name_abbr = ?, c_state = ?, c_city = ?, "
				+ " c_county = ?, c_address = ?, c_owner = ?, c_owner_phone = ?, c_parent_id = ?, c_root_id = ?, c_modifier = ?, c_modify_time = now() where c_id = ? ";
		int count = jdbcTemplate.update(sql, new Object[] { code, name, nameAbbr, state, city, county, address, owner,
				ownerPhone, parentId, rootId, modifier, id });
		return count == 1;
	}

	public boolean addRole(String orgId, String creatorId, String name, String desc, int rankId, int[] functionIds) {
		String id = jdbcTemplate.queryForObject(" select f_next_id('t_role') ", String.class);
		int count = jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String sql = " insert into t_role(c_id, c_create_time, c_org_id, c_creator, c_name, c_desc, c_rank_id, c_available, c_order_num) "
						+ " values(?, now(), ?, ?, ?, ?, ?, 1, 1) ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, orgId);
				ps.setString(3, creatorId);
				ps.setString(4, name);
				ps.setString(5, desc);
				ps.setInt(6, rankId);
				return ps;
			}
		});

		for (int functionId : functionIds) {
			jdbcTemplate.update(
					" insert into t_role_function(c_role_id, c_function_root_id, c_order_num) values(?, ?, 1) ",
					new Object[] { id, functionId });
		}
		return count == 1;
	}

	public List<RoleRow> getRoleRows(String orgId) {
		final List<RoleRow> roleRows = new ArrayList<RoleRow>();
		String sql = " select role.c_id, role.c_name, role.c_desc, rank.c_name rankName, rank.c_id rankId "
				+ " from t_role role left join t_rank rank on rank.c_id = role.c_rank_id where role.c_org_id = ? order by rank.c_order_num ";
		jdbcTemplate.query(sql, new Object[] { orgId }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				RoleRow roleRow = new RoleRow();
				roleRow.setId(rets.getString("c_id"));
				roleRow.setName(rets.getString("c_name"));
				roleRow.setDesc(rets.getString("c_desc"));
				roleRow.setRankName(rets.getString("rankName"));
				roleRow.setRankId(rets.getInt("rankId"));
				roleRows.add(roleRow);
			}
		});

		for (RoleRow row : roleRows) {
			final List<String> funcNames = new ArrayList<String>();
			sql = " select f.c_name_short from t_role_function rf left join t_function f on f.c_id = rf.c_function_root_id where rf.c_role_id = ? ";
			jdbcTemplate.query(sql, new Object[] { row.getId() }, new RowCallbackHandler() {
				@Override
				public void processRow(ResultSet rets) throws SQLException {
					funcNames.add(rets.getString("c_name_short"));
				}
			});
			row.setFuncNames(funcNames);
		}
		return roleRows;
	}

	public boolean removeRole(String roleId) {
		jdbcTemplate.update(" delete from t_role_function where c_role_id = ? ", new Object[] { roleId });
		int count = jdbcTemplate.update(" delete from t_role where c_id = ? ", new Object[] { roleId });
		return count == 1;
	}

	public Map<String, String> getRoleMapById(String id) {
		final Map<String, String> roleMap = new HashMap<String, String>();
		String sql = " select c_name, c_desc, c_rank_id from t_role where c_id = ? ";
		jdbcTemplate.query(sql, new Object[] { id }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				roleMap.put("name", rets.getString("c_name"));
				roleMap.put("desc", rets.getString("c_desc"));
				roleMap.put("rank_id", Integer.toString(rets.getInt("c_rank_id")));
			}
		});
		return roleMap;
	}

	public List<String> getRoleFunctionIds(String roleId) {
		final List<String> funcIds = new ArrayList<String>();
		String sql = " select c_function_root_id from t_role_function where c_role_id = ? ";
		jdbcTemplate.query(sql, new Object[] { roleId }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				funcIds.add(rets.getString("c_function_root_id"));
			}
		});
		return funcIds;
	}

	public boolean updateRole(String roleId, String name, String desc, int rankId, int[] functionIds) {
		String sql = " update t_role set c_name = ?, c_desc = ?, c_rank_id = ? where c_id = ? ";
		int count = jdbcTemplate.update(sql, new Object[] { name, desc, rankId, roleId });

		if (count == 1) {
			for (int functionId : functionIds) {
				jdbcTemplate.update(
						" insert into t_role_function(c_role_id, c_function_root_id, c_order_num) values(?, ?, 1) ",
						new Object[] { roleId, functionId });
			}
		}
		return count == 1;
	}

	public void removeRoleFunctions(String roleId) {
		jdbcTemplate.update(" delete from t_role_function where c_role_id = ? ", new Object[] { roleId });
	}

	public List<FuncRow> getFuncRows(String funcId) {
		List<FuncRow> funcRows = new ArrayList<FuncRow>();

		String sql = " select c_id, c_parent_id, c_name_long, c_widget_type_id from t_function where c_root_id = ? ";
		jdbcTemplate.query(sql, new Object[] { funcId }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				FuncRow row = new FuncRow();
				row.setId(rets.getString("c_id"));
				row.setName(rets.getString("c_name_long"));
				row.setParentId(rets.getString("c_parent_id"));
				row.setType(rets.getInt("c_widget_type_id"));
				row.setLevel(0);

				funcRows.add(row);
			}
		});
		return funcRows;
	}

	public List<String> getRoleExcludedFunctionIds(String roleId) {
		final List<String> funcIds = new ArrayList<String>();
		String sql = " select c_function_id from t_role_function_exclude where c_role_id = ? ";
		jdbcTemplate.query(sql, new Object[] { roleId }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				funcIds.add(rets.getString("c_function_id"));
			}
		});
		return funcIds;
	}

	public void clearRoleExcludedFunctionIds(String roleId) {
		jdbcTemplate.update(" delete from t_role_function_exclude where c_role_id = ? ", new Object[] { roleId });
	}

	public void addRoleExcludedFunctionIds(String creatorId, String roleId, String[] funcIds) {
		for (String funcId : funcIds) {
			if (funcId.length() > 0) {
				jdbcTemplate.update(
						" insert into t_role_function_exclude(c_role_id, c_function_id, c_creator, c_create_time) values(?, ?, ?, now()) ",
						new Object[] { roleId, funcId, creatorId });
			}
		}
	}

	public List<String> getUserRoles(String userId) {
		final List<String> roles = new ArrayList<String>();
		String sql = " select r.c_name from t_user_role ur left join t_role r on r.c_id = ur.c_role_id where ur.c_user_id = ? ";
		jdbcTemplate.query(sql, new Object[] { userId }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				roles.add(rets.getString("c_name"));
			}
		});
		return roles;
	}

	public List<String> getUserRoleIds(String userId) {
		final List<String> roleIds = new ArrayList<String>();
		String sql = " select r.c_id from t_user_role ur left join t_role r on r.c_id = ur.c_role_id where ur.c_user_id = ? ";
		jdbcTemplate.query(sql, new Object[] { userId }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				roleIds.add(rets.getString("c_id"));
			}
		});
		return roleIds;
	}

	public List<UserPage> getUsers(String orgId) {
		final List<UserPage> users = new ArrayList<UserPage>();
		String sql = " select c_id, c_loginname, c_available, c_realname, c_nickname, c_phone, c_email, c_qq from t_user where c_org_id = ? ";
		jdbcTemplate.query(sql, new Object[] { orgId }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				UserPage user = new UserPage();
				user.setId(rets.getString("c_id"));
				user.setLoginName(rets.getString("c_loginname"));
				user.setState(rets.getBoolean("c_available") ? "启用" : "停用");
				user.setRealName(rets.getString("c_realname"));
				user.setNickName(rets.getString("c_nickname"));
				user.setMobile(rets.getString("c_phone"));
				user.setEmail(rets.getString("c_email"));
				user.setIm(rets.getString("c_qq"));
				user.setAvailable(rets.getBoolean("c_available"));

				users.add(user);
			}
		});
		return users;
	}

	public void userEnable(String userId) {
		jdbcTemplate.update(" update t_user set c_available = 1 where c_id = ? ", new Object[] { userId });
	}

	public void userDisable(String userId) {
		jdbcTemplate.update(" update t_user set c_available = 0 where c_id = ? ", new Object[] { userId });
	}

	public void userRemove(String userId) {
		jdbcTemplate.update(" delete from t_user where c_id = ? ", new Object[] { userId });
	}

	public String addUser(String loginName, String loginPass, String realName, String nickName, String phone, String email, String qq,
			String orgId, String rootOrgId, String creatorId) {
		String userId = jdbcTemplate.queryForObject(" select f_next_id('t_user') ", String.class);

		jdbcTemplate.update(
				" insert into t_user(c_id, c_loginname, c_loginpass, c_realname, c_nickname, c_phone, c_email, c_qq, c_available, "
						+ " c_org_id, c_org_root_id, c_creator, c_create_time, c_last_visit_time, c_last_visit_ip) "
						+ " values(?, ?, ?, ?, ?, ?, ?, ?, 1, ?, ?, ?, now(), null, null)",
				new Object[] { userId, loginName, loginPass, realName, nickName, phone, email, qq, orgId, rootOrgId, creatorId });

		return userId;
	}

	public void addUserRole(String creatorId, String userId, String orgId, String[] roleIds) {
		for (String roleId : roleIds) {
			jdbcTemplate.update(
					"insert into t_user_role(c_id, c_org_id, c_user_id, c_role_id, c_available, c_creator, c_create_time)"
							+ " values(f_next_id('t_user_role'), ?, ?, ?, 1, ?, now())",
					new Object[] { orgId, userId, roleId, creatorId });
		}
	}

	public void clearUserRole(String userId, String orgId) {
		jdbcTemplate.update("delete from t_user_role where c_user_id = ? and c_org_id = ?",
				new Object[] { userId, orgId });
	}

	public UserForm getUserForm(String userId) {
		final UserForm form = new UserForm();
		String sql = " select c_org_id, c_loginname, c_realname, c_nickname, c_phone, c_email, c_qq from t_user where c_id = ? ";
		jdbcTemplate.query(sql, new Object[] { userId }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				form.setOrgId(rets.getString("c_org_id"));
				form.setLoginName(rets.getString("c_loginname"));
				form.setRealName(rets.getString("c_realname"));
				form.setNickName(rets.getString("c_nickname"));
				form.setPhone(rets.getString("c_phone"));
				form.setEmail(rets.getString("c_email"));
				form.setIm(rets.getString("c_qq"));
			}
		});
		return form;
	}

	public void modUser(String userId, String loginName, String loginPass, String realName, String nickName, String phone, String email,
			String qq, String creatorId) {
		String sql = " update t_user set c_loginname = ?, c_realname = ?, c_nickname = ?, c_phone = ?, c_email = ?, c_qq = ?, c_creator = ?, c_create_time = now() ";
		if (!loginPass.equals("")) {
			sql += ", c_loginpass = ? ";
		}
		sql += " where c_id = ? ";

		if (!loginPass.equals("")) {
			jdbcTemplate.update(sql,
					new Object[] { loginName, realName, nickName, phone, email, qq, creatorId, loginPass, userId });
		} else {
			jdbcTemplate.update(sql, new Object[] { loginName, realName, nickName, phone, email, qq, creatorId, userId });
		}
	}

}
