<%@page import="java.util.List"%>
<%@page import="com.ssafy.happyhouse.model.dto.HouseInfo"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
    		
	String sidogwang = (String)session.getAttribute("sidogwang");
    String sigugun= (String)session.getAttribute("sigugun");
    String dong= (String)session.getAttribute("dong");
    			
	List<HouseInfo> list = (List<HouseInfo>)session.getAttribute("list");
%>
    <div class="container-fluid">
    	<div class="jumbotron jumbotron-fluid">
    		<div class="container">
    			<h1>[ Happy House ]</h1>
    			<h4>by 경혜안 & 백혜민</h4>
    		</div>
    	</div>
    </div>
    
    <div class="container">
    	<div><h4>실거래가 조회</h4></div>
    	<div class="container card p-3">
    		<form class="row">
    			<div class="container col-4 pt-3">
	    			<label for="region">시/도/광역시 : </label>
	    			<%= sidogwang %>
	    		</div>
	   			<div class="container col-4 pt-3">
	    			<label for="city">시/구/군 : </label>
	   				<%= sigugun %>
	   			</div>
	   			<div class="container col-4 pt-3">
	    			<label for="town">동 : </label>
	    			<%= dong %>
	   			</div>
	  			<div class="container pt-3">
	   				<button class="btn btn-primary float-right" type="button" onclick="location.href='index.jsp'">돌아가기</button>
	    		</div>
    		</form>
    	</div>
    </div>
	<div class="container pt-3">
	    <div class="row">
	    	<div class="col-4 justify-content-center">
	    		<div class="card" style="height:500px">
	    			<div class="container pt-3">
	    				<h3>실거래 정보</h3>
	    				<div id="data-container" style="max-height:450px;">
	    				<% 
	    					for(int i=0;i<3;i++) {
	    				%>		
	    						<h6><%=list.get(i).getAptName() %></h6><br>
	    						거래금액: <%=list.get(i).getDealAmount() %> 만원<br>
	    						면적: <%=list.get(i).getArea() %><br>
	    						거래년도: <%=list.get(i).getDealYear() %>
        					<hr>
        				<%
	    					}
        				%>
        				</div>
	    			</div>
	    		</div>
	    	</div>
	    	<div class="col-8 justify-content-center">
	    		<div id="map" class="card" style="width:100%;height:500px;"></div>
	    	</div>
	    </div>
    </div>
    <footer class="container-fluid text-center">
   	<ul id="fList" style="padding: 0">
   		<li><a href="../index.jsp">* 메인 메뉴</a></li>
   		<li><a href="signUp.jsp">* 회원 가입</a></li>
   		<li><a href="memberInfo.jsp">* 회원 정보</a></li>
   		<li><a href="inquireHouse.jsp">* 실거래가 조회</a></li>
   	</ul>
   	Made by &copy;SSAFY 6th class 10 경혜안 & 백혜민
    </footer>
    <!--Bootstrap JS-->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src=https://code.jquery.com/jquery-3.5.1.min.js></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d4d731d8ef908156470d34861d60e5d2&libraries=services"></script>
	<script src="https://pagination.js.org/dist/2.1.5/pagination.min.js"></script>
	<script src="../js/main.js"></script>
	<script src="../js/inquireHouse.js"></script>
</body>
</html>