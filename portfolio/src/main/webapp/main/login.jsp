<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date lgdt = new Date();
DateFormat lgdf = new SimpleDateFormat("yyyyMMddhms");
String lgdts = lgdf.format(lgdt);
%>            
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
<meta property="og:type" content="website">
<meta property="og:title" content="인천검단 레미안">
<title>인천검단 레미안</title>
<!-- css -->
<link rel="stylesheet" type="text/css" href="css/normalize.css?v=<%=lgdts%>">
<link rel="stylesheet" type="text/css" href="css/slick.css?v=<%=lgdts%>">
<link rel="stylesheet" type="text/css" href="css/swiper.min.css?v=<%=lgdts%>">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css?v=<%=lgdts%>">
<link rel="stylesheet" type="text/css" href="css/cal-style.css?v=<%=lgdts%>">
<link rel="stylesheet" type="text/css" href="css/common.css?v=<%=lgdts%>">
<link rel="stylesheet" href="./dadmin/css/sweetalert.min.css?v=<%=lgdts%>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
    
<link rel="stylesheet" type="text/css" href="./css/top.css?v=<%=lgdts%>">
    
<!-- 추가된 css -->
<link rel="stylesheet" type="text/css" href="./css/new_member.css?v=<%=lgdts%>">
<!-- 추가된 css -->
</head>

<body>
<!-- wrap -->
<div id="wrap">
<!-- header 로고 & 대메뉴,소메뉴 -->
<%@ include file="./header.jsp" %>
<!-- header 로고 & 대메뉴,소메뉴 끝 -->


<div id="container">
<div id="index">
    
<!-- 로그인 화면 시작 -->
<%@ include file="./m_login.jsp" %>
<!-- 로그인 화면 종료 -->
</div>
  <!-- 카피라이터 시작 -->
<%@ include file="./footer.jsp" %>
 <!-- 카피라이터 종료 -->
</div>
    </div>
</body>
</html>
