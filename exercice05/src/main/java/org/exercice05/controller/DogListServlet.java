package org.exercice05.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.exercice05.entity.Dog;
import org.exercice05.repository.DogRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "doglist", value = "/dog/doglist")
public class DogListServlet extends HttpServlet {
    private final DogRepository dogRepository = new DogRepository();
    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dog> dogs = dogRepository.getAll();
        req.setAttribute("dogs", dogs);
        getServletContext().getRequestDispatcher("/page/dogList.jsp").forward(req, resp);
    }

}
