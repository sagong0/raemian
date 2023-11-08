<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="main.ReserveDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
Date rckdt = new Date();
DateFormat rckdf = new SimpleDateFormat("yyyyMMddhms");
String rckdts = rckdf.format(rckdt);
String[] times = {"09:00:00", "10:00:00", "11:00:00", "14:00:00", "15:00:00", "16:00:00", "17:00:00"};
request.setAttribute("times", times);
%>

<div class="sub_title">
<section class="sub_image">
<span>
최적의 입주환경을 준비하는 입주 전 서비스<br>
두근두근 설레는 마음, 레미안 입주를 앞둔 고객님을 위한 사전방문 예약 입니다.</span>
</section>    
</div>    
    
<!-- 예약확인 화면 시작 -->
    <label class="mbship_title">
        <p>RESERVATION CONFIRM</p>
        <ul>
          <li style="color: red;">※ 예약수정은 1회 변경 가능 합니다.</li>
        </ul>
      </label>
    <form id="modifyForm" method="post" action="./reserve_modify.do">
      <fieldset class="mbship_box">
        <h3>예약확인 <span style="display: inline-block; font-size: 12px; vertical-align: 5px; float: right;">■ 표시는 필수 입력 항목입니다.</span></h3>
        <span class="agree_span">
        <ol class="mbinfos">
        <li><em class="ck_font">■</em> 아이디</li>
        <li>
        <input type="text" name="rid" value="${rdto.rid}" class="mbinput1" readonly>
        </li>
        <li><em class="ck_font">■</em> 고객명</li>
        <li>
        <input type="text" name="rname" value="${rdto.rname}" class="mbinput2" readonly>
        </li>
        <li><em class="ck_font">■</em> 예약일자</li>
        <li>
        <input type="date" name="rdate" value="${rdto.rdate }" class="mbinput1">
        </li>
        <li><em class="ck_font">■</em> 예약시간</li>
        <li>
        <select class="mbinput1" name="rtime">
            <option value="">시간선택</option>
            <c:forEach var="time" items="${times}">
                <c:choose>
                    <c:when test="${rdto.rtime eq time}">
                        <option value="${time}" selected>${time}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${time}">${time}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        </li>
        <li><em class="ck_font">■</em> 휴대전화번호</li>
        <li>
        <input type="text" name="rtel" value="${rdto.rtel}" class="mbinput2" readonly>
        </li>
        <li><em class="ck_font">■</em> 인원수</li>
        <li>
        <label class="ck_label">
        <input type="hidden" id="hiddenRadioVal" value="${rdto.rcount}">
        <input type="radio" name="rcount" id="r1" value="1" class="ck_label"> 1명
        </label>
        <label class="ck_label">
        <input type="radio" name="rcount" id="r2" value="2" class="ck_label"> 2명
        </label>
        </li>
        </ol>
        </span>
        <span class="span_buttons">
        <input type="hidden" name="rchance" value="1" readonly>
        <input type="hidden" name="ridx" value="${rdto.ridx}" readonly> 
        <c:if test="${rdto.rchance eq 1}">
        <button type="button" onclick="res_modify()" class="next_btn1_1">예약수정</button>
        </c:if>
        </span>
      </fieldset>
    </form>
<!-- 예약확인 화면 종료-->

<script src="./js/r_ck.js?v=<%=rckdts%>"></script>