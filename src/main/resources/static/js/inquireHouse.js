$(document).ready(function () {
	var container = document.getElementById('map');
	var locPosition = new kakao.maps.LatLng(37.5012743, 127.039585); // (멀티캠퍼스)
    var options = { //지도를 생성할 때 필요한 기본 옵션
        center: locPosition, //지도의 중심좌표. 
        level: 3 //지도의 레벨(확대, 축소 정도)
    };
    
	var map = new kakao.maps.Map(container, options);
	
	search('', -1);
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
	
	$('#data-container').empty();
	search('', -1);
}

function search(name, num) {
    var serviceKey = 'hJ1Vsq+Izj1YBbzYDCoDSn4rAouIOSsaEUgkOu6WzpfGPZA29VnLVmkgZwU2RuRxIC36Zug3Vw1FkxvlP3EJfg=='; //url decoder
    var LAWD_CD = '0';
    
    if(localStorage.getItem('city') == '종로구'){
    	LAWD_CD = '11110';
    }
    
    var DEAL_YMD = '202101';
    //var pageNo = '1';
    var numOfRows = '30';
    // server에서 넘어온 data
    $.ajax({
        url: 'http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev',
        type: 'GET',
        dataType: 'xml',
        data: {
            "serviceKey":serviceKey,
            "LAWD_CD":LAWD_CD,
            "DEAL_YMD":DEAL_YMD,
            //"pageNo":pageNo,
            "numOfRows":numOfRows},
        success: function (response) {
        	console.log(response);
            makeList(response, name, num);
        },
        error: function (xhr, status, msg) {
        console.log('상태값 : ' + status + ' Http에러메시지 : ' + msg);
        },
    });
}

function makeList(data, name, num) {
    var aptList = [];
    var town = localStorage.getItem('town');
    
    $(data).find('item').each(function () {
    	switch(num){
    		case -1:
    			if(town != ''){
    	    		if(town == $(this).find('법정동').text()){
    	        		var apt = [$(this).find('아파트').text(), $(this).find('법정동').text(), 
    	        	        $(this).find('전용면적').text(), $(this).find('거래금액').text()];
    	        	    	
    	        	    aptList.push(apt);
    	    		}
    	    		else {
    	    			return;
    	    		}
    	    	}
    			var apt = [$(this).find('아파트').text(), $(this).find('법정동').text(), 
        	        $(this).find('전용면적').text(), $(this).find('거래금액').text()];
        	    	
        	    aptList.push(apt);
        	    
    			break;
    		case 0:
    			if(name == $(this).find('아파트').text()){
    	    		console.log(num);
    	        	console.log(name);
    	    		var apt = [$(this).find('아파트').text(), $(this).find('법정동').text(), 
    	            	$(this).find('전용면적').text(), $(this).find('거래금액').text()];
    	    		
    	    		aptList.push(apt);
    	    	}
    			break;
    		case 1:
    			if(name == $(this).find('법정동').text()) {
    	    		console.log(num);
    	        	console.log(name);
    	    		var apt = [$(this).find('아파트').text(), $(this).find('법정동').text(), 
    	    	        $(this).find('전용면적').text(), $(this).find('거래금액').text()];
    	    		
    	    		aptList.push(apt);
    	    	}
    			break;
    	}
    });
    
    console.log(aptList);
    
    $('#pg').pagination({
	    dataSource: aptList,
	    pageSize: 4,
	    callback: function(data, pagination) {
	    	var dataHtml = '<ul>';
	    	
            $.each(data, function (index, item) {
            	dataHtml += '<li>'+'<div>'+
                   	'<div onclick="markMap(\''+item[0]+'\', 0)">'+'<h5>'+ item[0] +'</h5>'+'</div>'+
                   	'동: ' + '<span onclick="markMap(\''+item[1]+'\', 1)">'+ item[1] +'</span>'+
                   	'<br>면적: '+ item[2] +
                   	'<br>거래금액: '+ item[3] +
                   	'</div>'+'</li>';
            });

            dataHtml += '</ul>';
            
            $('#data-container').html(dataHtml);
	    }
	});
}

function markMap(place, num){
	$('#data-container').empty();
	search(place,num);
	//var ps = new kakao.maps.services.Places();	
	//ps.keywordSearch(place, placesSearchCB); 
}

//키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();

        for (var i=0; i<data.length; i++) {
            displayMarker(data[i]);    
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
        }       

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        map.setBounds(bounds);
    } 
}

// 지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });

    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(map, marker);
    });
}