package exercice01.exercice01;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "textServlet", value = "/text-servlet")
public class TextServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("TextServlet init");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("<h1>Mon texte brut</h1>");


    }
    @Override
    public void destroy(){
        System.out.println("textServlet destroyed");
        super.destroy();
    }
}
