<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.happyhouse.model.dto.UserDto"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<script type="text/javascript">
	$(document).ready(function() {
		
		$("#deleteBtn").click(function() {
			let userid = $("#userId").val(), 
			$.ajax({
				url:'${root}/user/delete',  
				type:'POST',
				contentType:'application/json;charset=utf-8',
				dataType:'json',
				data: userid,
				success:function(users) {
					alert("삭제 되었습니다!");
				},
				error:function(xhr,status,msg){
					console.log("상태값 : " + status + " Http에러메시지 : "+msg);
				}
			});
		});
	});
	
	</script>
	
    <div class="container-fluid">
    	<div class="jumbotron jumbotron-fluid">
    		<div class="container">
    			<h1>[ Happy House ]</h1>
    			<h4>by 경혜안 & 권도혁</h4>
    		</div>
    	</div>
    </div>
    <div class="container" style="height:550px">
		<h2 class="col-md-3 text-md-right">회원 정보</h2>
		<form method="post" action="${root}/user/modify">
			<div class="form-group row">
				<label for="inputId" class="col-md-3 control-label text-md-right col-form-label">
					아이디
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="userId" value="<%=userDto.getUserId() %>" name="userId">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPw" class="col-md-3 control-label text-md-right col-form-label">
					비밀번호
				</label>
				<div class="col-8">
					<input type="password" class="form-control" id="userPwd" value="<%=userDto.getUserPwd() %>" name="userPwd">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputName" class="col-md-3 control-label text-md-right col-form-label">
					이름
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="userName" value="<%=userDto.getUserName() %>" name="userName"> 
				</div>
			</div>
			<div class="form-group row">
				<label for="inputEmail" class="col-md-3 control-label text-md-right col-form-label">
					주소
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="addrInfo" value="<%=userDto.getAddr() %>" name="addr">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-md-3 control-label text-md-right col-form-label">
					전화번호
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="phoneInfo" value="<%= userDto.getPhone()%>" name="phone">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-md-3 control-label text-md-right col-form-label">
					이메일
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="emialInfo" value="<%= userDto.getEmail()%>" name="email">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-10">
					<button type="submit" class="btn btn-group btn-warning btn-animated float-right">회원정보 수정</button>
				</div>
				<div class="col-2">
					<button type="button" class="btn btn-group btn-danger btn-animated" id="deleteBtn">회원정보 삭제</button>
				</div>
			</div>
		</form>
    </div>
    <footer class="container-fluid text-center">
   	<ul id="fList" style="padding: 0">
   		<li><a href="../index.jsp">* 메인 메뉴</a></li>
   		<li><a href="signUp.jsp">* 회원 가입</a></li>
   		<li><a href="memberInfo.jsp">* 회원 정보</a></li>
   		<li><a href="inquireHouse.jsp">* 실거래가 조회</a></li>
   	</ul>
   	Made by &copy;SSAFY 6th class 10 경혜안 & 권도혁
    </footer>
    <!--Bootstrap JS-->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src=https://code.jquery.com/jquery-3.5.1.min.js></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</body>
</html>