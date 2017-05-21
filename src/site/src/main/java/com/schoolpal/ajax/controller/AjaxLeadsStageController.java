package com.schoolpal.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.ajax.AuthorizationHelper;
import com.schoolpal.db.model.*;
import com.schoolpal.service.*;

@Controller
@RequestMapping("/ajax/mkt/leads/stage")
public class AjaxLeadsStageController {

	@Autowired
	private LeadsService leadsServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public String list() {
		AjaxResponse res = new AjaxResponse(200);
		do {
			if (!AuthorizationHelper.CheckPermissionById("1-2")) {
				res.setCode(400);
				res.setDetail("No permission");
				break;
			}
			
			List<TLeadsStage> stages = null;
			stages = leadsServ.queryLeadsStagesByTypeId(1);
			res.setData(stages);

		} while (false);

		return gson.toJson(res);
	}

}
