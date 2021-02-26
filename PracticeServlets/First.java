import java.io.*;
import javax.servlet.*;
/**
 * First
 */
public class First {

    ServletConfig config;

    public void init(){
//        this.config = config;
        System.out.println("Servelt is initialized.");
    }

    public void service(ServletRequest req, ServletResponse res)
    throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.print("<html><body>");
        out.print("<b>Hello Simple Servlet</b>");
        out.print("</body></html>");
    }

    public void destroy(){
        System.out.println("Servlet is destroyed.");
    }

    public ServletConfig getServletConfig(){return config;}
    
}