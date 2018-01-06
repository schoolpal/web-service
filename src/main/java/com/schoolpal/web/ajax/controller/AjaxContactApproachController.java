package com.schoolpal.web.ajax.controller;

import com.google.gson.Gson;
import com.schoolpal.db.model.TContactApproach;
import com.schoolpal.service.ContactService;
import com.schoolpal.web.ajax.model.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ajax/contact/approach")
public class AjaxContactApproachController {

	@Autowired
	private ContactService contactServ;

	private Gson gson = new Gson();

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponse list() {
		AjaxResponse res = new AjaxResponse(200);
		do {
			List<TContactApproach> approaches = null;
			approaches = contactServ.queryContactApproaches();
			res.setData(approaches);

		} while (false);

		return res;
	}

}
