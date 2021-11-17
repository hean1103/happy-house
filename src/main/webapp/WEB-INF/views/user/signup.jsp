<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<body>
	<script type="text/javascript">
        $(document).ready(function () {
        	
        	var isId = false;
        	// 아이디 중복검사
        	$("#signUpId").keyup(function () {
        		var ckid = $("#signUpId").val();
        		if(ckid.length < 6 || ckid.length > 16) {
        			$("#idresult").text("아이디는 6자이상 16자이하입니다.").removeClass('text-primary').removeClass('text-danger').addClass('text-dark');
        			isId = false;
        		} else {
	                $.ajax({
	                	url: '${root}/idcheck',
	                	data: {'ckid': ckid},
	                  	type: 'GET',
	                  	dataType: 'json',
	                  	success: function (response) {
	                  		console.log(response);
	                    	var cnt = response.idcount;
	                    	if(cnt == 0) {
	                    		$("#idresult").text(ckid + "는 사용가능합니다.").removeClass('text-dark').removeClass('text-danger').addClass('text-primary');
	                    		isId = true;
	                    	} else {
	                    		$("#idresult").text(ckid + "는 사용할 수 없습니다.").removeClass('text-dark').removeClass('text-primary').addClass('text-danger');
	                    		isId = false;
	                    	}
	                  	}, 
	                  	error: function(request, status, error) {
	                  		console.log("status : " + request.status + "\tmsg : " + error);
	                  	}
					});
        		}
			}); 
        	
        	// 회원가입
            $("#signUpBtn").click(function () {
                if (!$("#signUpName").val()) {
                    alert("이름 입력!!!");
                    return;
                }  else if (!$("#signUpId").val()) {
                    alert("아이디 입력!!!");
                    return;
                }else if (!$("#signUpPw").val()) {
                    alert("비밀번호 입력!!!");
                    return;
                } 
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
		<h2 class="col-md-3 text-md-right">회원 가입</h2>
		<form method="post" action="${root}/user/signUp">
			<div class="form-group row">
				<label for="inputId" class="col-md-3 control-label text-md-right col-form-label">
					아이디<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="signUpId" name="userId">
					<div id="idresult" class="mt-1"></div>
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPw" class="col-md-3 control-label text-md-right col-form-label">
					비밀번호<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="password" class="form-control" id="signUpPw" placeholder="영문 숫자 포함 6자리 이상" name="userPwd">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputName" class="col-md-3 control-label text-md-right col-form-label">
					이름<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="signUpName" placeholder="사용자 성명" name="userName"> 
				</div>
			</div>
			<div class="form-group row">
				<label for="inputEmail" class="col-md-3 control-label text-md-right col-form-label">
					주소<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="signUpAddr" placeholder="주소" name="addr">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-md-3 control-label text-md-right col-form-label">
					전화번호<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="signUpPhone" placeholder="010-1234-5678" name="phone">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-md-3 control-label text-md-right col-form-label">
					이메일<span class="text-danger small">*</span>
				</label>
				<div class="col-8">
					<input type="text" class="form-control" id="signUpEmail" placeholder="ssafy@ssafy.com" name="email">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-11">
					<button type="submit" class="btn btn-group btn-primary btn-animated float-right" id="signUpBtn">등록 </button>
				</div>
			</div>
		</form>
    </div>
    <footer class="container-fluid text-center">
    <ul id="fList" style="padding: 0">
   		<li><a href="../index.html">* 메인 메뉴</a></li>
   		<li><a href="signUp.html">* 회원 가입</a></li>
   		<li><a href="memberInfo.html">* 회원 정보</a></li>
   		<li><a href="inquireHouse.html">* 실거래가 조회</a></li>
   	</ul>
   	Made by &copy;SSAFY 6th gen. class 10 경혜안 & 권도혁
    </footer>
    <!--Bootstrap JS-->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src=https://code.jquery.com/jquery-3.5.1.min.js></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</body>
</html>