/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.85
 * Generated at: 2023-10-21 10:47:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import portfolio.NoticeDto;
import java.util.*;

public final class notice_005fmain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/admin/view/./ad_menu.jsp", Long.valueOf(1697633106000L));
    _jspx_dependants.put("/admin/view/./ad_copy.jsp", Long.valueOf(1696493190000L));
    _jspx_dependants.put("/admin/view/./n_main.jsp", Long.valueOf(1697885258541L));
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
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("portfolio.NoticeDto");
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

Date today = new Date();
DateFormat df = new SimpleDateFormat("yyyyMMddhms");
String dates = df.format(today);

String userid =(String) session.getAttribute("name");

if(userid==null || !userid.equals(userid)){
	out.println("<script>alert('잘못된 접근 방식입니다.'); location.href='./index.jsp';</script>");
}

      out.write("    \r\n");
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
      out.write("<!-- 신규추가된 css 파일 -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/notice.css?v=");
      out.print(dates);
      out.write("\">\r\n");
      out.write("<!-- 신규추가된 css 파일 끝-->\r\n");
      out.write("<title>관리자 페이지</title>\r\n");
      out.write("<script>\r\n");
      out.write("</script>\r\n");
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
      out.write("\r\n");
      out.write("<!-- 공지사항 관리 시작 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

Date today2 = new Date();
DateFormat df2 = new SimpleDateFormat("yyyyMMddhms");
String dates2 = df2.format(today2);

List<NoticeDto> notices =(List<NoticeDto>) request.getAttribute("notices");
int ea = (int) request.getAttribute("ea");
out.print(ea);

      out.write("\r\n");
      out.write("<!-- 공지사항 관리 시작 -->\r\n");
      out.write("<main class=\"page_main\">\r\n");
      out.write("<section class=\"page_section\">\r\n");
      out.write("<div class=\"listbody\">\r\n");
      out.write("    <div class=\"protitle\">공지사항 관리</div>\r\n");
      out.write("    <div class=\"procho\">\r\n");
      out.write("	    <form id=\"searchForm\" method=\"post\" action=\"./notice_main.do\">\r\n");
      out.write("	       <section class=\"search_part\">\r\n");
      out.write("	        <ol>\r\n");
      out.write("	        <li>공지사항 검색</li>\r\n");
      out.write("	        <li>\r\n");
      out.write("	        <input type=\"text\" id=\"sdate2\" class=\"search_input\" name=\"searchVal\">\r\n");
      out.write("	        <input type=\"button\" value=\"검색\" class=\"datebtn\" id=\"searchBtn\">\r\n");
      out.write("	        </li>        \r\n");
      out.write("	        <li></li>\r\n");
      out.write("	        <li></li> \r\n");
      out.write("	        </ol>\r\n");
      out.write("	       </section>\r\n");
      out.write("		</form> \r\n");
      out.write("       <section class=\"data_listsview\">\r\n");
      out.write("       <ul>\r\n");
      out.write("        <li>번호</li>\r\n");
      out.write("        <li>제목</li>\r\n");
      out.write("        <li>첨부파일 유/무</li>\r\n");
      out.write("        <li>조회수</li>\r\n");
      out.write("        <li>글쓴이</li>\r\n");
      out.write("        <li>등록일</li>\r\n");
      out.write("        <li>삭제</li>\r\n");
      out.write("       </ul>\r\n");
      out.write("       \r\n");
      out.write("       ");

       if(notices.size() > 0){
    	   int w = 0;
    	   do{
       
      out.write("\r\n");
      out.write("       <ul>\r\n");
      out.write("        <li>");
      out.print(w +1);
      out.write("</li>\r\n");
      out.write("        <li onclick=\"notice_detail(");
      out.print(notices.get(w).getNidx() );
      out.write(")\" style=\"text-align: center; justify-content: flex-start;\">");
      out.print(notices.get(w).getNtitle() );
      out.write("</li>\r\n");
      out.write("        <li>");
      out.print(notices.get(w).getNfile() == null ? 'X' : 'O' );
      out.write("</li>\r\n");
      out.write("        <li>");
      out.print(notices.get(w).getNcount());
      out.write("</li>\r\n");
      out.write("        <li>");
      out.print(notices.get(w).getNwriter());
      out.write("</li>\r\n");
      out.write("        <li>");
      out.print(notices.get(w).getNindate().substring(0, 10));
      out.write("</li>\r\n");
      out.write("        <li>\r\n");
      out.write("            <input type=\"button\" value=\"삭제\" class=\"delbtn\" onclick=\"del_notice(");
      out.print(notices.get(w).getNidx() );
      out.write(");\">\r\n");
      out.write("        </li>\r\n");
      out.write("       </ul>\r\n");
      out.write("       ");

       w++;
    	   }while(w < notices.size());
       }
       else{
       
      out.write("\r\n");
      out.write("       <ul class=\"nodatas\">\r\n");
      out.write("        <li>등록된 공지사항이 없습니다.</li>\r\n");
      out.write("       </ul>\r\n");
      out.write("       ");

       }
       
      out.write("\r\n");
      out.write("       <span class=\"notice_btns\">\r\n");
      out.write("       <input type=\"button\" value=\"글쓰기\" onclick=\"getToWrite()\" class=\"meno_btn2\"></span>\r\n");
      out.write("       <aside>\r\n");
      out.write("        <div class=\"page_number\">\r\n");
      out.write("           <ul>\r\n");
      out.write("           ");

           int pages = (int)Math.ceil(ea/10f);
           int pg = 1;
           while(pg <= pages){
           
      out.write("\r\n");
      out.write("           <li onclick=\"move_page(");
      out.print(pg);
      out.write(");\">");
      out.print(pg );
      out.write("</li>\r\n");
      out.write("           ");

           pg++;
           }
           
      out.write("\r\n");
      out.write("           </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("       </aside>\r\n");
      out.write("       </section>\r\n");
      out.write("    </div>\r\n");
      out.write("</div> \r\n");
      out.write("</section>\r\n");
      out.write("</main>\r\n");
      out.write("<!-- 공지사항 관리 끝 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"../js/n_main.js?v=");
      out.print(dates2);
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 공지사항 관리 끝 -->\r\n");
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