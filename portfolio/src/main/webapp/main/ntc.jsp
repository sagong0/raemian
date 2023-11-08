<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Date ntcdt = new Date();
DateFormat ntcdf = new SimpleDateFormat("yyyyMMddhms");
String ntcdts = ntcdf.format(ntcdt);

int ea = (int) request.getAttribute("ea");
%>
<!-- 서브 화면 시작 -->
    <label class="mbship_title">
        <p>NOTICE</p>
        <ul>
          <li>RAEMIAN 새로운 소식을 확인하세요</li>
        </ul>
      </label>
      <fieldset class="mbship_box">
        <ul>
        <li>번호</li>  
        <li>제목</li>  
        <li>조회수</li>     
        <li>글쓴이</li>  
        <li>등록일</li>      
        </ul>
        
        <app:forEach var="ndto" items="${ndtos}" varStatus="current">
        <ul>
	        <li>${current.index + 1}</li>
	        <li style="text-align: left;">${ndto.ntitle}</li>
	        <li>${ndto.ncount}</li>
	        <li>${ndto.nwriter}</li>  
	        <li>${ndto.nindate.substring(0,10)}</li>      
        </ul>
        </app:forEach>
        
        <span class="pages">
          <%
          int pgs = (int) Math.ceil(ea/10f);
          %>
          <app:set var="pgs" value="<%=pgs%>" />
          <app:set var="w" value="1"/>
          <app:forEach begin="1" end="${pgs}" step="1" var="w">
          <ul>
            <li onclick="next_page(${w})"><a style="color: white">${w}</a></li>
          </ul>
          </app:forEach>
        </span>
        
        
        <form id="searchFF" method="get" action="./notice.do">  
        <span class="search_css">
        <input type="text" name="searchVal" class="search_in" placeholder="검색할 제목을 입력하세요">
        <input type="submit" id="n_searchBtn" value="검색" class="search_btn">
        </span>
        </form>
      </fieldset>
<!-- 서브 화면 종료 -->


<script src="./js/ntc.js?v=<%=ntcdts%>"></script>

