
/**삭제 AJAX */
function del_res(ridx){
	let url = "../../main/del_reserve.do";
	
	if(confirm("사전예약 회원 취소 하시겠습니까? 데이터는 복구 되지 않습니다.")){
		fetch(url,{
		method :"POST",
		cache : "no-cache",
		headers : {
			"Content-Type": "application/x-www-form-urlencoded"
		},
		body: "ridx="+ridx
		})
		.then((aa)=>{
			return aa.text();
		})
		.then((res)=>{
			if(res == "success"){
				alert("해당 유저의 사전예약이 취소되었습니다.");
				location.href='./reserve_main.do';
			}
			else{
				alert("네트워크 오류로 인하여 요청이 취소되었습니다.");
			}
		})
		.catch((e)=>{
			console.log("삭제 요청 ERR");
			console.log(e);
		});	
	}
}

/*검색 PART */
document.querySelector("#schBtn").addEventListener("click",()=>{
	let searchType = document.getElementById("searchType").value;
	let searchVal = document.getElementById("sdate2").value;

	if(searchType == ""){
		alert("검색 유형을 확인해주세요.");
	}
	else if(searchVal ==""){
		alert("검색 내용을 입력해주세요.");
	}
	else{
		location.href="./reserve_main.do?search_type="+searchType+"&search_val="+searchVal;		
	}
});











