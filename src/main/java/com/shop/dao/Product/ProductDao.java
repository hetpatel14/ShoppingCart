package com.shop.dao.Product;

import com.shop.model.ProductModel;

import java.util.HashMap;
import java.util.List;

public interface ProductDao {

    public void addProduct(ProductModel product);
    public void deleteProduct(ProductModel product);
    public ProductModel getProductByID(int id);
    public List<ProductModel> getProducts();
    public void order(HashMap<ProductModel, Integer> data,int id);
}
