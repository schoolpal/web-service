package com.schoolpal.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.db.model.*;
import com.schoolpal.service.*;

@Controller
@RequestMapping("/ajax/mkt/leads/status")
public class AjaxLeadsStatusController {

	@Autowired
	private LeadsService leadsServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public String list(int typeId) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			List<TLeadsStatus> status = null;
			status = leadsServ.queryLeadsStatusByTypeId(typeId);
			res.setData(status);

		} while (false);

		return gson.toJson(res);
	}

}
