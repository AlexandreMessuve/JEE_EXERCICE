package org.exercice06.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.exercice06.entity.User;
import org.exercice06.service.UserService;

import java.io.IOException;

@WebServlet(name = "user", value = "/user/*")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    public void init(){
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        switch (action) {
            case "loginForm":
                loginForm(req, resp);
                break;
            case "registerForm":
                registerForm(req, resp);
                break;
            case "login":
                login(req, resp);
                break;
            case "register":
                register(req, resp);
                break;
            case "logout":
                logout(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected  void loginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "login");
        showForm(req, resp);
    }
    protected void registerForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "register");
        showForm(req, resp);
    }

    protected void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/page/auth/userForm.jsp").forward(req, resp);
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userService.getUser(email);
        System.out.println(user);
        if (user != null && user.getPassword().equals(password)) {
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("isLoggedIn", true);
            resp.sendRedirect(getServletContext().getContextPath());
        }else {
           loginForm(req, resp);
        }
    }
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (userService.createUser(email, password)){
            loginForm(req, resp);
        }else {
            registerForm(req, resp);
        }
    }
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(getServletContext().getContextPath());
    }
}
