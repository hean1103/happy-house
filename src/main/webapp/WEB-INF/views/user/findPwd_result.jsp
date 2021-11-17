<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.ssafy.happyhouse.model.dto.UserDto"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>


<body>
	<div class="container">
		<c:if test="${!empty userInfo}">
			<div>${userInfo.getUserName()}님의 비밀번호는 </div>
			<strong>${userInfo.getUserPwd()}</strong>
			입니다.
		</c:if>
		<br/>
		<a href="${root}/">돌아가기</a>
	</div>
</body>
</html>