package com.schoolpal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolpal.db.LogDB;
import com.schoolpal.web.model.Log;

@Service
public class LogService {

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private LogDB logDB;
	
	public void log(String creator, Log type, String title, String desc, String debug, String detail) {
		logDB.add(request.getLocalAddr(), request.getRemoteAddr(), creator, type.toString(), title, desc, debug);
	}
	
	public void log(String creator, Log type, String title, String desc, String debug) {
		logDB.add(request.getLocalAddr(), request.getRemoteAddr(), creator, type.toString(), title, desc, debug);
	}
	
	public void log(String creator, Log type, String title, String desc) {
		logDB.add(request.getLocalAddr(), request.getRemoteAddr(), creator, type.toString(), title, desc, "");
	}
	
}
