<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="main.ReserveDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date rcdt = new Date();
DateFormat rcdf = new SimpleDateFormat("yyyyMMddhms");
String rcdts = rcdf.format(rcdt);
%>  
<div class="sub_title">
<section class="sub_image">
<span>
최적의 입주환경을 준비하는 입주 전 서비스<br>
두근두근 설레는 마음, 레미안 입주를 앞둔 고객님을 위한 사전방문 예약 입니다.</span>
</section>    
</div>    
    
<!-- 예약취소 화면 시작 -->
    <label class="mbship_title">
        <p>RESERVATION CANCEL</p>
        <ul>
          <li style="color: red;">※ 예약취소시 해당 데이터는 복구 되지 않습니다.</li>
        </ul>
      </label>
    <form id="cancelF" method="post" action="./">
      <fieldset class="mbship_box">
        <h3>예약확인</h3>
        <span class="agree_span">
        <ol class="mbinfos">
        <li><em class="ck_font">■</em> 아이디</li>
        <li>${rdto.rid}</li>
        <li><em class="ck_font">■</em> 고객명</li>
        <li>${rdto.rname}</li>
        <li><em class="ck_font">■</em> 예약일자</li>
        <li>${rdto.rdate}</li>
        <li><em class="ck_font">■</em> 예약시간</li>
        <li>${rdto.rtime.substring(0,5)}</li>
        <li><em class="ck_font">■</em> 휴대전화번호</li>
        <li>
        ${rdto.rtel}
        </li>
        <li><em class="ck_font">■</em> 인원수</li>
        <li>
        <label class="ck_label">${rdto.rcount}명</label>
        </li>
        </ol>
        </span>
        <span class="span_buttons">
        <button type="button" onclick="cancel_res(${rdto.ridx})" class="next_btn1_1">예약취소</button>
        </span>
      </fieldset>
    </form>
<!-- 예약취소 화면 종료 -->

<script src="./js/r_cancel.js?v=<%=rcdts%>"></script>

