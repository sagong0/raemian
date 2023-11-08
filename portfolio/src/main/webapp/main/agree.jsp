<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date agdt = new Date();
DateFormat agdf = new SimpleDateFormat("yyyyMMddhms");
String agdts = agdf.format(agdt);
%>        
<!-- 서브 화면 시작 -->
    <label class="mbship_title">
        <p>MEMBER-SHIP</p>
        <ul>
          <li>01. 약관동의</li>
          <li><img src="./img/step_on.png" /></li>
          <li>02. 정보입력</li>
          <li><img src="./img/step_off.png" /></li>
          <li>03. 가입완료</li>
        </ul>
      </label>
      
      <form id="agreeForm" method="post" action="./join_member.do">
      <fieldset class="mbship_box">
        <h3>약관동의</h3>
        <span class="agree_span">
        <label class="mbship_text">
          <input type="checkbox" id="all_agree" name="all" onclick="allagree(this.checked)" /> 의 모든 약관을 확인하고 전체 동의 합니다.
          (전체동의, 선택항목도 포함됩니다.)
        </label>
        <label class="mbship_text">
            <input type="checkbox" id="a1" name="a1" onclick="chbox(this.checked);"><font color="red"> (필수)</font>이용약관
        </label>
        <div class="agree_text" id="agree1"></div>
        <label class="mbship_text">
            <input type="checkbox" id="a2" name="a2" onclick="chbox(this.checked);"><font color="red"> (필수)</font> 개인정보 수집 및 이용
        </label>
        <div class="agree_text" id="agree2"></div>
        </span>
        <button type="button" id="nextBtn" class="next_btn">다음단계</button>
      </fieldset>
      </form>
<!-- 서브 화면 종료 -->

<script src="./js/agree.js?v=<%=agdts%>"></script>