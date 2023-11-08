<%@page import="portfolio.FaQdto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date dday = new Date();
DateFormat as = new SimpleDateFormat("yyyyMMddhms");
String dsa = as.format(dday);

List<FaQdto> fdto = (List<FaQdto>)request.getAttribute("fdto");
int total = (int)request.getAttribute("total");
%>
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!-- FAQ 리스트 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">FAQ 관리</div>
    <div class="procho">
	   <form id="searchForm" method="post" action="./faq_main.do">
	       <section class="search_part">
	        <ol>
	        <li>FAQ내용 검색</li>
	        <li>
	        <input type="text" class="search_input" id="searchVal" name="searchVal">
	        <input type="button" value="검색" class="datebtn" id="searchBtn">
	        </li>        
	        <li></li>
	        <li></li> 
	        </ol>
       </section> 
	   </form>
       <section class="data_listsview2">
       <ul>
        <li>QA</li>
        <li>질문/답변</li>
        <li>글쓴이</li>
        <li>등록일</li>
        <li>삭제</li>
       </ul>
          
<!-- FAQ 샘플 HTML 코드 시작 -->           
     <span id="faq_span">
     
     <app:forEach var="item" items="${fdto}">
       <ul class="node ques">
        <li>Q</li>
        <li style="text-align: left; justify-content: flex-start;">${item.getFquestion()}</li>
        <li>관리자</li>
        <li>${item.getFindate().substring(0,10)}</li>
        <li>
        <input type="button" value="삭제" class="delbtn" id="delBtn${item.getFidx()}" onclick="del_faq(${item.getFidx()})">
        </li>
       </ul>
      <!-- display:none 또는 display:flex 로 해야합니다. -->
       <ol class="answer" style="display: none;">
        <li>A</li>
        <li style="text-align: left; justify-content: flex-start;">${item.getFanswer()}</li>
       </ol> 
       </app:forEach>
     </span>
<!-- FAQ 샘플 HTML 코드 끝 -->
       <app:if test="${empty fdto}">
	       <ul class="nodatas">
	        <li>등록된 FAQ 내용 없습니다.</li>
	       </ul>
       </app:if>
       <span class="notice_btns">
       <input type="button" value="FAQ 등록" onclick="regit_faq()" class="meno_btn2"></span>
       <aside>
        <div class="page_number">
        <%
        int pg = (int) Math.ceil(total/10f);
        %>
           <ul>
           <app:set var="pg" value="<%=pg %>"></app:set>
           <app:set var="ww" value="1"></app:set>
           
           <app:forEach begin="1" end="${pg}" step="1" var="ww">
           <li onclick="movePage(${ww});"><a href="./faq_main.do?fidx=${ww}">${ww}</a></li>
           </app:forEach>
           </ul>
        </div>
       </aside>
       </section>
    </div>
</div> 
</section>
</main>
<!-- FAQ 리스트 끝 -->
<script src="../js/fq_main.js?v=<%=dsa%>"></script>