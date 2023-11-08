<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date iwday = new Date();
DateFormat iwdf = new SimpleDateFormat("yyyyMMddhms");
String dddss = iwdf.format(iwday);
%>    
<!-- 세대정보 입력 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">환경설정 등록</div>
    <form id="configForm" method="post" action="./info_writeok.do">
	    <div class="procho">
	       <section class="data_listsview">
	       <ol>
		       <li>주거타입</li>
		       <li><input type="text" name="atype" class="notice_in in2"> ※ 예) 74A 타입</li>
		       <li>글쓴이</li>
		       <li><input type="text" id="awriter" name="awriter" class="notice_in in2" readonly></li>
		       <li>주거전용</li>
		       <li><input type="text" name="aprivate" class="notice_in in2">㎡&nbsp;&nbsp;&nbsp;※ 숫자만 입력하세요</li>
		       <li>주거공용</li>
		       <li><input type="text" name="apublic" class="notice_in in2">㎡&nbsp;&nbsp;&nbsp;※ 숫자만 입력하세요</li>
		       <li>기타공용</li>
		       <li><input type="text" name="aetcpublic" class="notice_in in2">㎡&nbsp;&nbsp;&nbsp;※ 숫자만 입력하세요</li>
		       <li>계약면적</li>
		       <li><input type="text" name="acontractSize" class="notice_in in2">㎡&nbsp;&nbsp;&nbsp;※ 숫자만 입력하세요</li>
		       <li>이미지 URL</li>
		       <!-- https://sagong0.cdn1.cafe24.com/type/84t.jpg -->
		       <li><input type="text" name="aimgUrl" class="notice_in in1">&nbsp;&nbsp;&nbsp;예시) http://abc.co.kr/123.jpg</li> 
		       <li>사용 유/무</li>
		       <li><input type="radio" name="ause" value="O" class="radio_txt" checked>사용함 <input type="radio" name="ause"value="X" class="radio_txt">사용안함</li>
		       <li>출력순서</li>
		       <li><input type="text" name="aorder" class="notice_in in2">&nbsp;&nbsp;&nbsp;※ 숫자만 입력하세요 단, 동일한 이름일 경우 데이터 등록된 순으로 출력 됩니다.</li>
	       </ol>
	       <span class="notice_btns">
	       <input type="button" id="enrollBtn" value="주거타입 등록" class="meno_btn2">
	       </span>
	       </section>
	    </div>
    </form>
</div> 
</section>
</main>
<!-- 세대정보 입력 끝 -->
<script>
window.addEventListener('DOMContentLoaded', function() {
    // 세션에서 로그인한 사용자명 가져오기
    var loggedInUsername = '<%=session.getAttribute("name") %>';
    var awriterInput = document.querySelector('#awriter');

    awriterInput.value = loggedInUsername;
});
</script>
<script src="../js/i_write.js?v=<%=dddss%>"></script>