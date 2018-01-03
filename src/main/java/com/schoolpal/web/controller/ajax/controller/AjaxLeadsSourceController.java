package com.schoolpal.web.controller.ajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.schoolpal.web.controller.ajax.model.AjaxResponse;
import com.schoolpal.db.model.TLeadsSource;
import com.schoolpal.service.LeadsService;

@Controller
@RequestMapping("/ajax/mkt/leads/source")
public class AjaxLeadsSourceController {

	@Autowired
	private LeadsService leadsServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse list(Integer typeId) {
		AjaxResponse res = new AjaxResponse(200);
		do {
			List<TLeadsSource> sources = null;
			sources = leadsServ.queryLeadsSourcesByTypeId(typeId);
			res.setData(sources);

		} while (false);

		return res;
	}

}
