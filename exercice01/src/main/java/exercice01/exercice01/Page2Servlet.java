package exercice01.exercice01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "page2", value = "/page2")
public class Page2Servlet extends HttpServlet {
    @Override
    public void init()throws ServletException {
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/page2.jsp").forward(req, resp);
    }
    @Override
    public void destroy(){
        super.destroy();
    }
}