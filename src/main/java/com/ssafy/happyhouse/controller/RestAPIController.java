package com.ssafy.happyhouse.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.ssafy.happyhouse.service.UserService;


@RestController
public class RestAPIController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/idcheck")
//	@ResponseBody
	public String idCheck(@RequestParam("ckid") String checkId) throws Exception {
		System.out.println(checkId);
		int idCount = userService.idCheck(checkId);
		JSONObject json = new JSONObject();
		json.put("idcount", idCount);
		
		return json.toString();
	}
	
	
}
