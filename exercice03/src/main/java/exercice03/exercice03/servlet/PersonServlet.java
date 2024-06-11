package exercice03.exercice03.servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import exercice03.exercice03.entity.Person;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "person", value = "/person")
public class PersonServlet extends HttpServlet {
    private final List<Person> persons = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        person1.setLastname("Henni");
        person1.setFirstname("Mohammed");
        person1.setAge(35);
        persons.add(person1);
        person2.setLastname("Nourri");
        person2.setFirstname("Jeremy");
        person2.setAge(27);
        persons.add(person2);
        person3.setLastname("Harry");
        person3.setFirstname("Juan");
        person3.setAge(31);
        persons.add(person3);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("persons", persons);
        getServletContext().getRequestDispatcher("/views/person.jsp").forward(req, resp);
    }
}
