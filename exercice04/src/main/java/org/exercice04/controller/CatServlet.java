package org.exercice04.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.exercice04.entity.Cat;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "cat", value = "/cat")
public class CatServlet extends HttpServlet {
    private List<Cat> cats;
    @Override
    public void init() throws ServletException {
        cats = Cat.cats;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cats", cats);
        getServletContext().getRequestDispatcher("/catList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String catName = req.getParameter("name");
        String catSpecie = req.getParameter("specie");
        String favoriteFood = req.getParameter("favoriteFood");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        Cat cat = new Cat(catName, catSpecie, favoriteFood, birthDate);
        cats.add(cat);
        String path = getServletContext().getContextPath();
        resp.sendRedirect(path+"/cat");
    }
}
