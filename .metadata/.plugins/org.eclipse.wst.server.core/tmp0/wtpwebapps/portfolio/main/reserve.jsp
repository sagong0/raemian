<%@page import="main.MemberDto"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date resdt = new Date();
DateFormat resdf = new SimpleDateFormat("yyyyMMddhms");
String resdts = resdf.format(resdt);
%>    
<div class="sub_title">
<section class="sub_image">
<span>
최적의 입주환경을 준비하는 입주 전 서비스<br>
두근두근 설레는 마음, 레미안 입주를 앞둔 고객님을 위한 사전방문 예약 입니다.</span>
</section>    
</div>    
    
<!-- 회원가입 화면 시작 -->
    <label class="mbship_title">
        <p>MAKE A RESERVATION</p>
        <ul>
          <li style="color: #000;">※ 예약하실 일자 및 예약자 정보를 입력하세요</li>
        </ul>
      </label>
    <form id="reserveF" method="post" action="./reserve_ok.do">
      <fieldset class="mbship_box">
        <h3>예약일자 입력 <span style="display: inline-block; font-size: 12px; vertical-align: 5px; float: right;">■ 표시는 필수 입력 항목입니다.</span></h3>
        <span class="agree_span">
        <ol class="mbinfos">
        <li><em class="ck_font">■</em> 아이디</li>
        <li>
        	<input type="text" name="rid" value="${mdto.mid}" class="mbinput1" readonly>
        </li>
        <li><em class="ck_font">■</em> 고객명</li>
        <li>
        	<input type="text" name="rname" value="${mdto.mname}" class="mbinput2" readonly>
        </li>
        <li><em class="ck_font">■</em> 예약일자</li>
        <li>
        	<input type="date" name="rdate" class="mbinput1">
        </li>
        <li><em class="ck_font">■</em> 예약시간</li>
        <li>
        <select class="mbinput1" name="rtime">
	        <option>시간선택</option>    
	        <option>09:00</option>        
	        <option>10:00</option>
	        <option>11:00</option>
	        <option>14:00</option>
	        <option>15:00</option>
	        <option>16:00</option>
	        <option>17:00</option>
        </select>
        </li>
        <li><em class="ck_font">■</em> 휴대전화번호</li>
        <li>
        	<input type="text" name="rtel" value="${mdto.mtel}" class="mbinput2" readonly>
        </li>
        <li><em class="ck_font">■</em> 인원수</li>
        <li>
	        <label class="ck_label">
	        <input type="radio" name="rcount" value="1" class="ck_label"> 1명
	        </label>
	        <label class="ck_label">
	        <input type="radio" name="rcount" value="2" class="ck_label"> 2명
	        </label>
        </li>
        </ol>
        </span>
	        <span class="span_buttons">
	        <button type="button" id="reserveBtn" class="next_btn1_1">예약하기</button>
        </span>
      </fieldset>
    </form>
<!-- 회원가입 화면 종료 -->

<script src="./js/reserve.js?v=<%=resdts%>"></script>
