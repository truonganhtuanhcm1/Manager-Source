package org.apache.jsp.WEB_002dINF.views.hrm.recruitment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class candidate_005ftracker_005fedit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvar_005fvalue_005ftype_005fpattern_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvar_005fvalue_005ftype_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvar_005fvalue_005ftype_005fpattern_005fnobody.release();
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
      if (_jspx_meth_fmt_005fformatDate_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("<title>Edit Candidate Tracker</title>\n");
      out.write("<form id=\"add-form\" class=\"form-horizontal\" role=\"form\"\n");
      out.write("\taction=\"/erp/hrm/recruitment/add\" method=\"post\">\n");
      out.write("\t<input type=\"hidden\" name=\"id\">\n");
      out.write("\t<h3>Candidate Edit</h3>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"firstname\" class=\"col-sm-3 control-label\"><br>Candidate\n");
      out.write("\t\t\tName:</label>\n");
      out.write("\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t<label for=\"firstname\" class=\"col-sm-12 control-label\">First\n");
      out.write("\t\t\t\tName </label> <input required name=\"title\" type=\"text\" class=\"form-control\"\n");
      out.write("\t\t\t\tvalue=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t<label for=\"firstname\" class=\"col-sm-12 control-label\">Last\n");
      out.write("\t\t\t\tName </label> <input required name=\"title\" type=\"text\" class=\"form-control\"\n");
      out.write("\t\t\t\tvalue=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t<label for=\"firstname\" class=\"col-sm-12 control-label\">M.I\n");
      out.write("\t\t\t\t </label> <input required name=\"title\" type=\"text\" class=\"form-control\"\n");
      out.write("\t\t\t\tvalue=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Status:</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<select class=\"form-control\">\n");
      out.write("\t\t\t\t<option>Hired</option>\n");
      out.write("\t\t\t\t<option>Interview</option>\n");
      out.write("\t\t\t\t<option>Pending</option>\n");
      out.write("\t\t\t\t<option>Opened</option>\n");
      out.write("\t\t\t\t<option>Closed</option>\n");
      out.write("\t\t\t\t<option>Sent to client</option>\n");
      out.write("\t\t\t\t<option>Others</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input required name=\"title\" type=\"text\" class=\"form-control\"\n");
      out.write("\t\t\t\tvalue=\"Others\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"firstname\" class=\"col-sm-3 control-label\">Job Location\n");
      out.write("\t\t\t:</label>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<input name=\"\" class=\"form-control\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"firstname\" class=\"col-sm-3 control-label\">Refered Location\n");
      out.write("\t\t\t:</label>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<input name=\"\" class=\"form-control\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Candidate\n");
      out.write("\t\t\tSalary Range:</label>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<input required name=\"title\" type=\"text\" class=\"form-control\"\n");
      out.write("\t\t\t\tvalue=\"ABC Project\">\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"firstname\" class=\"col-sm-3 control-label\">Education | Degree\n");
      out.write("\t\t\t:</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<select class=\"form-control\">\n");
      out.write("\t\t\t\t<option>BS</option>\n");
      out.write("\t\t\t\t<option>MS</option>\n");
      out.write("\t\t\t\t<option>BA</option>\n");
      out.write("\t\t\t\t<option>MBA</option>\n");
      out.write("\t\t\t\t<option>Others</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"firstname\" class=\"col-sm-3 control-label\">Experience\n");
      out.write("\t\t\t:</label>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<input required name=\"title\" type=\"text\" class=\"form-control\"\n");
      out.write("\t\t\t\tvalue=\"aaaa\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Email\n");
      out.write("\t\t\tAddress :</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input required name=\"title\" type=\"text\" class=\"form-control\"\n");
      out.write("\t\t\t\tvalue=\"\">\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Phone\n");
      out.write("\t\t\tNumber :</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input required name=\"expiredDate\" class=\"form-control\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Email\n");
      out.write("\t\t\tDate :</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input required name=\"expiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tid=\"email-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Call Date\n");
      out.write("\t\t\t:</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input required name=\"expiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tid=\"call-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Phone\n");
      out.write("\t\t\tScreen Date:</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input required name=\"expiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tid=\"phone-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Comments\n");
      out.write("\t\t\tfrom Candidate:</label>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<textarea required=\"\" name=\"description\" rows=\"4\"\n");
      out.write("\t\t\t\tclass=\"form-control\" aria-required=\"true\"></textarea>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">DVS\n");
      out.write("\t\t\tComments:</label>\n");
      out.write("\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<textarea required=\"\" name=\"description\" rows=\"4\"\n");
      out.write("\t\t\t\tclass=\"form-control\" aria-required=\"true\"></textarea>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Position\n");
      out.write("\t\t\t:</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input required name=\"expiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tid=\"from-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Alternative\n");
      out.write("\t\t\tPositions :</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input required name=\"expiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tid=\"from-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"><br>Address:</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<label for=\"lastname\" class=\"col-sm-12 control-label text-left\">Street</label>\n");
      out.write("\t\t\t<input required name=\"expiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tid=\"from-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<label for=\"lastname\" class=\"col-sm-12 control-label text-left\">City</label>\n");
      out.write("\t\t\t<input required name=\"expiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tid=\"from-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<label for=\"lastname\" class=\"col-sm-12 control-label text-left\">State</label>\n");
      out.write("\t\t\t<select class=\"form-control\">\n");
      out.write("\t\t\t\t<option>Texas</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t<label for=\"lastname\" class=\"col-sm-12 control-label text-left\">Zip\n");
      out.write("\t\t\t\tCode</label> <input required name=\"expiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tid=\"from-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t<label for=\"lastname\" class=\"col-sm-12 control-label text-left\">Country</label>\n");
      out.write("\t\t\t<select class=\"form-control\">\n");
      out.write("\t\t\t\t<option>US</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Best Time\n");
      out.write("\t\t\tto Contract: </label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input required name=\"expiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tvalue=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Clearance\n");
      out.write("\t\t\tLevel:</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<select class=\"form-control clearanceLvId\" name=\"clearanceLvId\">\n");
      out.write("\t\t\t\t<optgroup label=\"Pulbic Trust\">\n");
      out.write("\t\t\t\t\t<option value=\"1\">1</option>\n");
      out.write("\t\t\t\t\t<option value=\"2\">2</option>\n");
      out.write("\t\t\t\t\t<option value=\"3\">3</option>\n");
      out.write("\t\t\t\t\t<option value=\"4\">4</option>\n");
      out.write("\t\t\t\t\t<option value=\"5\">5</option>\n");
      out.write("\t\t\t\t\t<option value=\"6\">6</option>\n");
      out.write("\t\t\t\t</optgroup>\n");
      out.write("\t\t\t\t<option value=\"7\">Secret</option>\n");
      out.write("\t\t\t\t<optgroup label=\"Top Secret\">\n");
      out.write("\t\t\t\t\t<option  value=\"8\">CI</option>\n");
      out.write("\t\t\t\t\t<option  value=\"9\">CI with poly</option>\n");
      out.write("\t\t\t\t\t<option  value=\"10\">SCI</option>\n");
      out.write("\t\t\t\t\t<option  value=\"11\">SCI with poly</option>\n");
      out.write("\t\t\t\t</optgroup>\n");
      out.write("\t\t\t\t<option  value=\"12\">etc.</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"clearance_etc\"  style=\"display:none;\">\n");
      out.write("\t\t\t<label for=\"lastname\" class=\"col-sm-1 control-label\">\n");
      out.write("\t\t\t\tOther:</label>\n");
      out.write("\t\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t\t<input required name=\"clearance_etc\" class=\"form-control \" type=\"text\"\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${clearance_etc}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Certifications:\n");
      out.write("\t\t</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input required name=\"expiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tid=\"from-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Requisition\n");
      out.write("\t\t\tID :</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<select class=\"form-control valid\" aria-invalid=\"false\">\n");
      out.write("\t\t\t\t<option>001</option>\n");
      out.write("\t\t\t\t<option>002</option>\n");
      out.write("\t\t\t\t<option>003</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label> <label\n");
      out.write("\t\t\tfor=\"lastname\" class=\"col-sm-9 control-label\"\n");
      out.write("\t\t\tstyle=\"text-align: left;\">Has the candidate have aquired\n");
      out.write("\t\t\tsimilar skills or quanlifications through past work experiences?</label>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<textarea required=\"\" name=\"description\" rows=\"4\"\n");
      out.write("\t\t\t\tclass=\"form-control\" aria-required=\"true\"></textarea>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label> <label\n");
      out.write("\t\t\tfor=\"lastname\" class=\"col-sm-9 control-label\"\n");
      out.write("\t\t\tstyle=\"text-align: left;\">Does the candidate have the\n");
      out.write("\t\t\tappropridate education background?</label>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<textarea required=\"\" name=\"description\" rows=\"4\"\n");
      out.write("\t\t\t\tclass=\"form-control\" aria-required=\"true\"></textarea>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label> <label\n");
      out.write("\t\t\tfor=\"lastname\" class=\"col-sm-9 control-label\"\n");
      out.write("\t\t\tstyle=\"text-align: left;\">Does the candidate have the\n");
      out.write("\t\t\ttechnical skills necessary for this position?</label>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<textarea required=\"\" name=\"description\" rows=\"4\"\n");
      out.write("\t\t\t\tclass=\"form-control\" aria-required=\"true\"></textarea>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label> <label\n");
      out.write("\t\t\tfor=\"lastname\" class=\"col-sm-9 control-label\"\n");
      out.write("\t\t\tstyle=\"text-align: left;\">Were the candidate's salary\n");
      out.write("\t\t\texpectations within the range for the position?</label>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<input required name=\"expiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tid=\"from-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label> <label\n");
      out.write("\t\t\tfor=\"lastname\" class=\"col-sm-9 control-label\"\n");
      out.write("\t\t\tstyle=\"text-align: left;\">Did the candidate demonstrate,\n");
      out.write("\t\t\tthrough their answers, good teambuilding/interpersonal skills?</label>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<textarea required=\"\" name=\"description\" rows=\"4\"\n");
      out.write("\t\t\t\tclass=\"form-control\" aria-required=\"true\"></textarea>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label> <label\n");
      out.write("\t\t\tfor=\"lastname\" class=\"col-sm-9 control-label\"\n");
      out.write("\t\t\tstyle=\"text-align: left;\">Did the candidate demonstrate,\n");
      out.write("\t\t\tthrough their answers, a high degree of initiative?</label>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\"></label>\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<textarea required=\"\" name=\"description\" rows=\"4\"\n");
      out.write("\t\t\t\tclass=\"form-control\" aria-required=\"true\"></textarea>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-3 control-label\">Avaliable Start Date:</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input required name=\"expiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tid=\"start-datepicker\" value=\"\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<div class=\"col-sm-offset-3 col-sm-1\">\n");
      out.write("\t\t\t<a href='/erp/hrm/recruitment/candidate_tracker_list' type=\"submit\" class=\"btn btn-danger\">Create</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\t$(function() {\n");
      out.write("\t\t$(\"#email-datepicker\").datepicker();\n");
      out.write("\t\t$(\"#call-datepicker\").datepicker();\n");
      out.write("\t\t$(\"#phone-datepicker\").datepicker();\n");
      out.write("\t\t$(\"#best-datepicker\").datepicker();\n");
      out.write("\t\t$(\"#start-datepicker\").datepicker();\n");
      out.write("\t});\n");
      out.write("\t$(\"#add-form\").validate();\n");
      out.write("\t\n");
      out.write("\t$( \".clearanceLvId\" ).change(function() {\n");
      out.write("\t\tvar text = $( \".clearanceLvId\" ).val();\n");
      out.write("\t  \tif(text==12){\n");
      out.write("\t  \t\t$('.clearance_etc').show();\n");
      out.write("\t  \t}else{\n");
      out.write("\t  \t\t$('.clearance_etc').hide();\n");
      out.write("\t  \t}\n");
      out.write("\t});\n");
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

  private boolean _jspx_meth_fmt_005fformatDate_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvar_005fvalue_005ftype_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f0.setParent(null);
    // /WEB-INF/views/hrm/recruitment/candidate_tracker_edit.jsp(6,0) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recruit.expired_date}", java.util.Date.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/views/hrm/recruitment/candidate_tracker_edit.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setVar("formattedDate");
    // /WEB-INF/views/hrm/recruitment/candidate_tracker_edit.jsp(6,0) name = type type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setType("date");
    // /WEB-INF/views/hrm/recruitment/candidate_tracker_edit.jsp(6,0) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setPattern("MM/dd/yyyy");
    int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvar_005fvalue_005ftype_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvar_005fvalue_005ftype_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
    return false;
  }
}
