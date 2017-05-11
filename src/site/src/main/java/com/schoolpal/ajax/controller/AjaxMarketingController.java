package com.schoolpal.ajax.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.ajax.AuthorizationHelper;
import com.schoolpal.db.model.TActivity;
import com.schoolpal.db.model.TOrg;
import com.schoolpal.db.model.TUser;
import com.schoolpal.service.ActivityService;
import com.schoolpal.service.OrgService;
import com.schoolpal.service.UserService;

@Controller
@RequestMapping("/ajax/mkt")
public class AjaxMarketingController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private ActivityService actServ;
	@Autowired
	private OrgService orgServ;
	
	private Gson gson = new Gson();

	protected class listActivitiesResponse{
		private List<TOrg> orgList = null;
		private Map<String, List<TActivity>> actListMap = null;
		
		public listActivitiesResponse(List<TOrg> orgList, Map<String, List<TActivity>> actListMap){
			this.orgList = orgList;
			this.actListMap = actListMap;
		}
	}
	
	@RequestMapping(value = "listActivities.do", method = RequestMethod.POST)
	@ResponseBody
	public String list(String orgId) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("1")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			if (orgId == null){
				res.setCode(401);
				res.setDetail("Orgnization id cannot be empty");
				break;
			}
			
			List<TOrg> orgList = orgServ.queryUpperOrgListByIdLite(orgId);
			Map<String, List<TActivity>> actListMap = new HashMap<String, List<TActivity>>();
			
			for (TOrg org : orgList){
				List<TActivity> actList = actServ.queryActivitiesByOrgId(org.getcId());
				actListMap.put(org.getcId(), actList);
			}
			
			listActivitiesResponse data = new listActivitiesResponse(orgList, actListMap);
			res.setData(data);

		} while (false);

		return gson.toJson(res);
	}
	
}
