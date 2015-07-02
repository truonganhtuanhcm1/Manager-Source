package org.apache.jsp.WEB_002dINF.views.hrm.contract;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contract_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<title>Create Contract</title>\n");
      out.write("<form id=\"add-form\" class=\"form-horizontal\" role=\"form\" enctype=\"multipart/form-data\"\n");
      out.write("\taction=\"/erp/hrm/contract/add\" method=\"post\" >\n");
      out.write("\t<h3>Create Contract</h3>\n");
      out.write("\t\n");
      out.write("\t<input type=\"hidden\" name=\"contractId\" value=\"\">\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-2 control-label\">Contract ID:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input required name=\"contractIdInput\" class=\"form-control\" value=\"\">\n");
      out.write("\t\t</div>\t\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-2 control-label\">Contract Number:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input required name=\"contractNumber\" class=\"form-control\" value=\"\">\n");
      out.write("\t\t</div>\t\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-2 control-label\">Contract Name:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input required name=\"contractName\" class=\"form-control\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-2 control-label\">Description:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input name=\"description\" class=\"form-control\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-2 control-label\">Modification:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input  name=\"modification\" type=\"text\" class=\"form-control\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-2 control-label\">Value:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input  name=\"value\" type=\"text\" class=\"form-control\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-2 control-label\">Start Date:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input required name=\"startDate\" class=\"form-control\" id=\"from-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-2 control-label\">End Date:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input required name=\"endDate\" class=\"form-control\" id=\"to-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn btn-danger\">Create</button>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\t$(function() {\n");
      out.write("\t\t$(\"#from-datepicker\").datepicker();\n");
      out.write("\t\t$(\"#to-datepicker\").datepicker();\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t$(\"#add-form\").validate();\n");
      out.write("</script>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
