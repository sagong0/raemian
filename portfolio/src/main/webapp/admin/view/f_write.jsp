<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date fdate = new Date();
DateFormat fwrsf = new SimpleDateFormat("yyyyMMddhms");
String fwsrfs = fwrsf.format(fdate);
%>    
<!-- FAQ 등록 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">FAQ 등록</div>
    <form id="fWriteForm" method="post" action="./faq_writeok.do">
	    <div class="procho">
	       <section class="data_listsview">
	       <ol>
	       <li>질문 제목</li>
	       <li><input type="text" name="fquestion" class="notice_in in1"></li>
	       <li>글쓴이</li>
	       <li><input type="text" id="fwriter" name="fwriter" class="notice_in in2" readonly></li> <li style="height:520px;">질문 내용</li>
	       <li style="height:520px; padding-top: 10px;">
	       <textarea id="editor2" class="notice_in in3" name="fanswer"></textarea>
	       </li>      
	       </ol>
	       <span class="notice_btns">
	       <input type="button" value="FAQ 등록" id="writeBtn" class="meno_btn2"></span>
	       </section>
	    </div>
    </form>
</div> 
</section>
</main>
<!-- FAQ 등록 끝 -->
<script>
/*글쓴이 readOnly 값 자동저장 */
window.addEventListener('DOMContentLoaded', function() {
    var loggedInUsername = '<%=session.getAttribute("name") %>';
    var writerInput = document.querySelector('#fwriter');
    //console.log(loggedInUsername);
    writerInput.value = loggedInUsername;
});
CKEDITOR.replace("editor2");
</script>
<script src=../js/f_write.js?v=<%=fwsrfs %>></script>
