package org.exercice06.repository;

import org.exercice06.entity.Product;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository extends Repository<Product> {
    public ProductRepository(Session session) {
        super(session);
    }

    @Override
    public Product findById(int id) {
        return _session.get(Product.class, id);
    }


    @Override
    public List<Product> getAll() {
        return _session.createQuery("from Product", Product.class).list();
    }
}
