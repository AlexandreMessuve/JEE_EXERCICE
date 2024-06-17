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
        if (req.getSession().getAttribute("email") == null && req.getSession().getAttribute("isLoggedIn") == null) {
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
                default:
                    resp.sendRedirect(getServletContext().getContextPath());
                    break;
            }
        }else {
            switch (action){
                case "profile":
                    profile(req, resp);
                    break;
                case "update":
                    updateForm(req, resp);
                    break;
                case "updateProfile":
                    updateProfile(req, resp);
                    break;
                case "delete":
                    deleteUser(req, resp);
                    break;
                case "logout":
                    logout(req, resp);
                    break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void profile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "profile");
        if (req.getSession().getAttribute("email") == null && req.getSession().getAttribute("isLoggedIn") == null) {
            resp.sendRedirect(getServletContext().getContextPath() + "/user/loginForm");
        }
        String email = (String) req.getSession().getAttribute("email");
        User user = userService.getUser(email);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/page/user/userProfile.jsp").forward(req, resp);

    }
    protected  void loginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "login");
        if (req.getAttribute("error") == null){
            req.setAttribute("error", "");
        }
        showForm(req, resp);
    }
    protected void registerForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "register");
        if (req.getAttribute("error") == null){
            req.setAttribute("error", "");
        }
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
            req.getSession().setAttribute("email", user.getEmail());
            req.getSession().setAttribute("isLoggedIn", true);
            resp.sendRedirect(getServletContext().getContextPath()+"/products/list");
        }else {
            req.setAttribute("error", "Invalid email or password");
           loginForm(req, resp);
        }
    }
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        User user = userService.getUser(email);
        if (user != null){
            req.setAttribute("error", "Error registered user");
            registerForm(req, resp);
        }else{
            if (!password.equals(confirmPassword)) {
                req.setAttribute("error", "Passwords do not match");
                registerForm(req, resp);
            }else{
                if (userService.createUser(email, password)){
                    resp.sendRedirect(getServletContext().getContextPath()+"/user/loginForm");
                }else {
                    req.setAttribute("error", "Error registered user");
                    registerForm(req, resp);
                }
            }
        }
    }

    protected void updateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "update");
        if(req.getAttribute("error") == null){
            req.setAttribute("error", "");
        }
        String email = (String) req.getSession().getAttribute("email");
        User user = userService.getUser(email);
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/WEB-INF/page/user/userProfile.jsp").forward(req, resp);
    }
    protected void updateProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        if (userService.updateUser(id, firstName, lastName)) {
            resp.sendRedirect(getServletContext().getContextPath()+"/user/profile");
        }else{
            resp.sendRedirect(getServletContext().getContextPath()+"/user/update");
        }

    }

    protected void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if (userService.deleteUser(id)){
            logout(req, resp);
        }else{
            resp.sendRedirect(getServletContext().getContextPath()+"/user/profile");
        }
    }
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(getServletContext().getContextPath());
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
