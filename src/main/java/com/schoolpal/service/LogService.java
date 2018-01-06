package com.schoolpal.service;

import com.schoolpal.consts.LogLevel;
import com.schoolpal.db.LogDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LogService {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private LogDB logDB;
	
	public void log(String creator, LogLevel type, String title, String desc, String debug, String detail) {
		logDB.add(request.getLocalAddr(), request.getRemoteAddr(), creator, type.toString(), title, desc, debug);
	}
	
	public void log(String creator, LogLevel type, String title, String desc, String debug) {
		logDB.add(request.getLocalAddr(), request.getRemoteAddr(), creator, type.toString(), title, desc, debug);
	}
	
	public void log(String creator, LogLevel type, String title, String desc) {
		logDB.add(request.getLocalAddr(), request.getRemoteAddr(), creator, type.toString(), title, desc, "");
	}
	
}
