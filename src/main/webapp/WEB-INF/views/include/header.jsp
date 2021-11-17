<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.happyhouse.model.dto.UserDto"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />    
<%String root = request.getContextPath();
UserDto userDto = (UserDto) session.getAttribute("userinfo");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>04_HappyHouse_Front</title>

    <!-- Bootstrap CSS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	<link href="${root }/css/main.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
		<div class="container justify-content-between">
		<a class="navbar-brand" href="${root }/user/index">Happy House</a>
		<c:if test="${empty userinfo}">

       		<ul class="navbar-nav" id="loggedout">
           		<li class="nav-item">
           			<a class="nav-link" href="${root}/user/mvSignUp">Sign Up</a>
           		</li>
           		<li class="nav-item">
            		<div class="dropdown">
                        <a class="nav-link dropdown-toggle--no-caret" href="" data-toggle="dropdown">Login</a>
                        <div class="dropdown-menu dropdown-menu-right">
                            <form class="login-form p-1" method="post" action="${root}/user/login">
                  
								<label>아이디</label> 
                                <input type="text" class="form-control" id="id" name="userId">
								<label>비밀번호</label> 
                                <input type="password" class="form-control" id="pw" name="userPwd">
								<button type="submit" class="btn btn-primary btn-sm mt-1" id="loginBtn">로그인</button>				 
								<a href="${root}/user/mvFindPwd">비밀번호 찾기</a>
							</form>
                    	</div>
               		</div>
            	</li>
        	</ul>
        </c:if>
        <c:if test="${!empty userinfo && userinfo.userId ne 'admin'}">
       		<ul class="navbar-nav" id="loggedin">
       			<li class="nav-item">
           			<a class="nav-link" href="" id="notice">공지사항</a>
           		</li>
           		<li class="nav-item">
           			<a class="nav-link" href="" id="interestPlace">관심지역 설정</a>
           		</li>
           		<li class="nav-item">
           			<a class="nav-link" href="" id="inquireInterest">관심지역 조회</a>
           		</li>
           		<li class="nav-item">
           			<a class="nav-link" href="${root}/user/logout" id="logoutBtn">Logout</a>
           		</li>
           		<li class="nav-item">
           			<a class="nav-link" href="${root}/user/mvModify">회원정보 수정</a>
           		</li>
        	</ul>
        </c:if>
        <c:if test="${!empty userinfo && userinfo.userId eq 'admin'}">
       		<ul class="navbar-nav" id="loggedin">
       			<li class="nav-item">
           			<a class="nav-link" href="${root}/notice" id="notice">공지사항</a>
           		</li>
           		<li class="nav-item">
           			<a class="nav-link" href="${root}/user/list" id="members">회원목록</a>
           		</li>
           		<li class="nav-item">
           			<a class="nav-link" href="${root}/user/logout" id="logoutBtn">Logout</a>
           		</li>
        	</ul>
        </c:if>
		</div>
    </nav>