package com.shop.dao.Product;

import com.shop.model.Orders;
import com.shop.model.ProductModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addProduct(ProductModel product) {

    }

    @Override
    public void deleteProduct(ProductModel product) {

    }

    @Override
    public ProductModel getProductByID(int id) {
        return (ProductModel)sessionFactory.getCurrentSession().get(ProductModel.class,id);
    }

    @Override
    public List<ProductModel> getProducts() {
        return sessionFactory.getCurrentSession().createQuery("from ProductModel").list();
    }

    @Override
    public void order(HashMap<ProductModel, Integer> data, int id) {
        try {
            data.forEach((product, count) -> {
                Orders order=new Orders(product,id,count);
                sessionFactory.getCurrentSession().save(order);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
