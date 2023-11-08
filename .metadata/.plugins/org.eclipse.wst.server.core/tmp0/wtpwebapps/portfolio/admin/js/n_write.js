function regit(){
	var editor = CKEDITOR.instances.editor1;
	var ncontent = editor.getData();
	
	if(regitForm.ntitle.value==""){
		alert("공지제목을 입력해주세요.");
		return false;
	}
	else if(regitForm.nwriter.value==""){
		alert("작성자 이름을 입력해주세요.");		
	}
	else if(ncontent.trim()==""){
		alert("내용을 입력해주세요.");		
	}
	else if(regitForm.mfile.files.length > 0){
		// 파일 첨부가 있을 경우
		
		var allowedFileType = ["jpg","gif","bmp", "png"];
		
		var fileSize = regitForm.mfile.files[0].size;
		var fileName = regitForm.mfile.files[0].name;
		var fileType = fileName.split(".")[1];
		
		var maxSize = 2 * 1024 * 1024;
		
		if(fileSize > maxSize){
			alert("파일 첨부는 최대 2MB 까지 가능합니다.");
		}
		else if(allowedFileType.indexOf(fileType) == -1){
			alert("이미지 파일만 첨부 가능합니다.");
			return false;
		}
		else{
			regitForm.submit();
		}
	}
	else{
		regitForm.submit();
	}
}
