package com.schoolpal.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//@Repository
@Deprecated
public class LogDB {
	
//	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Deprecated
	public void add(String level, String message, String userId, String userName, String invocation, String args, String returnVal, String ip) {
		
		//
		// TODO: log4j
		// 1. 当发生数据库异常时需要记录到文件中；
		// 2. 对于DEBUG类型的信息仅记录到文件中。
		//

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String sql = " insert into t_log (`id`, `datetime`, `level`, `message`, `user_id`, `user_name`, `ip`, `invocation`, `args`, `return`) "
						   + " values(f_next_id('t_log'), now(), ?, ?, ?, ?, ?, ?, ?, ?) ";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, level);
				ps.setString(2, message);
				ps.setString(3, userId);
				ps.setString(4, userName);
				ps.setString(5, ip);
				ps.setString(6, invocation);
				ps.setString(7, args);
				ps.setString(8, returnVal);
				return ps;
			}
		});
	}

}
