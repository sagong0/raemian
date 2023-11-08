document.querySelector("#enrollBtn").addEventListener("click",function(){
	var form = document.querySelector("#configForm");
	console.log(form.ause.value);
	if(form.atype.value==""){
		alert("주거 타입을 입력해주세요.");
	}
	else if(form.awriter.value==""){
		alert("글쓴이를 입력해주세요.");
	}
	else if(form.aprivate.value==""){
		alert("주거 전용을 입력해주세요.");
	}
	else if(isNaN(form.aprivate.value)){
		alert("주거 전용을 숫자를 입력해주세요.");
	}
	else if(form.apublic.value==""){
		alert("주거 공용을 입력해주세요.");
	}
	else if(isNaN(form.apublic.value)){
		alert("주거 공용을 숫자를 입력해주세요.");
	}
	else if(form.aetcpublic.value==""){
		alert("기타 공용을 입력해주세요.");
	}
	else if(isNaN(form.aetcpublic.value)){
		alert("기타 공용을 숫자를 입력해주세요.");
	}
	else if(form.acontractSize.value==""){
		alert("계약면적을 입력해주세요.");
	}
	else if(isNaN(form.acontractSize.value)){
		alert("계약면적은 숫자로 입력해주세요.");
	}
	else if(form.aimgUrl.value==""){
		alert("이미지 URL을 입력해주세요.");
	}
	else if(form.ause.value==""){
		alert("사용 유/무를 선택해주세요.");
	}
	else if(form.aorder.value==""){
		alert("출력 순서를 입력해주세요.");
	}
	else if(isNaN(form.aorder.value)){
		alert("출력 순서는 숫자만 입력가능합니다.");
	}
	else{
		form.submit();
	}
});