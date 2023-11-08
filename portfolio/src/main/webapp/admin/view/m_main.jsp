<%@page import="portfolio.SearchDTO"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
Date m_mdt = new Date();
DateFormat m_msf = new SimpleDateFormat("yyyyMMddhms");
String m_mdts = m_msf.format(m_mdt);

SearchDTO sdto = (SearchDTO)request.getAttribute("sdto");
int ea = (int)request.getAttribute("ea");
%>      
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">회원 관리</div>
    <div class="procho">
       <section class="search_part">
        <ol>
	        <li>회원 검색</li>
	        <li>
	        <form id="searchF" method="post" action="./member_main.do">
	        <select name="search_type" class="search_select">
	        <app:set var="nmSelected" value=""/>
			<app:set var="telSelected" value=""/>
			<app:set var="idSelected" value=""/>
			<app:if test="${not empty sdto}">
			    <app:choose>
			        <app:when test="${sdto.search_type eq '이름'}">
			            <app:set var="nmSelected" value="selected"/>
			        </app:when>
			        <app:when test="${sdto.search_type eq '연락처'}">
			            <app:set var="telSelected" value="selected"/>
			        </app:when>
			        <app:when test="${sdto.search_type eq '아이디'}">
			            <app:set var="idSelected" value="selected"/>
			        </app:when>
			    </app:choose>
			</app:if>
			        <option ${idSelected}>아이디</option>    
			        <option ${nmSelected}>이름</option>    
			        <option ${telSelected}>연락처</option>    
		        </select>
		        <input type="text" name="search_val" id="sdate2" class="search_input">
		        <input type="button" id="searchBtn" value="검색" class="datebtn">
	        </form>
	        </li>        
	        <li></li>
	        <li></li> 
        </ol>
       </section> 
       <section class="member_listsview">
       <ul>
        <li>번호</li>
        <li>아이디</li>
        <li>고객명</li>
        <li>연락처</li>
        <li>이메일</li>
        <li>주소</li>
        <li>이메일</li>
        <li>전화</li>
        <li>우편물</li>
        <li>SMS</li>
        <li>삭제</li>
       </ul>
       
       <app:choose>
       <app:when test="${not empty users}">
       <app:forEach var="user" items="${users}" varStatus="loopStatus" begin="0">
       <ul>
        <li><app:out value="${loopStatus.index+1}" /></li>
        <li>${user.mid}</li>
        <li>${user.mname}</li>
        <li>${user.mtel}</li>
        <li>${user.memail}</li>
        <li style="justify-content: flex-start;">(${user.mzipcode}) ${user.mstreetaddr}</li>
        <li>${user.ckemail}</li>   
        <li>${user.cktel}</li>  
        <li>${user.ckaddr}</li>   
        <li>${user.cksms}</li>   
        <li>
            <input type="button" onclick="delUser(${user.midx});" value="삭제" class="delbtn">
        </li>
       </ul>
       </app:forEach>
       </app:when>
       <app:otherwise>
	       <ul class="nodatas">
	        <li>등록된 회원이 없습니다.</li>
	       </ul>
       </app:otherwise>
       </app:choose>
       <aside>
       <%
       int pg = (int) Math.ceil(ea/20f);
       %>
        <div class="page_number">
           <ul>
           <app:set var="pg" value="<%=pg%>" />
           <app:set var="w" value="1"/>
           <app:forEach begin="1" end="${pg}" step="1" var="w">
           <li onclick="movePage(${w});">${w}</li>
           </app:forEach>
           </ul>
        </div>
       </aside>
       </section>
    </div>
</div> 
</section>
</main>
<script src="../js/m_main.js?v=<%=m_mdts%>"></script>