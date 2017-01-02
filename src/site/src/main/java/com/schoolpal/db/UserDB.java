package com.schoolpal.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.schoolpal.web.model.Org;
import com.schoolpal.web.model.Rank;
import com.schoolpal.web.model.Role;
import com.schoolpal.web.model.User;
import com.schoolpal.web.model.Widget;

@Repository
public class UserDB {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String getUserLoginPWD(String loginName) {
		String sql = " select c_loginpass from t_user where c_available = 1 and c_loginname = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[] { loginName }, String.class);
	}
	
	public void updateLastVisit(String loginName, String ip) {
		jdbcTemplate.update(" update t_user set c_last_visit_time = now(), c_last_visit_ip = ? ", new Object[] { ip });
	}
	
	public User getUser(String loginName) {
		final User user = new User();
		String sql = " select user.c_id, org.c_name, org.c_id orgId, org.c_code, org_parent.c_code parent_code, org_root.c_code root_code "
				   + " from t_user user left join t_org org on org.c_id = user.c_org_id "
				   + " left join t_org org_parent on org_parent.c_id = org.c_parent_id "
				   + " left join t_org org_root on org_root.c_id = org.c_root_id "
				   + " where user.c_available = 1 and org.c_available = 1 and user.c_loginname = ? ";
		jdbcTemplate.query(sql, new Object[] { loginName }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				Org org = new Org();
				org.setName(rets.getString("c_name"));
				org.setCode(rets.getString("c_code"));
				org.setParentCode(rets.getString("parent_code"));
				org.setRootCode(rets.getString("root_code"));
				org.setId(rets.getString("orgId"));
				
				user.setLoginName(loginName);
				user.setId(rets.getString("c_id"));
				user.setOrg(org);
			}
		});
		return user;
	}
	
	public List<Role> getRoles(String userId) {
		final List<Role> roles = new ArrayList<Role>();
		String sql = " select r.c_id, r.c_name, r.c_desc, r.c_order_num, rk.c_name rank_name, rk.c_order_num rank_order "
				   + " from t_user_role ur join t_role r on r.c_id = ur.c_role_id join t_rank rk on r.c_rank_id = rk.c_id "
				   + " where ur.c_available = 1 and r.c_available = 1 and ur.c_user_id = ?";
		jdbcTemplate.query(sql, new Object[] { userId }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				Rank rank = new Rank();
				rank.setName(rets.getString("rank_name"));
				rank.setOrder(rets.getInt("rank_order"));
				
				Role role = new Role();
				role.setId(rets.getString("c_id"));
				role.setName(rets.getString("c_name"));
				role.setDesc(rets.getString("c_desc"));
				role.setOrder(rets.getInt("c_order_num"));
				role.setRank(rank);
				roles.add(role);
			}
		});
		return roles;
	}
	
	public Map<String, List<Widget>> getWidgets(List<String> roleIds) {
		final Map<String, List<Widget>> map = new HashMap<String, List<Widget>>();
		String strRoleIds = String.join(",", roleIds);
		String sql = "select rf.c_role_id, f.c_id, f.c_parent_id, f.c_root_id, wt.c_name, f.c_name_short, f.c_name_long, f.c_action, f.c_order_num, f.c_icon "
				   + " from t_role_function rf join t_function f on f.c_root_id = rf.c_function_root_id join t_widget_type wt on wt.c_id = f.c_widget_type_id "
				   + " where rf.c_role_id in (?) and f.c_id not in (select c_function_id from t_role_function_exclude where c_role_id in (?))";
		jdbcTemplate.query(sql, new Object[] { strRoleIds, strRoleIds }, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rets) throws SQLException {
				Widget widget = new Widget();
				widget.setId(rets.getString("c_id"));
				widget.setParentId(rets.getString("c_parent_id"));
				widget.setRootId(rets.getString("c_root_id"));
				widget.setType(rets.getString("c_name"));
				widget.setLabel(rets.getString("c_name_short"));
				widget.setText(rets.getString("c_name_long"));
				widget.setAction(rets.getString("c_action"));
				widget.setIcon(rets.getString("c_icon"));
				widget.setOrder(rets.getInt("c_order_num"));
				
				String roleId = rets.getString("c_role_id");
				List<Widget> widgets = null;
				if (map.containsKey(roleId)) {
					widgets = map.get(roleId);
				} else {
					widgets = new ArrayList<Widget>();
					map.put(roleId, widgets);
				}
				widgets.add(widget);
			}
		});
		return map;
	}

}
