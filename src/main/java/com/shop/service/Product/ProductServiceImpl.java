package com.shop.service.Product;


import com.shop.dao.Product.ProductDaoImpl;
import com.shop.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDaoImpl productDao;

    @Override
    public void addProduct(ProductModel product) {

    }

    @Override
    public void deleteProduct(ProductModel product) {

    }

    @Override
    @Transactional
    public ProductModel getProductByID(int id) {
       return productDao.getProductByID(id);
    }

    @Override
    @Transactional
    public List<ProductModel> getProducts() {
        return productDao.getProducts();
    }

    @Override
    @Transactional
    public void order(HashMap<ProductModel, Integer> data, int id) {

        productDao.order(data,id);
    }


}
