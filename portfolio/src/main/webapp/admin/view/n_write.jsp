<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="portfolio.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date tt = new Date();
DateFormat sfsf = new SimpleDateFormat("yyyyMMddhms");
String dddd2 = sfsf.format(tt);

NoticeDto notice =(NoticeDto) request.getAttribute("notice");
%>
<!-- 공지사항 등록 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">공지사항 등록</div>
    <form id="regitForm" method="post" action="./notice_writeok.do" enctype="multipart/form-data">
	    <div class="procho">
	       <section class="data_listsview">
	       <ol>
	       <%if(notice == null) {%>
		       <li>공지제목</li>
			       <li><input type="text" name="ntitle" class="notice_in in1"></li>
			       <li>글쓴이</li>
			       <li><input type="text" id="nwriter" name="nwriter" class="notice_in in2" readonly></li>
			       <li style="height:520px;">내용</li>
			       <li style="height:520px; padding-top: 10px;">
			       <textarea id="editor1" name="ncontent" class="notice_in in3"></textarea>
			       </li>       
			       <li>첨부파일</li>
			       <li><input type="file" name="mfile"></li>
	       <% 
	       }
	       else{
	       %>
		       <li>공지제목</li>
		       <li><input type="text" name="ntitle" class="notice_in in1" value="<%=notice.getNtitle() != null ? notice.getNtitle() : ""%>"></li>
		       <li>글쓴이</li>
		       <li><input type="text" id="nwriter" name="nwriter" class="notice_in in2" readonly></li>
		       <li style="height:520px;">내용</li>
		       <li style="height:520px; padding-top: 10px;">
		       <textarea id="editor1" name="ncontent" class="notice_in in3 ckeditor"><%=notice.getNcontent() != null ? notice.getNcontent() : ""%></textarea>
		       </li>       
		       <li>첨부파일</li>
		       <li><input type="file" name="nfile"></li>
	       <%
	       }
	       %>   
	       </ol>
	       <span class="notice_btns">
	       <input type="button" value="글등록" class="meno_btn2" onclick="regit();">
	       </span>
	       </section>
	    </div>
    </form>
</div> 
</section>
</main>
<!-- 공지사항 등록 끝 -->
<script>
window.addEventListener('DOMContentLoaded', function() {
    // 세션에서 로그인한 사용자명 가져오기
    var loggedInUsername = '<%= session.getAttribute("name") %>';
    var nwriterInput = document.querySelector('#nwriter');

    nwriterInput.value = loggedInUsername;
});
CKEDITOR.replace('editor1');
</script>

<script src="../js/n_write.js?v=<%=dddd2%>"></script>