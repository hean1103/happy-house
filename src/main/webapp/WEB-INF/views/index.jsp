<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
    <div class="container-fluid">
    	<div class="jumbotron jumbotron-fluid">
    		<div class="container">
    			<h1>[ Happy House ]</h1>
    			<h4>by 경혜안 & 권도혁</h4>
    		</div>
    	</div>
    </div>
    <div class="container">
	    <div class="row">
	    	<div class="col-4 justify-content-center">
	    		<div class="card" style="height:500px">
	    			<div class="container pt-3">
	    			<h4>실거래가 조회</h4>
	    			</div>
	    			<form method="post" action="search">
	    				<div class="container pt-3">
	    					<input type="hidden" name = "action" value="form">
	    					<label>시/도/광역시 : </label><br>
	    					<input type="text" name="sidogwang"><br>
	    					<label>시/구/군 : </label><br>
	    					<input type="text" name="sigugun"><br>
	    					<label>동 : </label><br>
	    					<input type="text" name="dong">
	
	    					<input type="submit" value="조회">
	    				</div>
	    			</form>
	    			<div class="container pt-3">
	    				<p>
	    					* 조회를 누르면 검색 가능합니다.<br>
	    					* 꼭 모든 값을 선택해 주세요.
	    				</p>
	    			</div>
	    		</div>
	    	</div>
	    	<div class="col-8 justify-content-center">
	    		<div id="map" class="card" style="width:100%;height:400px;"></div>
	    		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=24ee643116f5681eb70b922830bf08ef"></script>
	    		
	    	</div>
	    </div>
    </div>
    <div class="container pt-3">
    	<div class="row">
    		<div class="col-4">
    			<div class="card box-shadow">
    				<div class="container pt-2">
    					<h5>웹페이지 소개</h5>
    					<p>
    						본 웹페이지는 서울 6기 10반의 학생인 경혜안과 백혜민이 제작한 웹 사이트로
    						Web Front 관통 프로젝트 결과물 입니다. 국토교통부_아파트매매 실거래 상세 자료를 기반으로 조회를 수행합니다.
    					</p>
    				</div>
    			</div>
    		</div>
    		<div class="col-4">
    			<div class="card box-shadow">
    				<div class="container pt-2">
	    				<h5>공지 사항</h5>
	    				<ul id="noticeList">
	    					<li>공지 사항 리스트</li>
	    				</ul>
	    				
	    			</div>	
	    		</div>
    		</div>
    		<div class="col-4">
    			<div class="card box-shadow">
    				<div class="container pt-2">
	    				<h5>심화 파트</h5>
	    				<ul>
	    					<li>심화 파트 내용</li>
	    				</ul>
    					<br><br><br><br>
    				</div>
    			</div>
   		 	</div>
    	</div>
    </div>
    <footer class="container-fluid text-center">
    <ul id="fList" style="padding: 0">
   		<li><a href="index.jsp">* 메인 메뉴</a></li>
   		<li><a href="page/signUp.jsp">* 회원 가입</a></li>
   		<li><a href="page/memberInfo.jsp">* 회원 정보</a></li>
   		<li><a href="page/inquireHouse.jsp">* 실거래가 조회</a></li>
   	</ul>
   	Made by &copy;SSAFY 6th class 10 경혜안 & 권도혁
    </footer>
    <!--Bootstrap JS-->
    <!-- 에러나서 주석처리 자바스크립트 불러오는 부분. -->
<!--  	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	<!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=24ee643116f5681eb70b922830bf08ef&libraries=services"></script> -->
	<!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=24ee643116f5681eb70b922830bf08ef"></script>  d4d731d8ef908156470d34861d60e5d2 -->
	<script src="../js/inquireHouse.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		
		//회원 목록
		$.ajax({
			url:'${root}/notice/mainpage',  
			type:'GET',
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			success:function(articles) {
				$("#noticeList").empty();
				$.each(articles, function(index,item){
					let str = "<li >" + item.subject + "</li>";
					$("#noticeList").append(str);
				});
			},
			error:function(xhr, status, error){
				console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
			},
			statusCode: {
				500: function() {
					alert("서버에러.");
					// location.href = "/error/e500";
				},
				404: function() {
					alert("페이지없다.");
					// location.href = "/error/e404";
				}
			}	
		});
	});
	
	
	</script>
</body>
</html>