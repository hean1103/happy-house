$(document).ready(function () {
	document.getElementById("signUpBtn").addEventListener('click', signUp);
});

function signUp(){
	var newId = document.getElementById('signUpId').value;
	
	if(newId == localStorage.getItem('signUpId')){
		alert("이미 존재하는 아이디 입니다.");
		return;
	}
	
	var newPw = document.getElementById('signUpPw').value;
	var newName = document.getElementById('signUpName').value;
	var newAddr = document.getElementById('signUpAddr').value;
	var newPhone = document.getElementById('signUpPhone').value;
	
	localStorage.setItem('signUpId', newId);
    localStorage.setItem('signUpPw', newPw);
    localStorage.setItem('signUpName', newName);
    localStorage.setItem('signUpAddr', newAddr);
	localStorage.setItem('signUpPhone', newPhone);
	    
    localStorage.setItem('id',newId);
    localStorage.setItem('pw',newPw);
	    
    alert("등록 성공!");

    var href = window.location.href;
    if(href.includes('/page/')){
		location.href = "../index.html";
	}
	else{
		location.href = "index.html";
	}
}