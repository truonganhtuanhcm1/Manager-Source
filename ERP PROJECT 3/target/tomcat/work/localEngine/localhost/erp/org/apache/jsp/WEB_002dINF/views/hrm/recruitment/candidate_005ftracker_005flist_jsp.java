package org.apache.jsp.WEB_002dINF.views.hrm.recruitment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class candidate_005ftracker_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>List Candidate</title>\n");
      out.write("<form class=\"form-horizontal\" role=\"form\">\n");
      out.write("\t<h3>Candidate Search</h3>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"firstname\" class=\"col-sm-2 control-label\">Keywords\n");
      out.write("\t\t\t:</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input name=\"\" class=\"form-control\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-2 control-label\">Status:</label>\n");
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
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"firstname\" class=\"col-sm-2 control-label\">Position\n");
      out.write("\t\t\t:</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input name=\"\" class=\"form-control\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-2 control-label\">Requisition\n");
      out.write("\t\t\tID:</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input name=\"from_date\" class=\"form-control\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn btn-default\">Search</button>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<table class=\"table table-bordered\">\n");
      out.write("\t<thead>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<th>No.</th>\n");
      out.write("\t\t\t<th>Requisition ID</th>\n");
      out.write("\t\t\t<th>Candidate Name</th>\n");
      out.write("\t\t\t<th>Position</th>\n");
      out.write("\t\t\t<th>Phone Number</th>\n");
      out.write("\t\t\t<th>Status</th>\n");
      out.write("\t\t\t<th>Action</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t</thead>\n");
      out.write("\t<tbody>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>1</td>\n");
      out.write("\t\t\t<td>001</td>\n");
      out.write("\t\t\t<td>ABC Project</td>\n");
      out.write("\t\t\t<td>ABC Title</td>\n");
      out.write("\n");
      out.write("\t\t\t<td>12312413413</td>\n");
      out.write("\t\t\t<td>Hired</td>\n");
      out.write("\t\t\t<td width=\"100px\"><nobr>\n");
      out.write("\t\t\t\t\t<a class=\"pure-button pure-button-primary block\"\n");
      out.write("\t\t\t\t\t\thref=\"/erp/hrm/recruitment/candidate_tracker_edit\"> <i\n");
      out.write("\t\t\t\t\t\tclass=\"fa fa-pencil\"></i>Edit\n");
      out.write("\t\t\t\t\t</a>  <a class=\"pure-button pure-button-primary block\"\n");
      out.write("\t\t\t\t\t\tonclick=\"return confirm('Are you sure you want to delete this recruitment?');\"\n");
      out.write("\t\t\t\t\t\thref=\"delete/1\"> <i class=\"fa fa-times\"></i>View\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\n");
      out.write("\t\t\t\t</nobr></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>2</td>\n");
      out.write("\t\t\t<td>002</td>\n");
      out.write("\t\t\t<td>ABC Project</td>\n");
      out.write("\t\t\t<td>ABC Title</td>\n");
      out.write("\t\t\t<td>23135123</td>\n");
      out.write("\t\t\t<td>Not Hired</td>\n");
      out.write("\t\t\t<td width=\"100px\"><nobr>\n");
      out.write("\t\t\t\t\t<a class=\"pure-button pure-button-primary block\"\n");
      out.write("\t\t\t\t\t\thref=\"/erp/hrm/recruitment/candidate_tracker_edit\"> <i\n");
      out.write("\t\t\t\t\t\tclass=\"fa fa-pencil\"></i>Edit\n");
      out.write("\t\t\t\t\t</a> <a class=\"pure-button pure-button-primary block\"\n");
      out.write("\t\t\t\t\t\tonclick=\"return confirm('Are you sure you want to delete this recruitment?');\"\n");
      out.write("\t\t\t\t\t\thref=\"delete/1\"> <i class=\"fa fa-times\"></i>View\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\n");
      out.write("\t\t\t\t</nobr></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t</tbody>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\t$(function() {\n");
      out.write("\t\t$(\"#from-datepicker\").datepicker();\n");
      out.write("\t\t$(\"#to-datepicker\").datepicker();\n");
      out.write("\t});\n");
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

  private boolean _jspx_meth_fmt_005fformatDate_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvar_005fvalue_005ftype_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f0.setParent(null);
    // /WEB-INF/views/hrm/recruitment/candidate_tracker_list.jsp(6,0) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recruit.expired_date}", java.util.Date.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/views/hrm/recruitment/candidate_tracker_list.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setVar("formattedDate");
    // /WEB-INF/views/hrm/recruitment/candidate_tracker_list.jsp(6,0) name = type type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setType("date");
    // /WEB-INF/views/hrm/recruitment/candidate_tracker_list.jsp(6,0) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
