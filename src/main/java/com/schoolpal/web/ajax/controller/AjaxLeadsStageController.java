package com.schoolpal.web.ajax.controller;

import com.google.gson.Gson;
import com.schoolpal.db.model.TLeadsStage;
import com.schoolpal.service.LeadsService;
import com.schoolpal.web.ajax.model.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ajax/mkt/leads/stage")
public class AjaxLeadsStageController {

	@Autowired
	private LeadsService leadsServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse list(Integer typeId) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			List<TLeadsStage> stages = null;
			stages = leadsServ.queryLeadsStagesByTypeId(typeId);
			res.setData(stages);

		} while (false);

		return res;
	}

}
