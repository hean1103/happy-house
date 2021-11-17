package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.ssafy.happyhouse.model.dao.house.HouseDaoImpl;
import com.ssafy.happyhouse.model.dto.HouseInfo;

@RestController
@RequestMapping("/search")
public class SearchController  {
//	private static final long serialVersionUID = 1L;
// 
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		process(request,response);
//	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		process(request,response);
//	}
//	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
//		String sidogwang = request.getParameter("sidogwang");
//		String sigugun= request.getParameter("sigugun");
//		String dong= request.getParameter("dong");
//		
//		request.getSession().setAttribute("sidogwang", sidogwang);
//		request.getSession().setAttribute("sigugun", sigugun);
//		request.getSession().setAttribute("dong", dong);
//		System.out.println(1);
////		HouseDaoImpl house = new HouseDaoImpl();
////		List<HouseInfo> list = house.queryHouseData(dong);
////		
////		request.getSession().setAttribute("list", list);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/page/inquireHouse.jsp");
//		dispatcher.forward(request, response);
//	}
}