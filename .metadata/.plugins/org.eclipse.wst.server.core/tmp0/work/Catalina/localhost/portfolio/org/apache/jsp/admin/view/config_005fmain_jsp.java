/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.85
 * Generated at: 2023-10-21 10:20:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import portfolio.admin_dto;
import java.util.*;

public final class config_005fmain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/admin/view/./ad_menu.jsp", Long.valueOf(1697633106000L));
    _jspx_dependants.put("/admin/view/./ad_copy.jsp", Long.valueOf(1696493190000L));
    _jspx_dependants.put("/admin/view/./config.jsp", Long.valueOf(1697720890000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("portfolio.admin_dto");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("java.text.DateFormat");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

Date today = new Date();
DateFormat df = new SimpleDateFormat("yyyyMMddhms");
String dates = df.format(today);

String userid =(String) session.getAttribute("name");

if(userid==null || !userid.equals(userid)){
	out.println("<script>alert('잘못된 접근 방식입니다.'); location.href='./index.jsp';</script>");
}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/page_default.css?v=");
      out.print(dates);
      out.write("\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/admin_css.css?v=");
      out.print(dates);
      out.write("\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap\">\r\n");
      out.write("<title>관리자 페이지</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write('\r');
      out.write('\n');

String id =(String) session.getAttribute("name");

      out.write("\r\n");
      out.write("<nav>\r\n");
      out.write("<div class=\"menusize\">\r\n");
      out.write("    <ul id=\"menus\">\r\n");
      out.write("        <li class=\"topmenu1\">ADMINISTRATOR</li>\r\n");
      out.write("        <li class=\"topmenu2\"><a href=\"./info_main.do\">환경설정</a></li>\r\n");
      out.write("        <li class=\"topmenu2\"><a href=\"./member_main.do\">회원관리</a></li>\r\n");
      out.write("        <li class=\"topmenu2\"><a href=\"./notice_main.do\">공지사항 관리</a></li>\r\n");
      out.write("        <li class=\"topmenu2\"><a href=\"./faq_main.do\">FAQ</a></li>\r\n");
      out.write("        <li class=\"topmenu2\"><a href=\"./reserve_main.do\">예약현황</a></li>\r\n");
      out.write("        <li class=\"topmenu2\"><a href=\"./config_main.do\">관리자현황</a></li>\r\n");
      out.write("        <li class=\"topmenu3\">");
      out.print(id);
      out.write("님 환영합니다  <a href=\"./logout.do\">[로그아웃]</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write(" </div>\r\n");
      out.write("<div class=\"menuline\"></div>\r\n");
      out.write("</nav>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

Date to33 = new Date();
DateFormat df22 = new SimpleDateFormat("yyyyMMddhms");
String dd32 = df22.format(to33);

List<admin_dto> lists =(List<admin_dto>) request.getAttribute("lists");
int total = (int)request.getAttribute("ct");
String searchType =(String) request.getAttribute("searchType");
if(searchType == null){
	searchType = "이름";
}

      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("<!-- 관리자 리스트 시작 -->\r\n");
      out.write("<main class=\"page_main\">\r\n");
      out.write("<section class=\"page_section\">\r\n");
      out.write("<form id=\"adminForm\" method=\"post\" action=\"./config_main.do\" onsubmit=\"return member_search();\">    \r\n");
      out.write("<div class=\"listbody\">\r\n");
      out.write(" <div class=\"adlisttitle\">관리자 현황</div>\r\n");
      out.write(" <div class=\"procho\">\r\n");
      out.write("    <ul>\r\n");
      out.write("        <li class=\"prochoL procfont\">소속</li>\r\n");
      out.write("        <li class=\"prochoL\">\r\n");
      out.write("            <select class=\"adlistcsel1\" name=\"aarea\" id=\"aarea\">\r\n");
      out.write("                <option value=\"all\">전체</option>\r\n");
      out.write("                <option value=\"본사\">본사</option>\r\n");
      out.write("                <option value=\"경기도\">경기도</option>\r\n");
      out.write("                <option value=\"인천\">인천</option>\r\n");
      out.write("                <option value=\"대전\">대전</option>\r\n");
      out.write("                <option value=\"세종\">세종</option>\r\n");
      out.write("                <option value=\"광주\">광주</option>\r\n");
      out.write("                <option value=\"대구\">대구</option>\r\n");
      out.write("                <option value=\"울산\">울산</option>\r\n");
      out.write("                <option value=\"전라남도\">전라남도</option>\r\n");
      out.write("                <option value=\"전라북도\">전라북도</option>\r\n");
      out.write("                <option value=\"충청남도\">충청남도</option>\r\n");
      out.write("                <option value=\"충청북도\">충청북도</option>\r\n");
      out.write("                <option value=\"경상남도\">경상남도</option>\r\n");
      out.write("                <option value=\"경상북도\">경상북도</option>\r\n");
      out.write("                <option value=\"제주도\">제주도</option>  \r\n");
      out.write("            </select>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write(" </div>\r\n");
      out.write(" <div class=\"procho\">\r\n");
      out.write("    <ul>\r\n");
      out.write("        <li class=\"prochoL procfont\">검색형식</li>\r\n");
      out.write("        <li class=\"prochoL \">\r\n");
      out.write("            <select class=\"adlistcsel1\" name=\"search_type\">\r\n");
      out.write("            ");

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
            
      out.write("\r\n");
      out.write("                <option ");
      out.print(nmSelected );
      out.write(">이름</option>\r\n");
      out.write("                <option ");
      out.print(idSelected );
      out.write(">아이디</option>\r\n");
      out.write("                <option ");
      out.print(telSelected );
      out.write(">연락처</option>\r\n");
      out.write("            </select>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"prochoL\"><input type=\"text\" class=\"adlistcsel1\" name=\"search_val\"></li>\r\n");
      out.write("        <li class=\"prochoL\"><input type=\"submit\" class=\"proclick\" value=\"검색\"></li>\r\n");
      out.write("        <li class=\"prochoL\"><button type=\"button\" class=\"proclick\" onclick=\"toMain();\" >전체</button></li>\r\n");
      out.write("    </ul>\r\n");
      out.write(" </div>\r\n");
      out.write(" <div class=\"protaball\">\r\n");
      out.write("    <table width=\"1100\">\r\n");
      out.write("        <thead>\r\n");
      out.write("            <tr style=\"color: white; background-color:rgb(67, 66, 66);\">\r\n");
      out.write("                <td class=\"listcenter\" width=50>NO</td>\r\n");
      out.write("                <td class=\"listcenter\" width=150>구분</td>\r\n");
      out.write("                <td class=\"listcenter\" width=150>아이디</td>\r\n");
      out.write("                <td class=\"listcenter\" width=120>이름</td>\r\n");
      out.write("                <td class=\"listcenter\" width=80>직책</td>\r\n");
      out.write("                <td class=\"listcenter\" width=200>이메일</td>\r\n");
      out.write("                <td class=\"listcenter\" width=120>연락처</td>\r\n");
      out.write("                <td class=\"listcenter\" width=120>현황</td>\r\n");
      out.write("                <td class=\"listcenter\" width=110>적용</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("        ");
if(lists.size() == 0){ 
      out.write("\r\n");
      out.write("            <tr height=\"30\"><td class=\"listcenter\" colspan=\"9\">등록된 관리자가 없습니다.</td></tr>\r\n");
      out.write("        ");
}
        else{
        	int w = 0;
        	do{
        
      out.write("\r\n");
      out.write("            <tr class=\"master_list\" id=\"alist\">\r\n");
      out.write("                <td class=\"listcenter\" width=50>");
      out.print(total-w);
      out.write("</td>\r\n");
      out.write("                <td class=\"listcenter\" width=150>");
      out.print(lists.get(w).getAarea());
      out.write("</td>\r\n");
      out.write("                <td class=\"listcenter\" width=150>");
      out.print(lists.get(w).getAid());
      out.write("</td>\r\n");
      out.write("                <td class=\"listcenter\" width=120>");
      out.print(lists.get(w).getAname());
      out.write("</td>\r\n");
      out.write("                <td class=\"listcenter\" width=80>");
      out.print(lists.get(w).getAposition());
      out.write("</td>\r\n");
      out.write("                <td class=\"listcenter\" width=200>");
      out.print(lists.get(w).getAemail());
      out.write("</td>\r\n");
      out.write("                <td class=\"listcenter\" width=120>");
      out.print(lists.get(w).getAtel());
      out.write("</td>\r\n");
      out.write("                <td class=\"listcenter\" width=120>\r\n");
      out.write("                    <select class=\"adlistsel3\" id=\"status");
      out.print(lists.get(w).getAidx());
      out.write("\">\r\n");
      out.write("                    ");

                    String selected = "";
                    if(lists.get(w).getAuse().intern() =="Y"){
                    	selected = "";
                    }
                    else if(lists.get(w).getAuse().intern() =="N"){
                    	selected = "selected";
                    }
                    
      out.write("\r\n");
      out.write("                        <option ");
      out.print(selected);
      out.write(">근무중</option>\r\n");
      out.write("                        <option ");
      out.print(selected);
      out.write(">퇴직중</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </td>\r\n");
      out.write("                <td class=\"listcenter\" width=110>\r\n");
      out.write("                <button type=\"button\" class=\"listclick\" id=\"applyBtn\" onclick=\"update_status(");
      out.print(lists.get(w).getAidx());
      out.write(");\">적용</button></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        ");

        w++;
        }while(w<lists.size());
        	}
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write(" </div>\r\n");
      out.write(" \r\n");
      out.write(" <div class=\"propagebt\">\r\n");
      out.write("    <ul>\r\n");
      out.write("    ");

    int pg = (int) Math.ceil(total/10f);
    int ww = 1;
    int currentPage = request.getParameter("no") == null ? 1 : Integer.parseInt(request.getParameter("no"));
    int prevPage = (currentPage > 1) ? currentPage - 1 : 1;
    int nextPage = (currentPage < pg) ? currentPage + 1 : pg;
    
      out.write("\r\n");
      out.write("        <li onclick=\"goPage(");
      out.print(prevPage);
      out.write(")\">&lt</li>\r\n");
      out.write("	");

    while(ww<=pg){
    
      out.write("\r\n");
      out.write("        <li onclick=\"goPage(");
      out.print(ww);
      out.write(");\"><a href=\"./config_main.do?no=");
      out.print(ww);
      out.write('"');
      out.write('>');
      out.print(ww);
      out.write("</a></li>\r\n");
      out.write("    ");

    ww++;
    }
    
      out.write("\r\n");
      out.write("        <li onclick=\"goPage(");
      out.print(nextPage );
      out.write(")\" style=\"margin-right: 0px;\">&gt</li>\r\n");
      out.write("    </ul>\r\n");
      out.write(" </div>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("<!-- 관리자 리스트 끝 -->    \r\n");
      out.write("</section>\r\n");
      out.write("</main>\r\n");
      out.write("\r\n");
      out.write("<script src=\"../js/config.js?v=");
      out.print(dd32);
      out.write("\"></script>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<footer>\r\n");
      out.write("<div class=\"menusize\">Copyright ⓒ 2023 Raemian 분양안내 관리 시스템 All rights reserved</div>\r\n");
      out.write("</footer>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
