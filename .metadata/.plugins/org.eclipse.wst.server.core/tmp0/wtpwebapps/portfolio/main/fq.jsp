<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date fqqdt = new Date();
DateFormat fqqdf = new SimpleDateFormat("yyyyMMddhms");
String fqqdts = fqqdf.format(fqqdt);
%>    
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 서브 화면 시작 -->
    <label class="mbship_title">
        <p>FAQ</p>
        <ul>
          <li>RAEMIAN 자주묻는 질문</li>
        </ul>
      </label>
      <fieldset class="faq_box">
        <app:forEach var="fdto" items="${fdtos}" varStatus="current">
        <ul>
        <li>질문</li>       
        <li id="fquestion${current.index}" class="fq">${fdto.fquestion}</li>
        <li id="fanswer${current.index}" class="fa" style="display: none;">
        ${fdto.fanswer}
        </li>
        </ul>
        </app:forEach>
      </fieldset>
<!-- 서브 화면 종료 -->

<script src="./js/fq.js?v=<%=fqqdts%>"></script>