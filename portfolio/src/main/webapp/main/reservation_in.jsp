<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date rdt = new Date();
DateFormat rdf = new SimpleDateFormat("yyyyMMddhms");
String rdts = rdf.format(rdt);


MemberDto mdto2 = (MemberDto) session.getAttribute("mdto");
if(mdto2 == null){
	out.println("<script>alert('잘못된 접근 방식입니다.'); location.href='./mainPage.do';</script>");
}
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
<link rel="stylesheet" type="text/css" href="css/normalize.css?v=<%=rdts%>">
<link rel="stylesheet" type="text/css" href="css/slick.css?v=<%=rdts%>">
<link rel="stylesheet" type="text/css" href="css/swiper.min.css?v=<%=rdts%>">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css?v=<%=rdts%>">
<link rel="stylesheet" type="text/css" href="css/cal-style.css?v=<%=rdts%>">
<link rel="stylesheet" type="text/css" href="css/common.css?v=<%=rdts%>">
<link rel="stylesheet" href="./dadmin/css/sweetalert.min.css?v=<%=rdts%>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
    
<link rel="stylesheet" type="text/css" href="./css/top.css?v=<%=rdts%>">
    
<!-- 추가된 css -->
<link rel="stylesheet" type="text/css" href="./css/new_member.css?v=<%=rdts%>">
<!-- 추가된 css -->
</head>

<body>
<!-- wrap -->
<div id="wrap">
<!-- header 로고 & 대메뉴,소메뉴 -->
<%@ include file="./header.jsp"%>
<!-- header 로고 & 대메뉴,소메뉴 끝 -->


<div id="container">
<div id="index">
    
<%@ include file="./reserve.jsp" %>
<!-- 회원가입 화면 종료 -->
</div>
  <!-- 카피라이터 시작 -->
<%@ include file="./footer.jsp" %>
 <!-- 카피라이터 종료 -->
</div>
    </div>
</body>
</html>
