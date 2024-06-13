package org.exercice06.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.exercice06.service.ProductService;

import java.io.IOException;

@WebServlet(name = "product", value = "/products/*")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null && req.getSession().getAttribute("isLoggedIn") != null) {
            String action = req.getContextPath().substring(1);
        }else{
            resp.sendRedirect(getServletContext().getContextPath());
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/page/product/formProduct.jsp").forward(req, resp);
    }
    protected void addForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "add");
        showForm(req, resp);

    }
    protected void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //implementation du code
    }
    protected void updateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "update");
        showForm(req, resp);
    }
    protected void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
