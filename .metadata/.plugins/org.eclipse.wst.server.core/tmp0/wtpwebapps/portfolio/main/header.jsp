<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="main.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
Date hddt = new Date();
DateFormat hddf = new SimpleDateFormat("yyyyMMddhms");
String hddts = hddf.format(hddt);


MemberDto mdto = (MemberDto)session.getAttribute("mdto");
String name = "";
if(mdto != null){
	name = (String)mdto.getMname();
}
%>    
<!-- header 로고 * 대메뉴,소메뉴-->
	<header id="hd">
		<div class="top_menu">
	        <ul class="top_menu_list">
	        <%
	        if(name != null && !name.isEmpty()){
	        %>
	        	<li><%=name %>님 환영합니다 <a href="./userlogOut.do">[로그아웃]</a></li>
	        	<li><a href="./faq.do">FAQ</a></li>
		        <li><a href="./notice.do">공지사항</a></li>
	        <%
	        }
	        else{
        	%>
	        	<li><a href="./login.jsp">로그인</a></li>
		        <li><a href="./join_agree.jsp">회원가입</a></li>
		        <li><a href="./faq.do">FAQ</a></li>
		        <li><a href="./notice.do">공지사항</a></li>
	        <%
	        }
	        %>        		        
		    </ul>
    	</div>
	
        <div class="top">
            <h1><a href="./mainPage.do" class="icon-hd-logo"></a></h1>
            <nav id="gnb">
                <li>
                    <a href=""><span>사업정보</span></a>
                    <ul>
                        <li><a href="./sub01.jsp">지구안내</a></li>
                        <li><a href="./sub02.jsp">입지안내</a></li>
                        <li><a href="">지역조감도</a></li>
                    </ul>
                </li>
                <li>
                    <a href=""><span>단지정보</span></a>
                    <ul>
                        <li><a href="./sub03.jsp">단지안내</a></li>
                        <li><a href="">시스템</a></li>
                        <li><a href="">단지배치도</a></li>
                        <li><a href="">동호배치도</a></li>
                    </ul>
                </li>
                <li>
                    <a href=""><span>세대정보</span></a>
                    <ul>
                        <li><a href="">타입별 평면도</a></li>
                        <li><a href="">인테리어</a></li>
						<li><a href="">사이버모델하우스</a></li>
						<li><a href="">인테리어마감재</a></li>
                    </ul>
                </li>
                <li>
                    <a href=""><span>공급정보</span></a>
                    <ul>
                       <li><a href="">입주자 모집공고</a></li>
                        <li><a href="">E-카달로그</a></li>
                         <li><a href="">공급일정 안내</a></li>
                        <li><a href="">오시는 길</a></li>
                      <li><a href=""></a></li>
                    </ul>
                </li>
                <li>
                    <a><span>사전방문예약</span></a>
                    <ul>
                        <li><a href="" id="reserveA">사전방문예약</a></li>
                        <li><a href="" id="reserveCK">사전방문예약확인</a></li>
                        <li><a href="" id="reserveCancel">사전방문예약취소</a></li>
                    </ul>
                </li>
            </nav>
        </div>
	</header>
	<!-- header 로고 * 대메뉴,소메뉴 END-->
<script>
/* 예약 페이지 가기 */
function go_reserve(){
	if("<%=name%>" != null && '<%=name%>'.trim() != ""){
		location.href="./reservation_in.do"
	}
	else{
		alert("사전방문 예약은 로그인 후 가능합니다.");
	}
}

document.getElementById("reserveA").addEventListener("click",function(event){
	go_reserve();
	event.preventDefault();
});


/* 예약 확인 가기 */
function go_reserveCk(){
	if("<%=name%>" != null && '<%=name%>'.trim() != ""){
		location.href="./reservation_ck.do"
	}
	else{
		alert("예약확인은 로그인 후 가능합니다.");
	}
}


document.getElementById("reserveCK").addEventListener("click",function(event){
	go_reserveCk();
	event.preventDefault();
});

/*취소 화면 가기*/
function go_reserveCancel(){
	if("<%=name%>" != null && '<%=name%>'.trim() != ""){
		location.href="./reservation_cancel.do"
	}
	else{
		alert("예약취소 기능은 로그인 후 사용 가능합니다.");
	}
}
document.getElementById("reserveCancel").addEventListener("click",function(event){
	go_reserveCancel();
	event.preventDefault();
});
</script>	
	