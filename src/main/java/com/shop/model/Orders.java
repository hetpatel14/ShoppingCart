package com.shop.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {

    @Id
    private int id;
    private int customerID;
    private int count;
    private int productID;

    public int getProductID() {
        return productID;
    }

    public Orders(ProductModel product,int customerID,int count){
        this.customerID=customerID;
        this.productID=product.getId();
        this.count=count;

    }
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Orders() {
    }

    public Orders(int customerID, int count) {
        this.customerID = customerID;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
