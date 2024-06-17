package org.exercice06.service;

import org.exercice06.entity.User;
import org.exercice06.repository.UserRepository;

import java.util.List;

public class UserService extends ServiceHibernate {
    private UserRepository userRepository;

    public UserService() {
        super();
    }

    public boolean createUser(String email, String password) {
        boolean result = false;
        session = sessionFactory.openSession();
        session.beginTransaction();
        userRepository = new UserRepository(session);
        User user = new User(email, password);
        try {
            userRepository.create(user);
            session.getTransaction().commit();
            result = true;
        } catch (Exception except) {
            try {
                session.getTransaction().rollback();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } finally {
            session.close();
        }
        return result;
    }

    public boolean updateUser(int id, String firstName, String lastName) {
        boolean result = false;
        User user;
        session = sessionFactory.openSession();
        session.beginTransaction();
        userRepository = new UserRepository(session);
        user = userRepository.findById(id);
        if (user != null) {
            if (firstName != null) {
                user.setFirstName(firstName);
            }
            if (lastName != null) {
                user.setLastName(lastName);
            }
            try {
                userRepository.update(user);
                session.getTransaction().commit();
                result = true;
            } catch (Exception except) {
                try {
                    session.getTransaction().rollback();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } finally {
                session.close();
            }
        }
        return result;
    }

    public boolean deleteUser(int id) {
        boolean result = false;
        session = sessionFactory.openSession();
        session.beginTransaction();
        userRepository = new UserRepository(session);
        User user = userRepository.findById(id);
        if (user != null) {
            try {
                userRepository.delete(user);
                session.getTransaction().commit();
                result = true;
            } catch (Exception except) {
                try {
                    session.getTransaction().rollback();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } finally {
                session.close();
            }
        }
        return result;
    }

    public User getUser(String email) {
        User user = null;
        session = sessionFactory.openSession();
        userRepository = new UserRepository(session);
        try {
            user = userRepository.findByEmail(email);
        } catch (Exception except) {
            System.out.println(except.getMessage());
        }
        session.close();
        return user;
    }

    public User getUser(int id) {
        User user = null;
        session = sessionFactory.openSession();
        userRepository = new UserRepository(session);
        user = userRepository.findById(id);
        return user;
    }

    public List<User> getUsers() {
        session = sessionFactory.openSession();
        userRepository = new UserRepository(session);
        return userRepository.getAll();
    }

}
