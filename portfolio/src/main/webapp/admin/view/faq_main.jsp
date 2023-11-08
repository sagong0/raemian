<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date aady = new Date();
DateFormat ad = new SimpleDateFormat("yyyyMMddhms");
String add = ad.format(aady);
%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/page_default.css?v=<%=add%>">
<link rel="stylesheet" href="../css/admin_css.css?v=<%=add%>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<!-- 신규추가된 css 파일 -->
<link rel="stylesheet" href="../css/notice.css?v=<%=add%>">
<!-- 신규추가된 css 파일 끝-->
<title>관리자 페이지</title>
<script>
</script>
</head>
<body>
<%@ include file="./ad_menu.jsp" %>
<!-- FAQ 리스트 시작 -->
<%@ include file="./fq_main.jsp" %>
<!-- FAQ 리스트 끝 -->
<%@ include file="./ad_copy.jsp" %>
</body>
</html>