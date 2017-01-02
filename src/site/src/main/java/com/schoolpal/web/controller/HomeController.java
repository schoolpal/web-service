package com.schoolpal.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schoolpal.service.LogService;
import com.schoolpal.web.model.Log;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private LogService logServ;

	@RequestMapping("index.html")
	public String index() {
		logServ.log("", Log.DEBUG, "HomeController.index()", "");
		return "home/index";
	}
	
}
