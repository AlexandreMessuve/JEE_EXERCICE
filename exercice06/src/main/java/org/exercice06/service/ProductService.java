package org.exercice06.service;

import org.exercice06.entity.Product;
import org.exercice06.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ProductService extends ServiceHibernate{
    private ProductRepository productRepository;
    public ProductService() {
        super();
    }

    public boolean createProduct(String bread, String ref, double price, int stock) {
        boolean result = false;
        session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = new Product(bread, ref, price, stock);
        productRepository = new ProductRepository(session);
        try {
            productRepository.create(product);
            session.getTransaction().commit();
            result = true;
        }catch(Exception except) {
            try {
                session.getTransaction().rollback();
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }finally {
            session.close();
        }
        return result;

    }

    public boolean updateProduct(int id, String brand, String ref, double price, int stock) {
        boolean result = false;
        Product product;
        session = sessionFactory.openSession();
        session.beginTransaction();
        productRepository = new ProductRepository(session);
        if (brand != null && ref != null && price != 0 && stock != 0) {
            product = productRepository.findById(id);
            if (product != null) {
                product.setBrand(brand);
                product.setReference(ref);
                product.setPrice(price);
                product.setStock(stock);
                product.setUpdatedAt(LocalDateTime.now());
                try {
                    productRepository.update(product);
                    session.getTransaction().commit();
                    result = true;
                }catch(Exception except) {
                    try {
                        session.getTransaction().rollback();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }finally {
                    session.close();
                }
            }
        }
        return result;
    }
    public boolean deleteProduct(int id) {
        boolean result = false;
        session = sessionFactory.openSession();
        session.beginTransaction();
        productRepository = new ProductRepository(session);
        Product product = productRepository.findById(id);
        if (product != null) {
            try {
                productRepository.delete(product);
                session.getTransaction().commit();
                result = true;
            }catch (Exception except){
                try {
                    session.getTransaction().rollback();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }finally {
                session.close();
            }
        }
        return result;
    }

    public Product getProduct(int id) {
        session = sessionFactory.openSession();
        productRepository = new ProductRepository(session);
        return productRepository.findById(id);
    }

    public List<Product> getUsers() {
        session = sessionFactory.openSession();
        productRepository = new ProductRepository(session);
        return productRepository.getAll();
    }
}
