<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="portfolio.admin_dto"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Date to33 = new Date();
DateFormat df22 = new SimpleDateFormat("yyyyMMddhms");
String dd32 = df22.format(to33);

List<admin_dto> lists =(List<admin_dto>) request.getAttribute("lists");
int total = (int)request.getAttribute("ct");
String searchType =(String) request.getAttribute("searchType");
if(searchType == null){
	searchType = "이름";
}
%>    
    
    
<!-- 관리자 리스트 시작 -->
<main class="page_main">
<section class="page_section">
<form id="adminForm" method="post" action="./config_main.do" onsubmit="return member_search();">    
<div class="listbody">
 <div class="adlisttitle">관리자 현황</div>
 <div class="procho">
    <ul>
        <li class="prochoL procfont">소속</li>
        <li class="prochoL">
            <select class="adlistcsel1" name="aarea" id="aarea">
                <option value="all">전체</option>
                <option value="본사">본사</option>
                <option value="경기도">경기도</option>
                <option value="인천">인천</option>
                <option value="대전">대전</option>
                <option value="세종">세종</option>
                <option value="광주">광주</option>
                <option value="대구">대구</option>
                <option value="울산">울산</option>
                <option value="전라남도">전라남도</option>
                <option value="전라북도">전라북도</option>
                <option value="충청남도">충청남도</option>
                <option value="충청북도">충청북도</option>
                <option value="경상남도">경상남도</option>
                <option value="경상북도">경상북도</option>
                <option value="제주도">제주도</option>  
            </select>
        </li>
    </ul>
 </div>
 <div class="procho">
    <ul>
        <li class="prochoL procfont">검색형식</li>
        <li class="prochoL ">
            <select class="adlistcsel1" name="search_type">
            <%
            String nmSelected = "";
            String idSelected = "";
            String telSelected = "";
            if(searchType.equals("이름")){
            	nmSelected = "selected";
            }
            else if(searchType.equals("아이디")){
            	idSelected = "selected";
            }
			else if(searchType.equals("연락처")){
            	telSelected = "selected";
            }
            %>
                <option <%=nmSelected %>>이름</option>
                <option <%=idSelected %>>아이디</option>
                <option <%=telSelected %>>연락처</option>
            </select>
        </li>
        <li class="prochoL"><input type="text" class="adlistcsel1" name="search_val"></li>
        <li class="prochoL"><input type="submit" class="proclick" value="검색"></li>
        <li class="prochoL"><button type="button" class="proclick" onclick="toMain();" >전체</button></li>
    </ul>
 </div>
 <div class="protaball">
    <table width="1100">
        <thead>
            <tr style="color: white; background-color:rgb(67, 66, 66);">
                <td class="listcenter" width=50>NO</td>
                <td class="listcenter" width=150>구분</td>
                <td class="listcenter" width=150>아이디</td>
                <td class="listcenter" width=120>이름</td>
                <td class="listcenter" width=80>직책</td>
                <td class="listcenter" width=200>이메일</td>
                <td class="listcenter" width=120>연락처</td>
                <td class="listcenter" width=120>현황</td>
                <td class="listcenter" width=110>적용</td>
            </tr>
        </thead>
        <tbody>
        <%if(lists.size() == 0){ %>
            <tr height="30"><td class="listcenter" colspan="9">등록된 관리자가 없습니다.</td></tr>
        <%}
        else{
        	int w = 0;
        	do{
        %>
            <tr class="master_list" id="alist">
                <td class="listcenter" width=50><%=total-w%></td>
                <td class="listcenter" width=150><%=lists.get(w).getAarea()%></td>
                <td class="listcenter" width=150><%=lists.get(w).getAid()%></td>
                <td class="listcenter" width=120><%=lists.get(w).getAname()%></td>
                <td class="listcenter" width=80><%=lists.get(w).getAposition()%></td>
                <td class="listcenter" width=200><%=lists.get(w).getAemail()%></td>
                <td class="listcenter" width=120><%=lists.get(w).getAtel()%></td>
                <td class="listcenter" width=120>
                    <select class="adlistsel3" id="status<%=lists.get(w).getAidx()%>">
                    <%
                    String selected = "";
                    if(lists.get(w).getAuse().intern() =="Y"){
                    	selected = "";
                    }
                    else if(lists.get(w).getAuse().intern() =="N"){
                    	selected = "selected";
                    }
                    %>
                        <option <%=selected%>>근무중</option>
                        <option <%=selected%>>퇴직중</option>
                    </select>
                </td>
                <td class="listcenter" width=110>
                <button type="button" class="listclick" id="applyBtn" onclick="update_status(<%=lists.get(w).getAidx()%>);">적용</button></td>
            </tr>
        <%
        w++;
        }while(w<lists.size());
        	}%>
        </tbody>
    </table>
 </div>
 
 <div class="propagebt">
    <ul>
    <%
    int pg = (int) Math.ceil(total/10f);
    int ww = 1;
    int currentPage = request.getParameter("no") == null ? 1 : Integer.parseInt(request.getParameter("no"));
    int prevPage = (currentPage > 1) ? currentPage - 1 : 1;
    int nextPage = (currentPage < pg) ? currentPage + 1 : pg;
    %>
        <li onclick="goPage(<%=prevPage%>)">&lt</li>
	<%
    while(ww<=pg){
    %>
        <li onclick="goPage(<%=ww%>);"><a href="./config_main.do?no=<%=ww%>"><%=ww%></a></li>
    <%
    ww++;
    }
    %>
        <li onclick="goPage(<%=nextPage %>)" style="margin-right: 0px;">&gt</li>
    </ul>
 </div>
</div>
</form>
<!-- 관리자 리스트 끝 -->    
</section>
</main>

<script src="../js/config.js?v=<%=dd32%>"></script>
