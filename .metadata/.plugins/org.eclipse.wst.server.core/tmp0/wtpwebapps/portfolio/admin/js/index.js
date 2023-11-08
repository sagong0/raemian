/*관리자 login */
function ad_login(){
	if(member_log.login_id.value==""){
		alert("관리자 아이디를 입력해주세요.");
		return false;
	}
	else if(member_log.login_pass.value==""){
		alert("관리자 비밀번호를 입력해주세요.");
		return false;
	}
	else if(member_log.login_id.value.length < 5){
			alert("5글자 이상의 아이디를 입력해주세요.");
			return false;
	}
	else if(member_log.login_pass.value.length < 5){
			alert("5글자 이상의 패스워드를 입력해주세요.");
			return false;
	}
	else{
		return;
	}
}

