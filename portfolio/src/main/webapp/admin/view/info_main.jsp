<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date im22 = new Date();
DateFormat im22sf = new SimpleDateFormat("yyyyMMddhms");
String im22dates = im22sf.format(im22);

String userid =(String) session.getAttribute("name");

if(userid==null || !userid.equals(userid)){
	out.println("<script>alert('잘못된 접근 방식입니다.'); location.href='./index.jsp';</script>");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/page_default.css?v=<%=im22dates%>">
<link rel="stylesheet" href="../css/admin_css.css?v=<%=im22dates%>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<!-- 신규추가된 css 파일 -->
<link rel="stylesheet" href="../css/notice.css?v=<%=im22dates%>">
<!-- 신규추가된 css 파일 끝-->
<title>관리자 페이지</title>
<script>
</script>
</head>
<body>
<%@ include file="./ad_menu.jsp" %>
<%@ include file="./info.jsp" %>
<!-- 공지사항 관리 끝 -->
<%@include file="./ad_copy.jsp"%>
</body>
</html>