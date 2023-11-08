<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="portfolio.NoticeDto"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date today2 = new Date();
DateFormat df2 = new SimpleDateFormat("yyyyMMddhms");
String dates2 = df2.format(today2);

List<NoticeDto> notices =(List<NoticeDto>) request.getAttribute("notices");
int ea = (int) request.getAttribute("ea");
%>
<!-- 공지사항 관리 시작 -->
<main class="page_main">
<section class="page_section">
<div class="listbody">
    <div class="protitle">공지사항 관리</div>
    <div class="procho">
	    <form id="searchForm" method="post" action="./notice_main.do">
	       <section class="search_part">
	        <ol>
	        <li>공지사항 검색</li>
	        <li>
	        <input type="text" id="sdate2" class="search_input" name="searchVal">
	        <input type="button" value="검색" class="datebtn" id="searchBtn">
	        </li>        
	        <li></li>
	        <li></li> 
	        </ol>
	       </section>
		</form> 
       <section class="data_listsview">
       <ul>
        <li>번호</li>
        <li>제목</li>
        <li>첨부파일 유/무</li>
        <li>조회수</li>
        <li>글쓴이</li>
        <li>등록일</li>
        <li>삭제</li>
       </ul>
       
       <%
       if(notices.size() > 0){
    	   int w = 0;
    	   do{
       %>
       <ul>
        <li><%=w +1%></li>
        <li onclick="notice_detail(<%=notices.get(w).getNidx() %>)" style="text-align: center; justify-content: flex-start;"><%=notices.get(w).getNtitle() %></li>
        <li><%=notices.get(w).getNfile() == null ? 'X' : 'O' %></li>
        <li><%=notices.get(w).getNcount()%></li>
        <li><%=notices.get(w).getNwriter()%></li>
        <li><%=notices.get(w).getNindate().substring(0, 10)%></li>
        <li>
            <input type="button" value="삭제" class="delbtn" onclick="del_notice(<%=notices.get(w).getNidx() %>);">
        </li>
       </ul>
       <%
       w++;
    	   }while(w < notices.size());
       }
       else{
       %>
       <ul class="nodatas">
        <li>등록된 공지사항이 없습니다.</li>
       </ul>
       <%
       }
       %>
       <span class="notice_btns">
       <input type="button" value="글쓰기" onclick="getToWrite()" class="meno_btn2"></span>
       <aside>
        <div class="page_number">
           <ul>
           <%
           int pages = (int)Math.ceil(ea/10f);
           int pg = 1;
           while(pg <= pages){
           %>
           <li onclick="move_page(<%=pg%>);"><%=pg %></li>
           <%
           pg++;
           }
           %>
           </ul>
        </div>
       </aside>
       </section>
    </div>
</div> 
</section>
</main>
<!-- 공지사항 관리 끝 -->


<script src="../js/n_main.js?v=<%=dates2%>"></script>

