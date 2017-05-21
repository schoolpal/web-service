package com.schoolpal.ajax.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.schoolpal.ajax.AjaxResponse;
import com.schoolpal.web.consts.ParentRelation;

@Controller
@RequestMapping("/ajax/mkt/relation")
public class AjaxParentRelationController {

	private Gson gson = new Gson();

	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	@ResponseBody
	public String list() {
		AjaxResponse res = new AjaxResponse(200);
		do {
			Map<Integer, String> data = new HashMap<Integer, String>();
			for (ParentRelation g : ParentRelation.values()){
				data.put(g.getValue(), g.getName());
			}
			
			res.setData(data);

		} while (false);

		return gson.toJson(res);
	}

}

