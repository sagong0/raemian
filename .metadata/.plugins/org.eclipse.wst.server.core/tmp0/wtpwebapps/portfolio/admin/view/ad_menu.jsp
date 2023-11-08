<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id =(String) session.getAttribute("name");
%>
<nav>
<div class="menusize">
    <ul id="menus">
        <li class="topmenu1">ADMINISTRATOR</li>
        <li class="topmenu2"><a href="./info_main.do">환경설정</a></li>
        <li class="topmenu2"><a href="./member_main.do">회원관리</a></li>
        <li class="topmenu2"><a href="./notice_main.do">공지사항 관리</a></li>
        <li class="topmenu2"><a href="./faq_main.do">FAQ</a></li>
        <li class="topmenu2"><a href="./reserve_main.do">예약현황</a></li>
        <li class="topmenu2"><a href="./config_main.do">관리자현황</a></li>
        <li class="topmenu3"><%=id%>님 환영합니다  <a href="./logout.do">[로그아웃]</a></li>
    </ul>
 </div>
<div class="menuline"></div>
</nav>
