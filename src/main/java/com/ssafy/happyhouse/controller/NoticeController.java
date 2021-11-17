package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.dto.UserDto;
import com.ssafy.happyhouse.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/register")
	public String register() {
		return "notice/write";
	}
	
	@PostMapping("/register")
	public String register2(NoticeDto noticeDto, Model model, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		noticeDto.setUserId(userDto.getUserId());
		
		noticeService.registerArticle(noticeDto);
		redirectAttributes.addFlashAttribute("msg", "글작성 성공!!!");
		return "redirect:/notice/list";
	}
	
	@RequestMapping(value= {"/list",""})
	public String list(Model model) throws Exception {
		
		List<NoticeDto> list = noticeService.listArticle();
		model.addAttribute("articles",list);
		
		
		return "notice/list";
	}
	@GetMapping("/modify")
	public ModelAndView modify(@RequestParam("articleno") int articleNo) throws Exception {
		ModelAndView mav = new ModelAndView();
		NoticeDto noticeDto = noticeService.getArticle(articleNo);
		mav.addObject("article", noticeDto);
		mav.setViewName("notice/modify");
		return mav;
	}
	
	@PostMapping("/modify")
	public String modify(NoticeDto noticeDto, Model model, RedirectAttributes redirectAttributes)
			throws Exception {
		noticeService.updateArticle(noticeDto);
		redirectAttributes.addFlashAttribute("msg", "글 수정 성공!!!");
		return "redirect:/notice/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("articleno") int articleNo,Model model, RedirectAttributes redirectAttributes) throws Exception {
		
		noticeService.deleteArticle(articleNo);
		redirectAttributes.addFlashAttribute("msg", "글 삭제 성공!!!");
		return "redirect:/notice/list";
		
	}
	
	@RequestMapping(value = "/mainpage", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public @ResponseBody List<NoticeDto> noticeList() throws Exception {
		List<NoticeDto> list = noticeService.listArticle();
		return list;
//		return memberService.listMember();
	}
}
