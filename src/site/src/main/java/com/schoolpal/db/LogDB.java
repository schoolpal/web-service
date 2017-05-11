package com.schoolpal.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

@Repository
public class LogDB {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void add(String ipService, String ipUser, String creator, String type, String title, String desc, String debug) {
		
		//
		// TODO: log4j
		// 1. 当发生数据库异常时需要记录到文件中；
		// 2. 对于DEBUG类型的信息仅记录到文件中。
		//

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String sql = " insert into t_log(c_id, c_create_time, c_service_ip, c_user_ip, c_creator, c_type, c_title, c_desc, c_debug) " 
						   + " values(f_next_id('t_log'), now(), ?, ?, ?, ?, ?, ?, ?) ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, ipService);
				ps.setString(2, ipUser);
				ps.setString(3, creator);
				ps.setString(4, type);
				String safe_title = title;
				if (title.length() > 49){
					safe_title = title.substring(0, 49);
				}
				ps.setString(5, safe_title);
				ps.setString(6, desc);
				ps.setString(7, debug);
				return ps;
			}
		});
	}

}
