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
