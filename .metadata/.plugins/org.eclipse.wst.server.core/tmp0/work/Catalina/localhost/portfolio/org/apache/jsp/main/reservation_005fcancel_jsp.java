/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.85
 * Generated at: 2023-10-19 16:04:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import main.MemberDto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import main.ReserveDto;

public final class reservation_005fcancel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/main/./footer.jsp", Long.valueOf(1697181196000L));
    _jspx_dependants.put("/main/./r_cancel.jsp", Long.valueOf(1697629912000L));
    _jspx_dependants.put("/main/./header.jsp", Long.valueOf(1697724770960L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("main.ReserveDto");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("main.MemberDto");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1\">\r\n");
      out.write("<meta property=\"og:type\" content=\"website\">\r\n");
      out.write("<meta property=\"og:title\" content=\"인천검단 레미안\">\r\n");
      out.write("<title>인천검단 레미안</title>\r\n");
      out.write("<!-- css -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/normalize.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/slick.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/swiper.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/cal-style.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/common.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./dadmin/css/sweetalert.min.css\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/top.css?v=2\">\r\n");
      out.write("    \r\n");
      out.write("<!-- 추가된 css -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/new_member.css?v=26\">\r\n");
      out.write("<!-- 추가된 css -->\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<!-- wrap -->\r\n");
      out.write("<div id=\"wrap\">\r\n");
      out.write("<!-- header 로고 & 대메뉴,소메뉴 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("   \r\n");

Date hddt = new Date();
DateFormat hddf = new SimpleDateFormat("yyyyMMddhms");
String hddts = hddf.format(hddt);


MemberDto mdto = (MemberDto)session.getAttribute("mdto");
String name = "";
if(mdto != null){
	name = (String)mdto.getMname();
}

      out.write("    \r\n");
      out.write("<!-- header 로고 * 대메뉴,소메뉴-->\r\n");
      out.write("	<header id=\"hd\">\r\n");
      out.write("		<div class=\"top_menu\">\r\n");
      out.write("	        <ul class=\"top_menu_list\">\r\n");
      out.write("	        ");

	        if(name != null && !name.isEmpty()){
	        
      out.write("\r\n");
      out.write("	        	<li>");
      out.print(name );
      out.write("님 환영합니다 <a href=\"./userlogOut.do\">[로그아웃]</a></li>\r\n");
      out.write("	        	<li><a href=\"./faq.do\">FAQ</a></li>\r\n");
      out.write("		        <li><a href=\"./notice.do\">공지사항</a></li>\r\n");
      out.write("	        ");

	        }
	        else{
        	
      out.write("\r\n");
      out.write("	        	<li><a href=\"./login.jsp\">로그인</a></li>\r\n");
      out.write("		        <li><a href=\"./join_agree.jsp\">회원가입</a></li>\r\n");
      out.write("		        <li><a href=\"./faq.do\">FAQ</a></li>\r\n");
      out.write("		        <li><a href=\"./notice.do\">공지사항</a></li>\r\n");
      out.write("	        ");

	        }
	        
      out.write("        		        \r\n");
      out.write("		    </ul>\r\n");
      out.write("    	</div>\r\n");
      out.write("	\r\n");
      out.write("        <div class=\"top\">\r\n");
      out.write("            <h1><a href=\"./mainPage.do\" class=\"icon-hd-logo\"></a></h1>\r\n");
      out.write("            <nav id=\"gnb\">\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"\"><span>사업정보</span></a>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"./sub01.jsp\">지구안내</a></li>\r\n");
      out.write("                        <li><a href=\"./sub02.jsp\">입지안내</a></li>\r\n");
      out.write("                        <li><a href=\"\">지역조감도</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"\"><span>단지정보</span></a>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"./sub03.jsp\">단지안내</a></li>\r\n");
      out.write("                        <li><a href=\"\">시스템</a></li>\r\n");
      out.write("                        <li><a href=\"\">단지배치도</a></li>\r\n");
      out.write("                        <li><a href=\"\">동호배치도</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"\"><span>세대정보</span></a>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"\">타입별 평면도</a></li>\r\n");
      out.write("                        <li><a href=\"\">인테리어</a></li>\r\n");
      out.write("						<li><a href=\"\">사이버모델하우스</a></li>\r\n");
      out.write("						<li><a href=\"\">인테리어마감재</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a href=\"\"><span>공급정보</span></a>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                       <li><a href=\"\">입주자 모집공고</a></li>\r\n");
      out.write("                        <li><a href=\"\">E-카달로그</a></li>\r\n");
      out.write("                         <li><a href=\"\">공급일정 안내</a></li>\r\n");
      out.write("                        <li><a href=\"\">오시는 길</a></li>\r\n");
      out.write("                      <li><a href=\"\"></a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                    <a><span>사전방문예약</span></a>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"\" id=\"reserveA\">사전방문예약</a></li>\r\n");
      out.write("                        <li><a href=\"\" id=\"reserveCK\">사전방문예약확인</a></li>\r\n");
      out.write("                        <li><a href=\"\" id=\"reserveCancel\">사전방문예약취소</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </div>\r\n");
      out.write("	</header>\r\n");
      out.write("	<!-- header 로고 * 대메뉴,소메뉴 END-->\r\n");
      out.write("<script>\r\n");
      out.write("/* 예약 페이지 가기 */\r\n");
      out.write("function go_reserve(){\r\n");
      out.write("	if(\"");
      out.print(name);
      out.write("\" != null && '");
      out.print(name);
      out.write("'.trim() != \"\"){\r\n");
      out.write("		location.href=\"./reservation_in.do\"\r\n");
      out.write("	}\r\n");
      out.write("	else{\r\n");
      out.write("		alert(\"사전방문 예약은 로그인 후 가능합니다.\");\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("document.getElementById(\"reserveA\").addEventListener(\"click\",function(event){\r\n");
      out.write("	go_reserve();\r\n");
      out.write("	event.preventDefault();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/* 예약 확인 가기 */\r\n");
      out.write("function go_reserveCk(){\r\n");
      out.write("	if(\"");
      out.print(name);
      out.write("\" != null && '");
      out.print(name);
      out.write("'.trim() != \"\"){\r\n");
      out.write("		location.href=\"./reservation_ck.do\"\r\n");
      out.write("	}\r\n");
      out.write("	else{\r\n");
      out.write("		alert(\"예약확인은 로그인 후 가능합니다.\");\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("document.getElementById(\"reserveCK\").addEventListener(\"click\",function(event){\r\n");
      out.write("	go_reserveCk();\r\n");
      out.write("	event.preventDefault();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("/*취소 화면 가기*/\r\n");
      out.write("function go_reserveCancel(){\r\n");
      out.write("	if(\"");
      out.print(name);
      out.write("\" != null && '");
      out.print(name);
      out.write("'.trim() != \"\"){\r\n");
      out.write("		location.href=\"./reservation_cancel.do\"\r\n");
      out.write("	}\r\n");
      out.write("	else{\r\n");
      out.write("		alert(\"예약취소 기능은 로그인 후 사용 가능합니다.\");\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("document.getElementById(\"reserveCancel\").addEventListener(\"click\",function(event){\r\n");
      out.write("	go_reserveCancel();\r\n");
      out.write("	event.preventDefault();\r\n");
      out.write("});\r\n");
      out.write("</script>	\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<!-- header 로고 & 대메뉴,소메뉴 끝 -->\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("<div id=\"index\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

Date rcdt = new Date();
DateFormat rcdf = new SimpleDateFormat("yyyyMMddhms");
String rcdts = rcdf.format(rcdt);

      out.write("  \r\n");
      out.write("<div class=\"sub_title\">\r\n");
      out.write("<section class=\"sub_image\">\r\n");
      out.write("<span>\r\n");
      out.write("최적의 입주환경을 준비하는 입주 전 서비스<br>\r\n");
      out.write("두근두근 설레는 마음, 레미안 입주를 앞둔 고객님을 위한 사전방문 예약 입니다.</span>\r\n");
      out.write("</section>    \r\n");
      out.write("</div>    \r\n");
      out.write("    \r\n");
      out.write("<!-- 예약취소 화면 시작 -->\r\n");
      out.write("    <label class=\"mbship_title\">\r\n");
      out.write("        <p>RESERVATION CANCEL</p>\r\n");
      out.write("        <ul>\r\n");
      out.write("          <li style=\"color: red;\">※ 예약취소시 해당 데이터는 복구 되지 않습니다.</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </label>\r\n");
      out.write("    <form id=\"cancelF\" method=\"post\" action=\"./\">\r\n");
      out.write("      <fieldset class=\"mbship_box\">\r\n");
      out.write("        <h3>예약확인</h3>\r\n");
      out.write("        <span class=\"agree_span\">\r\n");
      out.write("        <ol class=\"mbinfos\">\r\n");
      out.write("        <li><em class=\"ck_font\">■</em> 아이디</li>\r\n");
      out.write("        <li>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rdto.rid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</li>\r\n");
      out.write("        <li><em class=\"ck_font\">■</em> 고객명</li>\r\n");
      out.write("        <li>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rdto.rname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</li>\r\n");
      out.write("        <li><em class=\"ck_font\">■</em> 예약일자</li>\r\n");
      out.write("        <li>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rdto.rdate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</li>\r\n");
      out.write("        <li><em class=\"ck_font\">■</em> 예약시간</li>\r\n");
      out.write("        <li>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rdto.rtime.substring(0,5)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</li>\r\n");
      out.write("        <li><em class=\"ck_font\">■</em> 휴대전화번호</li>\r\n");
      out.write("        <li>\r\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rdto.rtel}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("        </li>\r\n");
      out.write("        <li><em class=\"ck_font\">■</em> 인원수</li>\r\n");
      out.write("        <li>\r\n");
      out.write("        <label class=\"ck_label\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rdto.rcount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("명</label>\r\n");
      out.write("        </li>\r\n");
      out.write("        </ol>\r\n");
      out.write("        </span>\r\n");
      out.write("        <span class=\"span_buttons\">\r\n");
      out.write("        <button type=\"button\" onclick=\"cancel_res(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rdto.ridx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(")\" class=\"next_btn1_1\">예약취소</button>\r\n");
      out.write("        </span>\r\n");
      out.write("      </fieldset>\r\n");
      out.write("    </form>\r\n");
      out.write("<!-- 예약취소 화면 종료 -->\r\n");
      out.write("\r\n");
      out.write("<script src=\"./js/r_cancel.js?v=");
      out.print(rcdts);
      out.write("\"></script>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("  <!-- 카피라이터 시작 -->\r\n");
      out.write("\r\n");
      out.write("<!-- 카피라이터 -->\r\n");
      out.write("	  	<footer id=\"ft\">\r\n");
      out.write("  	    <div>\r\n");
      out.write("              <div class=\"ft-area\">\r\n");
      out.write("                  <div class=\"row\">\r\n");
      out.write("                      <div class=\"col-sm-9 col-xs-12 pull-right\"><!--col-sm-10-->\r\n");
      out.write("                          <div class=\"row\">\r\n");
      out.write("                              <div class=\"col-sm-12 col-xs-12\">\r\n");
      out.write("                                  <p class=\"tit\">인천검단 레미안 주택전시관</p>\r\n");
      out.write("                                  <p class=\"copy\">\r\n");
      out.write("                                    <em>위치</em><span>인천 서구 청라동 22-2</span> <br class=\"m_br\">   \r\n");
      out.write("									&nbsp;<em> LH콜센터</em><span>1688-0123</span>\r\n");
      out.write("                                    <em>주택전시관</em><span>000-123-5678</span>\r\n");
      out.write("                                  </p>\r\n");
      out.write("                              </div>\r\n");
      out.write("                          </div>\r\n");
      out.write("                      </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <p class=\"copyright-p\">\r\n");
      out.write("                      <img src=\"img/logo_ft.png\" class=\"img-responsive center-block\" alt=\"\">\r\n");
      out.write("                  </p>\r\n");
      out.write("                  <div class=\"right-line px-h\"></div>\r\n");
      out.write("              </div>\r\n");
      out.write("  	    </div>\r\n");
      out.write("  	</footer>	<!-- // footer -->\r\n");
      out.write("  <!-- 카피라이터 끝 --></html>");
      out.write("\r\n");
      out.write(" <!-- 카피라이터 종료 -->\r\n");
      out.write("</div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
