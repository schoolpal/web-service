package com.schoolpal.ajax.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.ajax.AuthorizationHelper;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TRank;
import com.schoolpal.db.model.TRole;
import com.schoolpal.db.model.TRoleFunction;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.FunctionService;
import com.schoolpal.service.LogService;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.RoleService;
import com.schoolpal.service.UserService;
import com.schoolpal.web.consts.LogLevel;
import com.schoolpal.web.model.OrgForm;
import com.schoolpal.web.model.RoleForm;

@Controller
@RequestMapping("/ajax/role")
public class AjaxRoleController {

	@Autowired
	private LogService logServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private OrgService orgServ;
	@Autowired
	private RoleService roleServ;
	@Autowired
	private FunctionService funcServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@ResponseBody
	public String query(String id) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			TUser user = userServ.getCachedUser();
			
			List<String> orgList = null;
			try{
				orgList = orgServ.queryOrgIdListByRootId(user.getcOrgId());
			}catch(Exception e){
				res.setCode(501);
				res.setDetail("Unexpect error");
				break;
			}
			
			TRole role = null;
			try{
				role = roleServ.queryRoleById(id);
			}catch(Exception e){
				res.setCode(502);
				res.setDetail("Unexpect error");
				break;
			}
			if (role == null){
				res.setCode(401);
				res.setDetail("Cannot find role");
				break;
			}
			if (!orgList.contains(role.getcOrgId())) {
				res.setCode(402);
				res.setDetail("No permission to query role under parent orgnization");
			}
			
			res.setData(role);
			
		} while (false);
		
		return gson.toJson(res);
	}
	
	@RequestMapping(value = "ranks.do", method = RequestMethod.POST)
	@ResponseBody
	public String ranks() {
		AjaxResponse res = new AjaxResponse(200);
		do {
			List<TRank> rankList = null;
			try{
				rankList = roleServ.queryRankList();
			}catch(Exception e){
				res.setCode(501);
				res.setDetail("Unexpect error");
				break;
			}
			
			res.setData(rankList);
			
		} while (false);
		
		return gson.toJson(res);
	}

}
