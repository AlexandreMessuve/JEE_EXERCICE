package org.exercice06.repository;

import org.exercice06.entity.User;
import org.hibernate.Session;

import java.util.List;

public class UserRepository extends Repository<User> {

    public UserRepository(Session session) {
        super(session);
    }

    public  User findByEmail(String email) {
        return  _session.createQuery("from User where email = :email", User.class).setParameter("email", email).getSingleResult();
    }
    @Override
    public User findById(int id) {
        return _session.get(User.class, id);
    }


    @Override
    public List<User> getAll() {
        return _session.createQuery("from User", User.class).list();
    }


}
