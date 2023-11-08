function getToWrite(){
	location.href="./notice_write.do"
}

/* 공지사항 삭제 */
function del_notice(idx){
	if(confirm("정말로 해당 게시물을 삭제 하시겠습니까?\n 단, 삭제시 데이터가 복구 되지 않습니다.")){
		location.href="./notice_del.do?idx="+idx;
	}
}

/* 공지사항 검색 PART */
document.querySelector("#searchBtn").addEventListener("click",function(){
	let searchform = document.querySelector("#searchForm");
	searchform.submit();	
});


/* 조회수 증가 AJAX */
function notice_detail(idx){
	
	const http = new XMLHttpRequest();
	http.open("GET",`./nCountUp.do?idx=${idx}`, true);
	http.onload = function(){
		if(http.status ===200){
			// AJAX 성공 
			location.href=`./notice_view.do?idx=${idx}`;
		}
	}
	http.send();
}

/*페이지 이동 */
function move_page(pageNo){
	location.href="./notice_main.do?no="+pageNo;
}