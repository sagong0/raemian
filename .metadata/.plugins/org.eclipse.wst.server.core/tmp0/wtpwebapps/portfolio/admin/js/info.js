/* 생성 버튼 Click */
document.querySelector("#writeBtn").addEventListener("click",()=>{
	location.href="./info_write.do";
});

/* 검색 PART */
document.querySelector("#searchBtn").addEventListener("click",()=>{
	let form = document.querySelector("#SearchF");
	let searchVal = form.searchVal.value;
	
	form.submit();
});