<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
    <div class="container-fluid">
    	<div class="jumbotron jumbotron-fluid">
    		<div class="container">
    			<h1>[ Happy House ]</h1>
    			<h4>by 정유환 & 백혜민</h4>
    		</div>
    	</div>
    </div>
    <div class="container" style="height:550px">
		<h2 class="col-md-3 text-md-right">회원 가입</h2>
		<form>
			<div class="form-group row">
				<label for="inputId" class="col-md-3 control-label text-md-right col-form-label">
					아이디<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="signUpId">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPw" class="col-md-3 control-label text-md-right col-form-label">
					비밀번호<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="password" class="form-control" id="signUpPw" placeholder="영문 숫자 포함 6자리 이상">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputName" class="col-md-3 control-label text-md-right col-form-label">
					이름<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="signUpName" placeholder="사용자 성명"> 
				</div>
			</div>
			<div class="form-group row">
				<label for="inputEmail" class="col-md-3 control-label text-md-right col-form-label">
					주소<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="signUpAddr" placeholder="주소">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-md-3 control-label text-md-right col-form-label">
					전화번호<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="signUpPhone" placeholder="010-1234-5678">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-11">
					<button type="button" class="btn btn-group btn-primary btn-animated float-right" id="signUpBtn">등록 </button>
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
   	Made by &copy;SSAFY 6th class 10 경혜안 & 백혜민
    </footer>
    <!--Bootstrap JS-->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src=https://code.jquery.com/jquery-3.5.1.min.js></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	<script src="../js/main.js"></script>
	<script src="../js/signUp.js"></script>
</body>
</html>