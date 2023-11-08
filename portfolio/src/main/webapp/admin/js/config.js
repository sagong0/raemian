function member_search(){
	if(adminForm.aarea.value==""){
		alert("소속 지역을 선택해주세요.");
		return false;
	}
	else if(adminForm.search_type.value ==""){
		alert("검색 형태를 선택해주세요.");
		return false;
	}
	else if(adminForm.search_val.value ==""){
		alert("검색어를 입력해주세요.");
		return false;
	}
	else{
		adminForm.submit();
	}
}




/*소속 AJAX 파트 */
var selectTag = document.getElementById("aarea");
//var data = sessionStorage.getItem("area");

selectTag.addEventListener("change", function () {
  sessionStorage.setItem("area",selectTag.value);
  //var area = selectTag.value;
  var area = sessionStorage.getItem("area");
  console.log(area);
  // AJAX 요청
  var http = new XMLHttpRequest();
  http.open("GET", "./config_main.do?aarea=" + area, false);
  http.onreadystatechange = function () {
    if (http.readyState === 4 && http.status === 200) {
      var response = http.responseText;
      
      //console.log(responseData);
      location.href="./config_main.do?aarea="+area;
    }
  };
  http.send();
});

/* 소속 AJAX후 소속 selected 자동 업데이트되게*/
var url = new URLSearchParams(window.location.search);
var current_area = url.get("aarea");
if(selectTag){
	for(var i = 0; i<selectTag.options.length; i++){
		if(selectTag.options[i].value == current_area){
			selectTag.selectedIndex = i;
			break;
		}
	}	
}




/* 전체 버튼 클릭 PART */
function toMain(){
	location.href="./config_main.do";
}


/* 근무중/퇴직중 AJAX PART */
function update_status(aidx){
	var statusSelect = document.getElementById("status"+aidx);
	var status = statusSelect.value;
	
	// AJAX 통신
	fetch("./modifyStatus.do",{
		method:"POST",
		cache: "no-cache",
		headers:{
			"Content-Type": "application/x-www-form-urlencoded"
		},
		body: "aidx="+aidx+"&status="+status
	})
	.then((res) => {
		console.log(res);
		if (res.ok) {
            // 성공 시 관리자 목록 페이지로 리다이렉트
            alert("적용 되었습니다.");
            location.href="./config_main.do";
        } 
        else {
            console.log("에러 발생: " + res.statusText);
            history.go(-1);
        }
	})
	.catch((e)=>{
		console.log("근무중 퇴직중 PART 통신 에러")
		console.log(e);
	});
}



/* 페이지 이동 */
function goPage(pno){
	location.href="./config_main.do?no="+pno;
}













