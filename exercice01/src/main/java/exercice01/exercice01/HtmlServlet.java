package exercice01.exercice01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "htmlServlet", value = "/html-servlet")
public class HtmlServlet extends HttpServlet {
    @Override
    public void init()throws ServletException {
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet JSPServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Ceci est un titre en HTML</h1>");
        out.println("</body>");
        out.println("</html>");

    }
    @Override
    public void destroy(){
        super.destroy();
    }
}
