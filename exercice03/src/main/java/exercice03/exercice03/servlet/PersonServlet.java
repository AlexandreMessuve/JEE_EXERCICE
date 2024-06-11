package exercice03.exercice03.servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import exercice03.exercice03.entity.Person;
import exercice03.exercice03.repository.PersonRepository;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "person", value = "/person")
public class PersonServlet extends HttpServlet {
    private List<Person> persons;
    private final PersonRepository personRepository = new PersonRepository();
    @Override
    public void init() throws ServletException {
        Person person = new Person("Henni", "Mohamed", 43);
        persons = personRepository.findAll();
        persons.add(person);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("persons", persons);
        getServletContext().getRequestDispatcher("/views/person.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastname = req.getParameter("lastname");
        String firstname = req.getParameter("firstname");
        int age = Integer.parseInt(req.getParameter("age"));
        Person person = new Person(lastname, firstname, age);
        if(personRepository.create(person)){
            resp.setStatus(201);
            resp.sendRedirect("/person");
        }
    }
}
