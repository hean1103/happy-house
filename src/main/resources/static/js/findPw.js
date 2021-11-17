$(document).ready(function () {
	document.getElementById("findPwBtn").addEventListener('click', findPw);
});

function findPw(){
	var newId = document.getElementById('findId').value;
	
	if(newId != localStorage.getItem('signUpId')){
		alert("존재하지 않는 아이디 입니다.");
		return;
	}

	var name = document.getElementById('findName').value;
	var phone = document.getElementById('findPhone').value;
	
	if(name == localStorage.getItem('signUpName') && phone == localStorage.getItem('signUpPhone')){
		var pw = localStorage.getItem('signUpPw');
		alert("비밀번호는 ["+ pw +"] 입니다.");
		self.close();
        opener.location.reload();
	}
	else{
		alert("입력하신 정보가 잘못 되었습니다.");
	}
}