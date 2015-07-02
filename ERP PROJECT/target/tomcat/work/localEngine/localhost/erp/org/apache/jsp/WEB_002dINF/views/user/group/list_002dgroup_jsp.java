package org.apache.jsp.WEB_002dINF.views.user.group;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_002dgroup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      out.write("<h3>Manage groups</h3>\n");
      out.write("\n");
      out.write("<form class=\"form-horizontal\" role=\"form\" method=\"post\">\n");
      out.write("\t<h3>Search</h3>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<label for=\"lastname\" class=\"col-sm-2 control-label\">Keyword</label>\n");
      out.write("\t\t<div class=\"col-sm-3\">\n");
      out.write("\t\t\t<input name=\"keyword\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Keyword}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"form-group\">\n");
      out.write("\t\t<div class=\"col-sm-offset-2 col-sm-12\">\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn btn-default\">Search</button>\n");
      out.write("\t\t\t<input type=\"button\"\n");
      out.write("\t\t\t\tclass=\"btn btn-default ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${permission_group_add == true ? 'block' : 'none'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"\n");
      out.write("\t\t\t\tonclick=\"edit(0)\" value=\"Add group\">\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<table class=\"table table-bordered\">\n");
      out.write("\t<thead>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<th>No.</th>\n");
      out.write("\t\t\t<th>Group name</th>\n");
      out.write("\t\t\t<th>Description</th>\n");
      out.write("\t\t\t<th>Created date</th>\n");
      out.write("\t\t\t<th>Action</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t</thead>\n");
      out.write("\t<tbody>\n");
      out.write("\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\t</tbody>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<div id=\"groupEdit\" style=\"display: none\">\n");
      out.write("\t<form id=\"add-form\" class=\"form-horizontal\" role=\"form\"\n");
      out.write("\t\taction=\"/erp/user/group/edit\" method=\"post\">\n");
      out.write("\t\t<input type=\"hidden\" id=\"id\" name=\"id\" value=\"0\">\n");
      out.write("\n");
      out.write("\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t<label for=\"firstname\" class=\"col-sm-3 control-label\">Name:</label>\n");
      out.write("\t\t\t<div class=\"col-sm-8\">\n");
      out.write("\t\t\t\t<input type=\"text\" required class=\"form-control\" name=\"name\"\n");
      out.write("\t\t\t\t\tid=\"name\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t<label for=\"firstname\" class=\"col-sm-3 control-label\">Description:</label>\n");
      out.write("\t\t\t<div class=\"col-sm-8\">\n");
      out.write("\t\t\t\t<input type=\"text\" required class=\"form-control\" name=\"description\"\n");
      out.write("\t\t\t\t\tid=\"description\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\n");
      out.write("$(\"#add-form\").validate();\n");
      out.write("\n");
      out.write("function edit(id,name,description){\n");
      out.write("\t\n");
      out.write("\tif(id>0){\n");
      out.write("\t\ttitle =\"Edit group\";\n");
      out.write("\t}else{\n");
      out.write("\t\ttitle= \"Add group\";\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t$(\"#id\").val(id);\n");
      out.write("\t$(\"#name\").val(name);\n");
      out.write("\t$(\"#description\").val(description);\n");
      out.write("\t\n");
      out.write("\t$('#add-form').dialog({\n");
      out.write("\n");
      out.write("\t\tautoOpen : true,\n");
      out.write("\t\tposition : 'center',\n");
      out.write("\t\tmodal : true,\n");
      out.write("\t\tresizable : false,\n");
      out.write("\t\twidth : 440,\n");
      out.write("\t\ttitle: title,\n");
      out.write("\t\tbuttons : {\n");
      out.write("\t\t\t\"OK\" : function() {\n");
      out.write("\t\t\t\t$(\"#add-form\").submit();\n");
      out.write("\t\t\t\t$(this).dialog('close');\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\t\"CANCEL\" : function() {\n");
      out.write("\t\t\t\t$(this).dialog('close');\n");
      out.write("\t\t\t}\n");
      out.write("\t\t},\n");
      out.write("\t\tclose : function() {\n");
      out.write("\n");
      out.write("\t\t\t$(this).dialog('close');\n");
      out.write("\t\t\t\n");
      out.write("\t\t}\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("}\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/user/group/list-group.jsp(40,2) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/user/group/list-group.jsp(40,2) '${listGroup}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${listGroup}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/user/group/list-group.jsp(40,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("Group");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t<tr>\n");
          out.write("\t\t\t\t<td>");
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</td>\n");
          out.write("\t\t\t\t<td>");
          if (_jspx_meth_c_005fout_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</td>\n");
          out.write("\t\t\t\t<td>");
          if (_jspx_meth_c_005fout_005f2(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</td>\n");
          out.write("\t\t\t\t<td>");
          if (_jspx_meth_c_005fout_005f3(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("</td>\n");
          out.write("\t\t\t\t<td width=\"100px\"><nobr>\n");
          out.write("\t\t\t\t\t\t<a class=\"pure-button pure-button-primary ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${permission_group_edit == true ? 'block' : 'none'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"\n");
          out.write("\t\t\t\t\t\t\thref=\"javascript:void(0)\"\n");
          out.write("\t\t\t\t\t\t\tonclick=\"edit(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Group.group_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Group.group_name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Group.description}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("')\">\n");
          out.write("\t\t\t\t\t\t\t<i class=\"fa fa-pencil\"></i>Edit\n");
          out.write("\t\t\t\t\t\t</a> <a class=\"pure-button pure-button-primary ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${permission_group_delete == true ? 'block' : 'none'}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"\n");
          out.write("\t\t\t\t\t\t\tonclick=\"return confirm('Are you sure you want to delete this group?');\"\n");
          out.write("\t\t\t\t\t\t\thref=\"delete/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Group.group_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"> <i class=\"fa fa-times\"></i>Delete\n");
          out.write("\t\t\t\t\t\t</a>\n");
          out.write("\n");
          out.write("\t\t\t\t\t</nobr></td>\n");
          out.write("\t\t\t</tr>\n");
          out.write("\t\t");
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
    // /WEB-INF/views/user/group/list-group.jsp(42,8) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Group.group_id}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/views/user/group/list-group.jsp(43,8) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Group.group_name}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f1 = _jspx_th_c_005fout_005f1.doStartTag();
    if (_jspx_th_c_005fout_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/views/user/group/list-group.jsp(44,8) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Group.description}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f2 = _jspx_th_c_005fout_005f2.doStartTag();
    if (_jspx_th_c_005fout_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/views/user/group/list-group.jsp(45,8) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${Group.create_time}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f3 = _jspx_th_c_005fout_005f3.doStartTag();
    if (_jspx_th_c_005fout_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f3);
    return false;
  }
}
