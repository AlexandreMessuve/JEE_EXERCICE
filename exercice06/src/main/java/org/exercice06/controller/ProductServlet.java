package org.exercice06.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.exercice06.entity.Product;
import org.exercice06.service.ProductService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "product", value = "/products/*")
@MultipartConfig(fileSizeThreshold=1024*1024,
        maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    private static final String IMAGE_FOLDER = "/images";
    private String uploadPath;

    @Override
    public void init() throws ServletException {
        uploadPath = getServletContext().getRealPath(IMAGE_FOLDER);
        File uploadDir = new File(uploadPath);
        boolean condition = uploadDir.setWritable(true, false) && uploadDir.setExecutable(true, false) && uploadDir.setReadable(true, false);
        if (condition) {
            if (!uploadDir.exists()){
                if (!uploadDir.mkdirs()){
                    throw new ServletException("Unable to create directory " + uploadPath);
                }
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("email") != null && req.getSession().getAttribute("isLoggedIn") != null) {
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

    /**
     * Get product detail and redirect if product is null
     */
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

    /**
     * Get product list & redirect to the product list page
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getProducts();
        req.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/WEB-INF/page/product/productList.jsp").forward(req, resp);
    }

    /**
     * Redirect to the product form
     */
    protected void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/page/product/formProduct.jsp").forward(req, resp);
    }

    /**
     * Set attribute add for redirect to method showForm
     */
    protected void addForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mode", "add");
        Product product = new Product();
        req.setAttribute("product", product);
        showForm(req, resp);

    }

    /**
     * Add a new product after submit the form
     */
    protected void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(productAddOrUpdate(req, "add")){
            resp.setStatus(201);
            resp.sendRedirect(getServletContext().getContextPath()+"/products/list");
        }else {
            resp.setStatus(400);
            addForm(req, resp);
        }

    }

    /**
     * Set attribute update for redirect to method showForm
     */
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

    /**
     * Update a  product after submit the form
     */
    protected void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = new String(req.getPart("id").getInputStream().readAllBytes());
        int id = Integer.parseInt(idString);
        if(productAddOrUpdate(req, "update")){
            resp.setStatus(202);
            resp.sendRedirect(getServletContext().getContextPath()+"/products/list");
        }else {
            resp.setStatus(400);
            resp.sendRedirect(getServletContext().getContextPath()+"/products/updateForm?id="+id);
        }
    }

    protected boolean productAddOrUpdate(HttpServletRequest req, String type) throws ServletException, IOException {
        String brand = new String(req.getPart("brand").getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        String ref = new String(req.getPart("ref").getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        String localDate = new String(req.getPart("purchaseDate").getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        LocalDateTime purchaseDate = LocalDateTime.parse(localDate);

        String priceString = new String(req.getPart("price").getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        double price = Double.parseDouble(priceString);

        System.out.println(brand);

        String stockString = new String(req.getPart("stock").getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        int stock = Integer.parseInt(stockString);

        Part image = req.getPart("image");
        String imageName = null;
        if (!image.getSubmittedFileName().isEmpty()){
            imageName = image.getSubmittedFileName();
            uploadImage(image);
        }
        System.out.println(imageName);
        if (type.equals("add")) {
            return productService.createProduct(brand, ref, imageName, purchaseDate, price, stock);
        }else{
            String idString = new String(req.getPart("id").getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            int id = Integer.parseInt(idString);
            return productService.updateProduct(id, brand, ref, imageName, purchaseDate, price, stock);
        }

    }
    /**
     * Delete product if the product is not null else redirect to product list
     */
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

    /**
     *
     * Method for transfer a image to the directory of the server
     */
    protected void uploadImage(Part imagePart){
        String fileName = imagePart.getSubmittedFileName();
        //String fullPath = uploadPath + File.separator + fileName;
        File file = new File(uploadPath, fileName);
        try (InputStream inputStream = imagePart.getInputStream()){
            Files.copy(inputStream, file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
