$(document).ready(function () {
	document.getElementById("idInfo").value = localStorage.getItem("signUpId");
	document.getElementById("pwInfo").value = localStorage.getItem("signUpPw");
	document.getElementById("nameInfo").value = localStorage.getItem("signUpName");
	document.getElementById("addrInfo").value = localStorage.getItem("signUpAddr");
	document.getElementById("phoneInfo").value = localStorage.getItem("signUpPhone");
	
	document.getElementById("fixBtn").addEventListener('click', fixInfo);
	document.getElementById("deleteBtn").addEventListener('click', deleteInfo);
});

function fixInfo() {
	localStorage.setItem("signUpId",document.getElementById("idInfo").value);
	localStorage.setItem("signUpPw",document.getElementById("pwInfo").value);
	localStorage.setItem("signUpName",document.getElementById("nameInfo").value);
	localStorage.setItem("signUpAddr",document.getElementById("addrInfo").value);
	localStorage.setItem("signUpPhone",document.getElementById("phoneInfo").value);
	
	alert("수정 완료");
	location.reload();
}

function deleteInfo() {
	localStorage.removeItem('id');
    localStorage.removeItem('pw');
    
	localStorage.removeItem("signUpId");
	localStorage.removeItem("signUpPw");
	localStorage.removeItem("signUpName");
	localStorage.removeItem("signUpAddr");
	localStorage.removeItem("signUpPhone");
	
	alert("삭제 완료");
	
	var href = window.location.href;
	location.href = "../index.html";
}