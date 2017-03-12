package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Hello World</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<form action=\"hello\" method=\"post\">\n");
      out.write("<table>\n");
      out.write("<tr>\n");
      out.write("<td><label>Kwota kredytu:</label></td>\n");
      out.write("<td><input type=\"number\" name=\"amount\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><label>Ilość rat:</label></td>\n");
      out.write("<td><input type=\"number\" name=\"rates_count\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><label>Oprocentowanie:</label></td>\n");
      out.write("<td><input type=\"number\" name=\"percent\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><label>Opłata stała:</label></td>\n");
      out.write("<td><input type=\"number\" name=\"const_rate_amount\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><label>Rodzaj rat:</label></td>\n");
      out.write("<td>\n");
      out.write("<input type=\"radio\" name=\"rates_type\" value=\"decrease\">Malejące\n");
      out.write("<input type=\"radio\" name=\"rates_type\" value=\"const\">Stałe\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("<br/>\n");
      out.write("<input type=\"submit\" value=\"Harmonogram spłat >\">\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
