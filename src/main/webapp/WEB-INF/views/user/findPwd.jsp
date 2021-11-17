<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<body>
	<div class="container pt-3">
		<h2 class="col-md-3 text-md-right">비밀번호 찾기</h2>
		<form method="post" action="${root}/user/findPwd">
			<input type="hidden" name="action" value="findPwd">
			<div class="form-group row">
				<label for="inputId" class="col-md-3 control-label text-md-right col-form-label">
					아이디<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="findId" name="userId">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputName" class="col-md-3 control-label text-md-right col-form-label">
					이름<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="findName" placeholder="사용자 성명" name="userName"> 
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-md-3 control-label text-md-right col-form-label">
					이메일<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="findEmail" placeholder="ssafy@ssafy.com" name="email">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-8">
					<button type="submit" class="btn btn-group btn-primary btn-animated float-right" id="findPwBtn">찾기 </button>
				</div>
			</div>
		</form>
	</div>
    <!--Bootstrap JS-->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src=https://code.jquery.com/jquery-3.5.1.min.js></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</body>
</html>