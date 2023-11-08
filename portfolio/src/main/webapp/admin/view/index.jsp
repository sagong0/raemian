<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date tty = new Date();
DateFormat sf = new SimpleDateFormat("yyyyMMddhms");
String des = sf.format(tty);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/admin_css.css?<%=des%>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap">
<title>관리자 페이지</title>
</head>
<body>
  <div class="adbody">
      <div class="adtitle">ADMINISTRATOR</div>
      <div class="admoom">
        <form id="member_log" name="member_log" method="post" action="./ad_loginok.do" onsubmit="return ad_login();">
          <div class="intotal"> 
            <div class="adin1">
              <input type="text" name="login_id" id="login_id" class="loginid" value="" placeholder="아이디">
              <input type="hidden" name="login_name" value="">
            </div>
            <div class="adin2">
              <input type="password" name="login_pass" id="login_pass" class="loginpass" value="" placeholder="패스워드">
            </div>
          </div>
          <div class="adbt">
            <button type="submit" class="loginbt1">로그인</button>
            <button type="button" class="loginbt2" id="member_add">회원가입</button>
          </div>
          <div class="adinfomain">
            <ul>
               <li class="adinfo">※ 사원번호가 없을시 관리자에게 연락 바랍니다.</li>
               <li class="adinfo">※ 모든 정보는 기록되어 집니다.</li>
               <li class="adinfo">※ 퇴사시 해당 정보는 접속이 불가능 하게 됩니다.</li>
               <li class="adinfo">※ 테스트 계정 (id : test123, password : test123123)</li>
            </ul>
          </div>
         </form>
        </div>
      </div>
    </body>
    <script src="../js/page_result.js?v="<%=des%>"></script>
    <script src="../js/index.js?v="<%=des%>"></script>
    </html>