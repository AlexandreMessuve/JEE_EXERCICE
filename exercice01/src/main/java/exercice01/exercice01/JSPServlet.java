package exercice01.exercice01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "jspServlet", value = "/jps-servlet")
public class JSPServlet extends HttpServlet {
    @Override
    public void init()throws ServletException {
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/page.jsp").forward(req, resp);
    }
    @Override
    public void destroy(){
        super.destroy();
    }
}