package com.schoolpal.web.controller.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.schoolpal.web.controller.ajax.model.AjaxResponse;
import com.schoolpal.db.model.*;
import com.schoolpal.service.*;

@Controller
@RequestMapping("/ajax/role")
public class AjaxRoleController {

//	@Autowired
//	private LogService logServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private OrgService orgServ;
	@Autowired
	private RoleService roleServ;
//	@Autowired
//	private FunctionService funcServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "query.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse query(String id) {
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
		
		return res;
	}
	
	@RequestMapping(value = "ranks.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse ranks() {
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
		
		return res;
	}

}
