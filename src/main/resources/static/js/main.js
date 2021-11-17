$(document).ready(function () {
	document.getElementById("loginBtn").addEventListener('click', login);
	document.getElementById("logoutBtn").addEventListener('click', logout);
	document.getElementById("findPwBtn").addEventListener('click', openFindPw);
	
	change_nav_bar();
});

function change_nav_bar(){
    if(localStorage.getItem("id") == null){
        document.getElementById('loggedin').style.display='none';
        document.getElementById('loggedout').style.display='';
    } else {
        document.getElementById('loggedin').style.display='';
        document.getElementById('loggedout').style.display='none';
    }
}

function login() {
    var userId = document.getElementById('id').value;
    var userPw = document.getElementById('pw').value;
    
    if(userId == localStorage.getItem('signUpId') && userPw == localStorage.getItem('signUpPw')){
    	alert('로그인 성공!');
    	localStorage.setItem('id', userId);
    	localStorage.setItem('pw', userPw)
    	change_nav_bar();
    } else{
        alert('로그인 실패!');
    }
}

function logout() {
	document.getElementById('id').value = '';
	document.getElementById('pw').value = '';
	localStorage.removeItem('id');
    localStorage.removeItem('pw');
    change_nav_bar();
}

function openFindPw() {
	var href = window.location.href;
	
	if(href.includes('/page/')){
		window.open("findPw.html","fp","width=500, height=400, left=300");
	}
	else{
		window.open("page/findPw.html","fp","width=500, height=400, left=300");
	}
}