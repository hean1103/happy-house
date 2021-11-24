package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.service.JwtServiceImpl;
import com.ssafy.happyhouse.service.UserService;


import io.swagger.annotations.ApiParam;

	

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/users")
public class UserController2 {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/mvSignUp")
	public String mvSignUpUser() throws Exception {	
		return "user/signup";
	}
	
	@PostMapping("/signUp")
	public void signUpUser(@RequestBody UserDto userDto, Model model) throws Exception {
		
//		System.out.println(userDto.toString());
		
		userService.signUpUser(userDto);
		
	}
	@PostMapping("/login")
	public ResponseEntity<Map<String,Object>> loginUser(@RequestBody UserDto userDto, Model model, HttpSession session,
			HttpServletResponse response) throws Exception {
//		String tokenTest = jwtService.create("id", userDto, "access");
//		System.out.println(tokenTest);
		System.out.println("map : "+ userDto.getUserId());
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			UserDto loginUser = userService.login(userDto);
			if (loginUser != null) {
				String token = jwtService.create("userid", loginUser.getUserId(), "access-token");// key, data, subject
				System.out.println("토큰정보 : "+token);
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			System.out.println("로그인 실패");
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String,Object>>(resultMap,status);
	}
	
	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userid") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userid,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			System.out.println("사용가능한 토큰");
			try {
//				로그인 사용자 정보.
				UserDto memberDto = userService.userInfo(userid);
				resultMap.put("userInfo", memberDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				System.out.println("정보조회 실패");
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			System.out.println("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session) throws Exception {	
		session.invalidate();
		return "index";
	}
	

	@GetMapping("/list")
	public String list() {
		return "user/list";
	}
	

	@GetMapping("/mvFindPwd")
	public String mvFindPwdUser() throws Exception {	
		return "user/findPwd";
	}
	
	@PostMapping("/findPwd")
	public ModelAndView findPwdUser(@RequestParam Map<String, String> map, Model model, HttpSession session,HttpServletResponse response) throws Exception {
		UserDto userDto = userService.findPwd(map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("userInfo", userDto);
		mav.setViewName("user/findPwd_result");
		return mav;	
	}
	
	@GetMapping("/mvModify")
	public String mvModify() throws Exception {	
		return "page/memberInfo";
	}


	@PostMapping("/modify")
	public void modifyUser(@RequestBody UserDto userDto, Model model, HttpSession session) throws Exception {
		System.out.println("수정");
		System.out.println(userDto.toString());
		userService.updateUser(userDto);
//		session.setAttribute("userinfo", userDto);
		
	}

	@PostMapping(value="/delete")
	public void deleteUser(@RequestBody UserDto userDto, Model model, HttpSession session) throws Exception {
		System.out.println("삭제");
		System.out.println(userDto.getUserId());
		userService.deleteUser(userDto.getUserId());
		System.out.println("in!!!!");
		
	}
}
