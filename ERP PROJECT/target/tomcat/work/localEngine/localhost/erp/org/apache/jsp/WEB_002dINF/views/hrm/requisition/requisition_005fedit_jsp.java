package org.apache.jsp.WEB_002dINF.views.hrm.requisition;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class requisition_005fedit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvar_005fvalue_005ftype_005fpattern_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvar_005fvalue_005ftype_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvar_005fvalue_005ftype_005fpattern_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
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
      out.write("<title>Edit Requisition</title>\n");
      out.write("<form id=\"add-form\" class=\"form-horizontal\" role=\"form\" enctype=\"multipart/form-data\"\n");
      out.write("\taction=\"/erp/hrm/requisition/edit\" method=\"post\" onsubmit=\"return checkFile();\">\n");
      out.write("\t<input type=\"hidden\" name=\"requisitionId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.requisition_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t<h3>Requisition Edit</h3>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"firstname\" class=\"col-sm-3 control-label\">Requisition ID:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input required name=\"requisitionIdInput\" type=\"text\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.requisition_id_input}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-3 control-label\">Contract ID:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<select  class=\"form-control contractId\" name=\"contractId\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-3 control-label\">Contract Number:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<select disabled class=\"form-control contractNumber\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</select>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-3 control-label\">Contract Name:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<select disabled class=\"form-control contractName\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</select>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"firstname\" class=\"col-sm-3 control-label\">Requester\n");
      out.write("\t\t\t:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input required name=\"requester\" type=\"text\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.requester}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-3 control-label\">Position Title:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<!-- <input required name=\"title\" type=\"text\" class=\"form-control\" value=\"\"> -->\n");
      out.write("\t\t\t<select class=\"form-control\" name=\"positionId\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-3 control-label\">Required Date:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input required name=\"requiredDate\" class=\"form-control\"\n");
      out.write("\t\t\t\tid=\"from-datepicker\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${formattedRequiredDate}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-3 control-label\">Status:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<select class=\"form-control\" name=\"requisitionStatusId\">\n");
      out.write("\t\t\t\t<option value=\"0\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${0 == targetRequisition.status_id ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Closed</option>\n");
      out.write("\t\t\t\t<option value=\"1\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${1 == targetRequisition.status_id ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Open</option>\n");
      out.write("\t\t\t\t<option value=\"2\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${2 == targetRequisition.status_id ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Pending</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-3 control-label\">Position Salary Range:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input required name=\"salaryRange\" class=\"form-control\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.salary_range}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-3 control-label\">Clearance Level:</label>\n");
      out.write("\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<select class=\"form-control clearanceLvId\" name=\"clearanceLvId\">\n");
      out.write("\t\t\t\t<optgroup label=\"Public Trust\">\n");
      out.write("\t\t\t\t\t<option value=\"1\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==1? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Public Trust/1</option>\n");
      out.write("\t\t\t\t\t<option value=\"2\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==2? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Public Trust/2</option>\n");
      out.write("\t\t\t\t\t<option value=\"3\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==3? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Public Trust/3</option>\n");
      out.write("\t\t\t\t\t<option value=\"4\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==4? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Public Trust/4</option>\n");
      out.write("\t\t\t\t\t<option value=\"5\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==5? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Public Trust/5</option>\n");
      out.write("\t\t\t\t\t<option value=\"6\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==6? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Public Trust/6</option>\n");
      out.write("\t\t\t\t</optgroup>\n");
      out.write("\t\t\t\t<option id=\"clearanceLv_Secret\" value=\"7\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==7? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Secret</option>\n");
      out.write("\t\t\t\t<optgroup label=\"Top Secret\">\n");
      out.write("\t\t\t\t\t<option  value=\"8\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==8? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Top Secret/CI</option>\n");
      out.write("\t\t\t\t\t<option  value=\"9\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==9? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Top Secret/CI with poly</option>\n");
      out.write("\t\t\t\t\t<option  value=\"10\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==10? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Top Secret/SCI</option>\n");
      out.write("\t\t\t\t\t<option  value=\"11\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==11? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Top Secret/SCI with poly</option>\n");
      out.write("\t\t\t\t\t<option  value=\"12\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==12? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Top Secret/CI with full Scope</option>\n");
      out.write("\t\t\t\t\t<option  value=\"13\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.clearance_lv_id ==13? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">Top Secret/CI with lifestyle</option>\n");
      out.write("\t\t\t\t</optgroup>\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-3 control-label\">Certification Requirement :</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<input required name=\"certificateReq\" class=\"form-control\"\n");
      out.write("\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.certificate_req}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-3 control-label\">Education Degree:</label>\n");
      out.write("\t\t<div class=\"col-sm-4\">\n");
      out.write("\t\t\t<select class=\"form-control educationId\" name=\"educationId\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input required type=\"text\" name=\"educationOther\" class=\"form-control educationOther\"\n");
      out.write("\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.education_other}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-3 control-label\"><br>Location:</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<label class=\"col-sm-12 control-label text-left\">City</label>\n");
      out.write("\t\t\t<input required name=\"cityName\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.city_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<label class=\"col-sm-12 control-label text-left\">State</label>\n");
      out.write("\t\t\t<select class=\"form-control stateId\" name=\"stateId\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f5(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"col-sm-2\">\n");
      out.write("\t\t\t<label class=\"col-sm-12 control-label text-left\">Country</label>\n");
      out.write("\t\t\t<select class=\"form-control\" name=\"countryId\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f6(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label class=\"col-sm-3 control-label\">Attachments: </label>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"col-sm-6\">\n");
      out.write("\t\t\t<input required disabled id=\"txtAttachment\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.attachment}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"col-sm-1\">\n");
      out.write("\t\t\t<input id=\"fileAttachment\" type=\"file\" class=\"form-control attachment\" name=\"attachment\" />\n");
      out.write("\t\t\t<input id=\"btnChangeAttachment\" type=\"button\" class=\"btn btn-primary\" value=\"Change\"/>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"col-sm-1\">\n");
      out.write("\t\t\t<a href=\"/erp/file/view/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.attachment}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(".file\" target=\"_blank\" id=\"btnViewAttachment\" class=\"btn btn-primary\">View</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"col-sm-1\">\n");
      out.write("\t\t\t<a href=\"/erp/hrm/requisition/download/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.attachment}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(".file\" class=\"btn btn-primary\">Download</a>\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"oldfile\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.attachment}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<div class=\"col-sm-offset-3 col-sm-1\">\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn btn-danger\">Update</button>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\t$(function() {\n");
      out.write("\t\t$(\"#from-datepicker\").datepicker();\n");
      out.write("\t\t$(\"#to-datepicker\").datepicker();\n");
      out.write("\t\t\n");
      out.write("\t\t$(\".educationOther\").hide();\n");
      out.write("\n");
      out.write("\t\tif($(\".educationOther\").val() != null && $(\".educationOther\").val() != ''){\n");
      out.write("\t\t\t$(\".educationOther\").show();\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t});\n");
      out.write("\t$(\"#add-form\").validate();\n");
      out.write("\tfunction checkFile(){\n");
      out.write("\t\tvar attachment = $('#attachment').val();\n");
      out.write("\t\tif(attachment!='' \n");
      out.write("\t\t&& attachment.indexOf('.doc')==-1\n");
      out.write("\t\t && attachment.indexOf('.pdf')==-1){\n");
      out.write("\t\t\talert('Only pdf, docs support!');\n");
      out.write("\t\t\treturn false;\n");
      out.write("\t\t}\n");
      out.write("\t\treturn true;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t// OnChange event on City dropdown\n");
      out.write("\t$(\".contractId\").change(function() {\n");
      out.write("\t\tvar contractId = $(\".contractId\").val();\n");
      out.write("\t\t$(\".contractNumber\").val(contractId);\n");
      out.write("\t\t$(\".contractName\").val(contractId);\n");
      out.write("\t}); \n");
      out.write("\t\n");
      out.write("\t//$(\".attachment\").slideUp();\n");
      out.write("\t$(\".attachment\").hide();\n");
      out.write("\t\n");
      out.write("\t$(\"#btnChangeAttachment\").click(function(){\n");
      out.write("\t\t$(\"#fileAttachment\").click();\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t$(\"#fileAttachment\").change(function(){\n");
      out.write("\t\talert(\"changed\");\n");
      out.write("\t\t$(\"#txtAttachment\").val($(this).val());\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t$(\"#clearanceLv_Secret\").css(\"font-weight\", \"bold\"); \n");
      out.write("\t\n");
      out.write("\t$(\".educationId\").change(function(){\n");
      out.write("\t\tif($(\".educationId option:selected\").text().trim() === \"Others\"){\n");
      out.write("\t\t\t$(\".educationOther\").show();\n");
      out.write("\t\t}\n");
      out.write("\t\telse{\n");
      out.write("\t\t\t$(\".educationOther\").hide();\n");
      out.write("\t\t\t$(\".educationOther\").val(null);\n");
      out.write("\t\t}\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("</script>\n");
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
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(6,0) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${targetRequisition.required_date}", java.util.Date.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setVar("formattedRequiredDate");
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(6,0) name = type type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setType("date");
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(6,0) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setPattern("MM/dd/yyyy");
    int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvar_005fvalue_005ftype_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvar_005fvalue_005ftype_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(26,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/hrm/requisition/requisition_edit.jsp(26,4) '${ListContract}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${ListContract}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(26,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("Contract");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Contract.contract_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Contract.contract_id == targetRequisition.contract_id ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(">\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\n");
          out.write("\t\t\t\t\t</option>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(28,6) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Contract.contract_id_input}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(39,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/hrm/requisition/requisition_edit.jsp(39,4) '${ListContract}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${ListContract}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(39,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("Contract");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Contract.contract_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Contract.contract_id == targetRequisition.contract_id ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(">\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f1(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write("\n");
          out.write("\t\t\t\t\t</option>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(41,6) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Contract.contract_number}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f2.setParent(null);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(52,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/hrm/requisition/requisition_edit.jsp(52,4) '${ListContract}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${ListContract}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(52,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f2.setVar("Contract");
    int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
      if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Contract.contract_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Contract.contract_id == targetRequisition.contract_id ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(">\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fforEach_005f2, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f2))
            return true;
          out.write("\n");
          out.write("\t\t\t\t\t</option>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f2.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f2);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(54,6) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Contract.contract_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f3.setParent(null);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(75,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/hrm/requisition/requisition_edit.jsp(75,4) '${ListPosition}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${ListPosition}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(75,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f3.setVar("Position");
    int[] _jspx_push_body_count_c_005fforEach_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f3 = _jspx_th_c_005fforEach_005f3.doStartTag();
      if (_jspx_eval_c_005fforEach_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Position.position_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"\n");
          out.write("\t\t\t\t\t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Position.position_id == targetRequisition.position_id ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(">\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f3(_jspx_th_c_005fforEach_005f3, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f3))
            return true;
          out.write("\n");
          out.write("\t\t\t\t\t</option>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f3.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f3)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f3);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(78,6) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Position.position_title}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f4 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f4.setParent(null);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(148,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/hrm/requisition/requisition_edit.jsp(148,4) '${ListEducation}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${ListEducation}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(148,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f4.setVar("Education");
    int[] _jspx_push_body_count_c_005fforEach_005f4 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f4 = _jspx_th_c_005fforEach_005f4.doStartTag();
      if (_jspx_eval_c_005fforEach_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Education.education_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"\n");
          out.write("\t\t\t\t\t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Education.education_id == targetRequisition.education_id ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(">\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f4(_jspx_th_c_005fforEach_005f4, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f4))
            return true;
          out.write("\n");
          out.write("\t\t\t\t\t</option>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f4.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f4);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f4, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f4)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f4);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(151,6) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Education.education_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f4 = _jspx_th_c_005fout_005f4.doStartTag();
    if (_jspx_th_c_005fout_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f5 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f5.setParent(null);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(171,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f5.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/hrm/requisition/requisition_edit.jsp(171,4) '${ListState}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${ListState}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(171,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f5.setVar("State");
    int[] _jspx_push_body_count_c_005fforEach_005f5 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f5 = _jspx_th_c_005fforEach_005f5.doStartTag();
      if (_jspx_eval_c_005fforEach_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${State.state_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${State.state_id == targetRequisition.state_id ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(">\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f5(_jspx_th_c_005fforEach_005f5, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f5))
            return true;
          out.write("\n");
          out.write("\t\t\t\t\t</option>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f5.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f5.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f5);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f5, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f5)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f5);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(173,6) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${State.state_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f5 = _jspx_th_c_005fout_005f5.doStartTag();
    if (_jspx_th_c_005fout_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f6 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f6.setParent(null);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(181,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f6.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/hrm/requisition/requisition_edit.jsp(181,4) '${ListCountry}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${ListCountry}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(181,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f6.setVar("Country");
    int[] _jspx_push_body_count_c_005fforEach_005f6 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f6 = _jspx_th_c_005fforEach_005f6.doStartTag();
      if (_jspx_eval_c_005fforEach_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Country.country_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"\n");
          out.write("\t\t\t\t\t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Country.country_id == targetRequisition.country_id ? 'selected' : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(">\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_005fout_005f6(_jspx_th_c_005fforEach_005f6, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f6))
            return true;
          out.write("\n");
          out.write("\t\t\t\t\t</option>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f6.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f6[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f6.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f6.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f6);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f6, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f6)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f6 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f6);
    // /WEB-INF/views/hrm/requisition/requisition_edit.jsp(184,6) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Country.country_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f6 = _jspx_th_c_005fout_005f6.doStartTag();
    if (_jspx_th_c_005fout_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f6);
    return false;
  }
}
