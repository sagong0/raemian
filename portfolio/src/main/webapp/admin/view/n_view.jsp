<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="portfolio.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date t102 = new Date();
DateFormat d2f = new SimpleDateFormat("yyyyMMddhms");
String d2ts = d2f.format(t102);

NoticeDto ndto =(NoticeDto) request.getAttribute("ndto");
%>    
<!-- 공지사항 내용확인 시작 -->    
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">공지사항 확인</div>
    <div class="procho">
       <section class="data_listsview">
       <ol>
       <li>공지제목</li>
       <li class="text_in"><%=ndto.getNtitle()%></li>
       <li>글쓴이</li>
       <li class="text_in"><%=ndto.getNwriter()%></li> 
       <li style="height:520px;">내용</li>
       <li style="height:520px; padding-top: 10px;">
       <div class="text_in2"><%=ndto.getNcontent()%></div>
       </li>       
       <li>첨부파일</li>
       <li class="text_in" <%
       if(ndto.getNfile()!= null){
       %>onclick="down_file('<%=ndto.getNfile()%>')"
       <%} %>
        style="cursor: pointer;"><%=ndto.getNfile()==null ? "" : ndto.getNfile()%></li>   
       </ol>
       <span class="notice_btns">
       <input type="button" value="목록" class="meno_btn2" onclick="goNoticeList();"></span>
       </section>
    </div>
</div> 
</section>
</main>
<!-- 공지사항 내용확인 끝 -->
<script src="../js/n_view.js?v=<%=d2ts%>"></script>