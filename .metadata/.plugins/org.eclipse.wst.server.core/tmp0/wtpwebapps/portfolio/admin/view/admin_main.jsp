<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date today = new Date();
DateFormat df = new SimpleDateFormat("yyyyMMddhms");
String dates = df.format(today);

String userid =(String) session.getAttribute("name");

if(userid==null || !userid.equals(userid)){
	out.println("<script>alert('잘못된 접근 방식입니다.'); location.href='./index.jsp';</script>");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/admin_css.css?v=<%=dates%>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<title>관리자 페이지</title>
</head>
<body>
<!-- ad_menu.jsp PART-->
<%@ include file="./ad_menu.jsp" %>
<!-- ad_menu.jsp PART END-->
<main>
<section>
   <div class="ad_top" ></div>
   
 <div class="ad_mainall">
   <%@ include file="./general_membership.jsp"%>
   <%@ include file="./question.jsp" %>
   <%@ include file="./reservation.jsp" %>
 </div>

   <div class="ad_botom"></div>
</section>
</main>
<%@ include file="./ad_copy.jsp" %>
<script src="../js/menus.js?v=<%=dates%>"></script>
</body>
</html>