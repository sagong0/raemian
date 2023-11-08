function goNoticeList(){
	location.href="./notice_main.do";
}

/* 첨부파일 다운로드 PART 
function down_file(no){
	//console.log(no);
	location.href="./notice_writeok.do?idx="+no;
}
*/
/* 바로 이미지 뜨게 */
function down_file(filePath){
	console.log(filePath);
	location.href=filePath;
}