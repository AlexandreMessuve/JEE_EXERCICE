package org.exercice05.repository;

import org.exercice05.entity.Dog;
import org.exercice05.service.ServiceHibernate;

import java.util.List;

public class DogRepository extends ServiceHibernate implements Repository<Dog> {
    public DogRepository() {
        super();
    }

    @Override
    public boolean create(Dog dog) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(dog);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Dog dog) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(dog);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Dog dog) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(dog);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Dog findById(int id) {
        session = sessionFactory.openSession();
        Dog dog = session.get(Dog.class, id);
        session.close();
        return dog;
    }

    @Override
    public List<Dog> getAll() {
        session = sessionFactory.openSession();
        List<Dog> dogs = session.createQuery("from Dog", Dog.class).list();
        session.close();
        return dogs;
    }
}
