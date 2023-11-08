document.querySelector("#writeBtn").addEventListener("click",function(){
	
	let editor = CKEDITOR.instances.editor2;
	let nanswer = editor.getData();
	
	let form = document.getElementById("fWriteForm");
	
	if(form.fquestion.value == ""){
		alert("제목을 입력해주세요.");
	}
	else if(form.fwriter.value == ""){
		alert("작성자를 입력해주세요.");
	}
	else if(nanswer.trim()==""){
		alert("질문 내용을 입력해주세요.");
	}
	else{
		form.submit();
	}
});