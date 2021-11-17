$(document).ready(function () {
	var container = document.getElementById('map');
	var locPosition = new kakao.maps.LatLng(37.5012743, 127.039585); // (멀티캠퍼스)
    var options = { //지도를 생성할 때 필요한 기본 옵션
        center: locPosition, //지도의 중심좌표. 
        level: 3 //지도의 레벨(확대, 축소 정도)
    };
    
    var map = new kakao.maps.Map(container, options);
    var marker = new kakao.maps.Marker({
    	position: locPosition
    });
    marker.setMap(map);

	document.getElementById("inquire").addEventListener('click', inquire);
});

function inquire(){
	var r = document.getElementById('regions');
	var region = r.options[r.selectedIndex].value;
	var c = document.getElementById('cities');
	var city = c.options[c.selectedIndex].value;
	var t = document.getElementById('towns');
	var town = t.options[t.selectedIndex].value;
	
	localStorage.setItem('region',region);
	localStorage.setItem('city',city);
	localStorage.setItem('town',town);
	
	location.href = "page/inquireHouse.html";
}