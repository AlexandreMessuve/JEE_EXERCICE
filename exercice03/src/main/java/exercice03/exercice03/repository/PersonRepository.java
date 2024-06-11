package exercice03.exercice03.repository;

import exercice03.exercice03.entity.Person;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository extends BaseService implements Repository<Person> {
    public PersonRepository() {
        super();
    }

    @Override
    public boolean create(Person o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Person o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Person o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Person findById(int id) {
        session = sessionFactory.openSession();
        Person person = session.get(Person.class,id);
        session.close();
        return person;
    }

    @Override
    public List<Person> findAll() {
        List<Person> personList;
        session = sessionFactory.openSession();
        Query<Person> personQuery = session.createQuery("from Person", Person.class);
        personList = personQuery.list();
        session.close();
        return personList;
    }

    public void close(){
        sessionFactory.close();
    }
}
