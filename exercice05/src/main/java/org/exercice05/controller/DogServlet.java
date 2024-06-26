package org.exercice05.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.exercice05.entity.Dog;
import org.exercice05.repository.DogRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "dog", value = {"/dog/addDog", "/dog/*", "/dog/delete"})
public class DogServlet extends HttpServlet {
    private final DogRepository dogRepository = new DogRepository();
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = (req.getPathInfo() != null && !req.getPathInfo().isEmpty()) ? req.getPathInfo() : "" ;
        System.out.println(pathInfo);
        Dog dog = null;
        if (pathInfo != null && !pathInfo.isEmpty()) {
            dog = dogRepository.findById(Integer.parseInt(pathInfo.substring(1)));
        }
        if (dog == null) {
            dog = new Dog();
        }
        req.setAttribute("dog", dog);
        req.setAttribute("pathInfo", pathInfo);
        getServletContext().getRequestDispatcher("/page/addDog.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("_method");
        if (method != null && method.equalsIgnoreCase("delete")) {
            doDelete(req, resp);
        }else {
            Dog dog = new Dog();
            dog.setName(req.getParameter("name"));
            dog.setSpecie(req.getParameter("specie"));
            dog.setBirthday(LocalDate.parse(req.getParameter("birthDate")));
            if (dogRepository.create(dog)){
                resp.sendRedirect("doglist");
            }
        }

    }
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Dog dog = dogRepository.findById(id);
        if (dog != null) {
            dogRepository.delete(dog);
            resp.sendRedirect("doglist");
        }
    }
}
