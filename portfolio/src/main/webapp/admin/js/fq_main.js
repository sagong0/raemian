document.addEventListener("DOMContentLoaded",function(){
	var questions = document.querySelectorAll(".ques");
	
	questions.forEach((que,qindex)=>{
		
		que.addEventListener("click",()=>{
			var answers = document.querySelectorAll(".answer");
			answers.forEach((ans, aindex)=>{
				if(qindex == aindex){
					ans.style.display = "flex";
				}
				else{
					ans.style.display = "none";
				}
			});
		});
		
	});
});




/* 검색 PART */
document.querySelector("#searchBtn").addEventListener("click",()=>{
	var form = document.getElementById("searchForm");
	if(form.searchVal.value==""){
		alert("검색어를 입력해주세요.");
	}
	else{
		form.submit();
	}
});

/*삭제 PART */
//"정말로 삭제하시겠습니까? \n 단, 삭제시 해당 내용은 복구 되지 않습니다.!"
function del_faq(idx){
	let url = "./del_faq.do";
	
	if(confirm("정말로 삭제하시겠습니까? \n 단, 삭제시 해당 내용은 복구 되지 않습니다.")){
		fetch(url,{
		method :"POST",
		cache : "no-cache",
		headers : {
			"Content-Type": "application/x-www-form-urlencoded"
		},
		body: "fidx="+idx
		})
		.then((aa)=>{
			return aa.text();
		})
		.then((res)=>{
			//console.log(res);
			if(res=="success"){
				alert('정상적으로 삭제되었습니다.');
				location.href="./faq_main.do";
			}
			else{
				alert("오류로 인하여 삭제에 실패하였습니다.");
				history.go(-1);
			}
		})
		.catch((e)=>{
			console.log("삭제 요청 ERR");
			console.log(e);
		});	
	}
}


/* Faq 등록 클릭 시  */
function regit_faq(){
	location.href="./faq_write.do";
}

/*페이지 이동 */
function movePage(pageNo){
	location.href="./faq_main.do?fidx="+pageNo;
};


