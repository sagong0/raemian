<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date rmaindt = new Date();
DateFormat rmainsf = new SimpleDateFormat("yyyyMMddhms");
String rmaindes = rmainsf.format(rmaindt);

String userid =(String) session.getAttribute("name");

if(userid==null || !userid.equals(userid)){
	out.println("<script>alert('잘못된 접근 방식입니다.'); location.href='./index.jsp';</script>");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/page_default.css?v=<%=rmaindes%>">
<link rel="stylesheet" href="../css/admin_css.css?v=<%=rmaindes%>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<!-- 신규추가된 css 파일 -->
<link rel="stylesheet" href="../css/notice.css?v=<%=rmaindes%>">
<!-- 신규추가된 css 파일 끝-->
<title>관리자 페이지</title>
<script>
</script>
</head>
<body>
<%@ include file="./ad_menu.jsp" %>
<!-- 회원관리 시작 -->
<%@ include file="./res_main.jsp" %>
<!-- 회원관리 끝 -->
<%@ include file="./ad_copy.jsp" %>
</body>
</html>