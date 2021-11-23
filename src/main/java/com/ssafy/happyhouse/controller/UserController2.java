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
	public String signUpUser(UserDto userDto, Model model) throws Exception {
		userService.signUpUser(userDto);
		return "index";
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
//	@PostMapping("/login2")
//	public String loginUser2(@RequestParam Map<String, String> map, Model model, HttpSession session,
//			HttpServletResponse response) throws Exception {
//		//UserDto userDto = userService.login(map);
////		String id = map.get("userId");
////		String pwd = map.get("userPwd");
////		if("ssafy".equals(id) && "ssafy".equals(pwd)) {
////			session.setAttribute("userinfo", new UserDto(id,pwd));
////			
////			return "index";
////		}else {
////			model.addAttribute("msg","잘못된 아이디 비밀번호");
////		}
////		return "error/error";
//					
//		if (userDto != null) {
//			session.setAttribute("userinfo", userDto);
//
//			Cookie cookie = new Cookie("user_id", map.get("userId"));
//			cookie.setPath("/");
//			if ("saveok".equals(map.get("idsave"))) {
//				cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
//			} else {
//				cookie.setMaxAge(0);
//			}
//			response.addCookie(cookie);
//			return "index";
//		} else {
//			model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
//			return "index";
//		}
//	}
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session) throws Exception {	
		session.invalidate();
		return "index";
	}
	

	@GetMapping("/list")
	public String list() {
		return "user/list";
	}
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		process(request, response);
//	}
//
//	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		String root = request.getContextPath();
//		String act = request.getParameter("action");
//		String path = "/index.jsp";
//		
//		if("mvSignUp".equals(act)) {
//			path="/user/signup.jsp";
//			response.sendRedirect(root + path);
//		} else if("signUp".equals(act)) {
//			path = signUpUser(request, response);
//			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//			dispatcher.forward(request, response);
//		} else if("logIn".equals(act)) {
//			path = loginUser(request, response);
//			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//			dispatcher.forward(request, response);
//		} else if("logout".equals(act)) {
//			path = logoutUser(request, response);
//			response.sendRedirect(root+ path);
//		} else if("mvFindPwd".equals(act)) {
//			path="/user/findPwd.jsp";
//			response.sendRedirect(root + path);
//		} else if("findPwd".equals(act)) {
//			path = findPwd(request, response);
//			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//			dispatcher.forward(request, response);
//		} else if("updateUser".equals(act)) {
//			path = getUpdateUser(request, response);
//			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//			dispatcher.forward(request, response);
//		}
//	}
//	
//	private String getUpdateUser(HttpServletRequest request, HttpServletResponse response) {
//		String id = request.getParameter("userid");
//		String pwd = request.getParameter("userpwd");
//		String name = request.getParameter("username");
//		String addr = request.getParameter("addr");
//		String phone = request.getParameter("phone");
//		String email = request.getParameter("email");
//		
//		UserDto userDto = new UserDto(id, pwd, name, email, addr, phone );
//		try {
//			HttpSession session = request.getSession();
//			userService.updateUser(userDto, (UserDto)session.getAttribute("userinfo"));
//
//			return "/index.jsp";
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "로그인중 문제 발생 ");
//			return "/index.jsp";
//		}
//	
//	}
//	private String findPwd(HttpServletRequest request, HttpServletResponse response) {
//		String id = request.getParameter("userid");
//		String name = request.getParameter("username");
//		String phone = request.getParameter("email");
//		
//		UserDto userDto = null;
//		try {
//			userDto = userService.findPwd(id, name, phone);
//
//			if(userDto != null) {
//				request.setAttribute("userinfo", userDto);
//				return "/user/findPwd_result.jsp";
//			} else {
//				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
//				return "/index.jsp";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "로그인중 문제 발생 ");
//			return "/index.jsp";
//		}
//	}
//	private String logoutUser(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		session.invalidate();
//		return "/index.jsp";
//	}
//	private String loginUser(HttpServletRequest request, HttpServletResponse response) {
//		String id = request.getParameter("userid");
//		String pwd = request.getParameter("userpwd");
//		
//		UserDto userDto = null;
//		try {
//			userDto = userService.login(id, pwd);
//			
//			if(userDto != null) {
////				session 설정
//				HttpSession session = request.getSession();
//				session.setAttribute("userinfo", userDto);
//				
//				return "/index.jsp";
//			} else {
//				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
//				return "/index.jsp";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msg", "로그인중 문제 발생 ");
//			return "/index.jsp";
//		}
//	}
//	private String signUpUser(HttpServletRequest request, HttpServletResponse response) {
//		UserDto userDto = new UserDto();
//		userDto.setUserId(request.getParameter("userid"));
//		userDto.setUserName(request.getParameter("username"));
//		userDto.setUserPwd(request.getParameter("userpwd"));
//		userDto.setEmail(request.getParameter("email"));
//		userDto.setAddr(request.getParameter("addr"));
//		userDto.setPhone(request.getParameter("phone"));
//		try {
//			userService.signUpUser(userDto);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			request.setAttribute("msg", "회원가입중 문제 발생 ");
//			return "/error/error.jsp";
//		}
//		return "/index.jsp";
//	}

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
	public String modifyUser(UserDto userDto, Model model, HttpSession session) throws Exception {
		userService.updateUser(userDto);
		session.setAttribute("userinfo", userDto);
		return "index";
	}

	@PostMapping("/delete")
	public String deleteUser(@RequestParam String userId, Model model, HttpSession session) throws Exception {
		userService.deleteUser(userId);
		System.out.println("in!!!!");
		
		return "index";
	}
}
