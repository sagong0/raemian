<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date today = new Date();
DateFormat df = new SimpleDateFormat("yyyyMMddhms");
String dates = df.format(today);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/page_default.css?v=<%=dates%>">
<link rel="stylesheet" href="../css/admin_css.css?v=<%=dates%>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">

<!-- 신규추가된 css 파일 -->
<link rel="stylesheet" href="../css/notice.css?v=<%=dates%>">
<!-- 신규추가된 css 파일 끝-->
<title>관리자 페이지</title>
<script src="https://cdn.ckeditor.com/4.22.1/standard/ckeditor.js?v=<%=dates%>"></script>
</head>
<body>
<%@ include file="./ad_menu.jsp" %>
<!-- 공지사항 등록 시작 -->
<%@ include file="./n_write.jsp" %>
<!-- 공지사항 등록 끝 -->
<%@ include file="./ad_copy.jsp" %>
</body>
</html>