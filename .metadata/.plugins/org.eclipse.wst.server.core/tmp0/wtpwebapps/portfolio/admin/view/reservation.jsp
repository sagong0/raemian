<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<div class="ad_main">
      <div class="ad_main1">
         <ul>
            <li class="ad_maintitle">예약현황</li>
            <li class="ad_mainbox2">
            <ol>
                <li>아이디</li>
                <li>고객명</li>
                <li>연락처</li>
                <li>예약일자</li>
                <li>예약시간</li>
                <li>예약인원</li>
            </ol>
            <c:forEach var="today" items="${todayReserves}" varStatus="current">
            <ol class="bgcancel">
                <li>${today.rid}</li>
                <li>${today.rname}</li>
                <li>${today.rtel}</li>
                <li>${today.rdate}</li>
                <li>${today.rtime.substring(0,5)}</li>
                <li>${today.rcount}명</li>
            </ol>
            </c:forEach>
            </li>
         </ul>
      </div>
   </div>