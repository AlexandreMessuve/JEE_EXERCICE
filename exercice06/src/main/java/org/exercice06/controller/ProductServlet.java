package org.exercice06.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.exercice06.entity.Product;
import org.exercice06.service.ProductService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "product", value = "/products/*")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("user") != null && req.getSession().getAttribute("isLoggedIn") != null) {
            String action = req.getPathInfo().substring(1);
            System.out.println(action);
            switch (action) {
                case "detail":
                    detailProduct(req, resp);
                    break;
                case "addForm":
                    addForm(req, resp);
                    break;
                case "add":
                    addProduct(req, resp);
                    break;
                case "updateForm":
                    updateForm(req, resp);
                    break;
                case "update":
                    updateProduct(req, resp);
                    break;
                case "delete":
                    deleteProduct(req, resp);
                    break;
                default:
                    list(req, resp);
                    break;
            }
        }else{
            resp.sendRedirect(getServletContext().getContextPath());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void detailProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.getProduct(id);
        if (product != null) {
            req.setAttribute("product", product);
            getServletContext().getRequestDispatcher("/WEB-INF/page/product/productDetail.jsp").forward(req, resp);
        }else {
            resp.setStatus(404);
            resp.sendRedirect(getServletContext().getContextPath()+"/product/list");
        }
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getProducts();
        req.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/WEB-INF/page/product/productList.jsp").forward(req, resp);
    }
    protected void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/page/product/formProduct.jsp").forward(req, resp);
    }
    protected void addForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "add");
        Product product = new Product();
        req.setAttribute("product", product);
        showForm(req, resp);

    }
    protected void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String ref = req.getParameter("ref");
        LocalDateTime purchaseDate = LocalDateTime.parse(req.getParameter("purchaseDate"));
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        if(productService.createProduct(brand, ref, purchaseDate, price, stock)){
            resp.setStatus(201);
            resp.sendRedirect(getServletContext().getContextPath()+"/products/list");
        }else {
            resp.setStatus(400);
            addForm(req, resp);
        }

    }
    protected void updateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.getProduct(id);
        if (product == null) {
            resp.setStatus(404);
            resp.sendRedirect(getServletContext().getContextPath()+"/products/list");
        }
        req.setAttribute("mode", "update");
        req.setAttribute("product", product);
        showForm(req, resp);
    }
    protected void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String brand = req.getParameter("brand");
        String ref = req.getParameter("ref");
        LocalDateTime purchaseDate = LocalDateTime.parse(req.getParameter("purchaseDate"));
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        if(productService.updateProduct(id, brand, ref, purchaseDate, price, stock)){
            resp.setStatus(202);
            resp.sendRedirect(getServletContext().getContextPath()+"/products/list");
        }else {
            resp.setStatus(400);
            resp.sendRedirect(getServletContext().getContextPath()+"/products/updateForm?id="+id);
        }
    }
    protected void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if(productService.deleteProduct(id)){
            resp.setStatus(204);
            resp.sendRedirect(getServletContext().getContextPath()+"/products/list");
        }else {
            resp.setStatus(400);
            resp.sendRedirect(getServletContext().getContextPath()+"/products/list");
        }

    }
}
