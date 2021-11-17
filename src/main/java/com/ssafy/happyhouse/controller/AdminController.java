package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public @ResponseBody List<UserDto> userList() throws Exception {
		List<UserDto> list = userService.listMember();
		logger.debug("회원목록 : {}", list);
		return list;
//		return memberService.listMember();
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public List<UserDto> userRegister(@RequestBody UserDto userDto) throws Exception {
		userService.registerMember(userDto);
		List<UserDto> list = userService.listMember();
		System.out.println("뭐가 문제지 "+list);
		logger.debug("회원목록 : {}", list);
		return list;
	}
	
//	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
//	public UserDto userInfo(@PathVariable("userid") String userid) throws Exception {
//		return userService.getMember(userid);
//	}
//	
	@RequestMapping(value = "/user", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public List<UserDto> userModify(@RequestBody UserDto userDto) throws Exception {
		userService.updateMember(userDto);
		return userService.listMember();
	}
//	
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	public List<UserDto> userDelete(@PathVariable("userid") String userid) throws Exception {
		userService.deleteMember(userid);
		return userService.listMember();
	}
}
