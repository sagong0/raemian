<%@page import="main.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
List<MemberDto> todayUsers = (List<MemberDto>) request.getAttribute("todayUsers");
%>    
<!DOCTYPE html>
<div class="ad_main">
	<div class="ad_main1">
	   <ul>
            <li class="ad_maintitle">일반회원</li>
            <li class="ad_mainbox">
            <ol>
                <li>아이디</li>
                <li>고객명</li>
                <li>연락처</li>
                <li>이메일</li>
                <li>주소</li>
            </ol>
            <c:forEach var="user" items="${todayUsers}" varStatus="current">
            <ol class="bgcancel">
                <li>${user.mid}</li>
                <li>${user.mname}</li>
                <li>${user.mtel}</li>
                <li>${user.memail}</li>
                <li style="text-align: left;">(${user.mzipcode}) ${user.mstreetaddr }</li>
            </ol>  
            </c:forEach>
            </li>
         </ul>
	</div>
</div>