<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
Date rmdt = new Date();
DateFormat rmsf = new SimpleDateFormat("yyyyMMddhms");
String rmdes = rmsf.format(rmdt);
%>
<!-- 회원관리 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">사전예약 회원 관리</div>
    <div class="procho">
       <section class="search_part">
        <ol >
        <li>회원 검색</li>
        <li>
	        <select class="search_select" id="searchType">
        	<app:if test="${not empty sdto}">
	        	<app:choose>
	        		<app:when test="${sdto.search_type eq '아이디'}">
	        			<app:set var="idselected" value="selected"/>
	        		</app:when>
	        		<app:when test="${sdto.search_type eq '이름'}">
	        			<app:set var="nmselected" value="selected" />
	        		</app:when>
	        		<app:when test="${sdto.search_type eq '연락처'}">
	        			<app:set var="telselected" value="selected"/>
	        		</app:when>
	       		</app:choose>
	        </app:if>    
        	<app:set var="searchType" value="${sdto.search_type}"/>
		        <option ${idselected}>아이디</option>    
		        <option ${nmselected}>이름</option>    
		        <option ${telselected}>연락처</option>
	        </select>
	        <input type="text" id="sdate2" name="searchVal" class="search_input">
	        <input type="button" value="검색" id="schBtn" class="datebtn">
        </li>        
        <li></li>
        <li></li> 
        </ol>
       </section> 
       <section class="reserve_listsview">
       <ul>
        <li>번호</li>
        <li>아이디</li>
        <li>고객명</li>
        <li>연락처</li>
        <li>예약일자</li>
        <li>예약시간</li>
        <li>인원수</li>
        <li>예약취소</li>
       </ul>
       
       <app:forEach var="rdto" items="${rdtos}" varStatus="current">
       <ul>
        <li>${current.index + 1}</li>
        <li>${rdto.rid}</li>
        <li>${rdto.rname}</li>
        <li>${rdto.rtel}</li>
        <li>${rdto.rdate}</li>
        <li>${rdto.rtime}</li>
        <li>${rdto.rcount}</li>    
        <li>
            <input type="button" onclick="del_res(${rdto.ridx});" value="취소" class="delbtn">
        </li>
       </ul>
       </app:forEach>
       
       <app:if test="${rdtos.size() eq 0 }">
       <ul class="nodatas">
        <li>사전예약 신청 회원이 없습니다.</li>
       </ul>
       </app:if>
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
<!-- 회원관리 끝 -->

<script src="../js/res_main.js?v=<%=rmdes%>"></script>
