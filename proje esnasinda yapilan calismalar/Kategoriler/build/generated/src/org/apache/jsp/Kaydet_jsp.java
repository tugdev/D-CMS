package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.kategori.Kategoriler;
import java.util.List;
import com.kategori.KategorilerJpaController;

public final class Kaydet_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                KategorilerJpaController katCont;
                List<Kategoriler> katListesi;
            
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_f_view;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_f_view = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_f_view.release();
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      //  f:view
      com.sun.faces.taglib.jsf_core.ViewTag _jspx_th_f_view_0 = new com.sun.faces.taglib.jsf_core.ViewTag();
      if (_jspx_resourceInjector != null) {
        _jspx_resourceInjector.inject(_jspx_th_f_view_0        );
      }
      _jspx_th_f_view_0.setPageContext(_jspx_page_context);
      _jspx_th_f_view_0.setParent(null);
      _jspx_th_f_view_0.setJspId("id15");
      int _jspx_eval_f_view_0 = _jspx_th_f_view_0.doStartTag();
      if (_jspx_eval_f_view_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_f_view_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_f_view_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_f_view_0.doInitBody();
        }
        do {
          out.write("\n");
          out.write("    <html>\n");
          out.write("        <head>\n");
          out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n");
          out.write("            <title>JSP Page</title>\n");
          out.write("        </head>\n");
          out.write("        <body>\n");
          out.write("            ");
          out.write("\n");
          out.write("            ");

                katCont=new KategorilerJpaController();
                katListesi=new ArrayList<Kategoriler>();


            
          out.write("\n");
          out.write("            ");

                katListesi=katCont.findKategorilerEntities(katCont.getKategorilerCount(), 0);
            
          out.write("\n");
          out.write("\n");
          out.write("            <form action=\"KayBitir.jsp\">\n");
          out.write("                <table>\n");
          out.write("                <tr>\n");
          out.write("                    <td>Kategori Adi:</td>\n");
          out.write("                    <td><input type=\"text\" name=\"ad\"/></td>\n");
          out.write("                </tr>\n");
          out.write("                <tr>\n");
          out.write("                    <td>Ust Kategori:</td>\n");
          out.write("                    <td>\n");
          out.write("                        <select name=\"secilen\">\n");
          out.write("                            <option value=\"0\">Ana Kategori</option>\n");
          out.write("                            ");

                            for(Kategoriler i:katListesi){
                            
          out.write("\n");
          out.write("                            <option value=\"");
          out.print(i.getKategoriId());
          out.write('"');
          out.write('>');
          out.print(i.getKategoriAdi());
          out.write("</option>\n");
          out.write("                            ");

                            }
                            
          out.write("\n");
          out.write("                        </select>\n");
          out.write("                    </td>\n");
          out.write("                </tr>\n");
          out.write("                <tr>\n");
          out.write("                    <td><input type=\"submit\" value=\"Gonder\"/></td>\n");
          out.write("                    <td><input type=\"reset\" value=\"Temizle\"/></td>\n");
          out.write("                </tr>\n");
          out.write("            </table>\n");
          out.write("            </form>\n");
          out.write("            \n");
          out.write("            \n");
          out.write("        </body>\n");
          out.write("    </html>\n");
          int evalDoAfterBody = _jspx_th_f_view_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_f_view_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_f_view_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_f_view.reuse(_jspx_th_f_view_0);
        return;
      }
      _jspx_tagPool_f_view.reuse(_jspx_th_f_view_0);
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
