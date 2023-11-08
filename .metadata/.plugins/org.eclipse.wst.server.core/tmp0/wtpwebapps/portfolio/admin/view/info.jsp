<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%
Date infoday = new Date();
DateFormat infoFormat = new SimpleDateFormat("yyyyMMddhms");
String ifdates = infoFormat.format(infoday);
%>    
<!-- 환경설정 관리 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">환경설정 관리</div>
    <div class="procho">
    <form id="SearchF" method="post" action="./info_main.do">
       <section class="search_part">
        <ol>
        <li>세대정보 검색</li>
        <li>
        <input type="text" name="searchVal" id="sdate2" class="search_input">
        <input type="button" id="searchBtn" value="검색" class="datebtn">
        </li>        
        <li></li>
        <li></li> 
        </ol>
       </section>
      </form> 
       <section class="data_listsview">
       <ul>
        <li>번호</li>
        <li>세대타입 및 면적</li>
        <li>사용 유/무</li>
        <li>출력순서</li>
        <li>글쓴이</li>
        <li>등록일</li>
        <li>삭제</li>
       </ul>
       
       <app:forEach var="item" items="${infos}" varStatus="info">
	       <ul style="height:140px;">
       			<li>${ea-info.index}</li>
		        <li style="text-align: left; justify-content: flex-start;">
		        <div class="info_img">
		        	<img src="${item.aimgUrl}">   
		        </div>
		        <div class="info_text">
			        <span>주거타입 : ${item.atype}</span>
			        <span>주거전용 : ${item.aprivate}</span>
			        <span>주거공용 : ${item.apublic}</span>
			        <span>기타공용 : ${item.aetcpublic}</span>
			        <span>계약면적 : ${item.acontractSize}</span>
		        </div>
		        </li>
		        <li>${item.ause}</li>
		        <li>${item.aorder}</li>
		        <li>관리자</li>
		        <li>${item.aindate.substring(0,10)}</li>
		        <li>
		            <input type="button" value="삭제" class="delbtn">
		        </li>
	       </ul>
       </app:forEach>
       <app:if test="${empty infos}">
	       <ul class="nodatas">
	       	<li>등록된 세대타입 내용이 없습니다.</li>
	       </ul>
       </app:if>
       <span class="notice_btns">
       <input type="button" value="세대타입 생성" id="writeBtn" class="meno_btn2"></span>
       <aside>
        <div class="page_number">
           <ul>
           <li>1</li>
           </ul>
        </div>
       </aside>
       </section>
    </div>
</div> 
</section>
</main>
<!-- 공지사항 관리 끝 -->
<script src="../js/info.js?<%=ifdates%>"></script>

