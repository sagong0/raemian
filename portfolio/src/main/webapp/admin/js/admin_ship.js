
/* 전화번호 합치는 PART */
function tell_value(){
	admin_reg.atel.value = admin_reg.atel1.value + admin_reg.atel2.value + admin_reg.atel3.value;
}


function regit(){	
	// Email 정규식 
	var eamil_regex = /[a-zA-z0-9._-]+@[a-zA-Z0-9]+[.]+[a-zA-Z]/;
	var name_regex = /\d/;
	if(admin_reg.aarea.value==""){
		alert("소속 지역을 선택해주세요.");
	}
	else if(admin_reg.adept.value==""){
		alert("부서를 선택해주세요.");
	}
	else if(admin_reg.aname.value=="" || name_regex.test(admin_reg.aname.value)){
		alert("관리자 성함을 입력해주세요");
	}
	else if(admin_reg.aposition.value==""){
		alert("관리자 직책을 입력해주세요");
	}
	else if(admin_reg.aid.value==""){
		alert("사용하실 아이디를 입력해주세요");
	}
	else if(admin_reg.aid.value.length < 5){
		alert("5자 이상의 아이디를 사용해주세요");
	}
	else if(admin_reg.apw.value==""){
		alert("사용하실 패스워드를 입력해주세요.");
	}
	else if(admin_reg.apw.value.length < 5){
		alert("5자리 이상의 패스워드를 사용해주세요.");
	}
	else if(admin_reg.apw.value != admin_reg.apw2.value){
		alert("패스워드확인이 일치 하지 않습니다.");
	}
	else if(admin_reg.aid.value==""){
		alert("사용하실 아이디를 입력해주세요");
	}
	else if(admin_reg.aemail.value==""){
		alert("사용하실 이메일을 입력해주세요");
	}
	// 전화번호 정규식 check
	else if(admin_reg.atel.value==""){
		alert("전화번호를 입력해주세요.");
	}
	else if(admin_reg.atel.value.length < 10){
		alert("전화번호를 확인 해주세요.");
	}
	else{
		if(!eamil_regex.test(admin_reg.aemail.value)){
			alert("올바른 이메일 형식을 사용해주세요.");
		}
		else{
			admin_reg.submit();
		}
	}
}



/* ID 중복 체크 */
function idck(e){
	e.preventDefault();
	
	var id = document.getElementById("aid");
	if(id.value==""){
		alert("아이디를 확인하세요.");
	}
	else{
		var http = new XMLHttpRequest();
		http.onreadystatechange = function(){
			if(http.readyState == XMLHttpRequest.DONE && http.status==200){
				var result = this.response;
				if(result =="ok"){
					alert("사용가능한 아이디입니다.");
					id.readOnly = "readOnly";
				}
				else if(result =="no"){
					alert("이미 사용중인 아이디입니다.");
				}
			}
		}
		
		http.open("post","./idck.do",true);
		http.setRequestHeader("content-type","application/x-www-form-urlencoded");
		http.send("id="+id.value);
	}
}


/*뒤로가기 */
function goBack(){
	location.href="./index.jsp"
}





