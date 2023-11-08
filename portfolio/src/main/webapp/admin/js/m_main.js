document.querySelector("#searchBtn").addEventListener("click",function(){
	let sForm = document.getElementById("searchF");
	if(sForm.search_type == ""){
		alert("검색 카테고리를 선택해주세요.");
	}
	else{
		sForm.submit();
	}
});

/* 삭제 PART */
function delUser(idx){
	if(confirm('해당 사용자를 탈퇴시키겠습니까? ,\n 단, 삭제된 데이터는 복구 불가능합니다.')){
		location.href="./delete_user.do?idx="+idx;
	}
	
}

/*페이지 이동 */
function movePage(pageNo){
	location.href="./member_main.do?pageNo="+pageNo;
}