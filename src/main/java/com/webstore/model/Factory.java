package com.webstore.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ashok on 4/20/2017.
 */
public class Factory {
    public static Map<String,User> getUsers(){
        Map<String,User> users = new HashMap<>();
        users.put("ashok",new User("ashok","ashok"));
        users.put("mukesh",new User("mukesh","mukesh"));
        return users;
    }
    public static Map<String,Product> getProducts(){
        Map<String,Product> products = new HashMap<>();
        products.put("shoe",new Product(1,"shoe",100, "very good ","shoe.jpg"));
        products.put("bag",new Product(2,"bag",200, "very good ","bag.jpg"));
        products.put("purse",new Product(3,"purse",50, "very good ","purse.jpg"));
        products.put("mobile",new Product(4,"mobile",300, "very good ","mobile.png"));
        products.put("shirt",new Product(5,"shirt",90, "very good ","shirt.jpg"));
        products.put("pant",new Product(6,"pant",110, "very good ","pant.jpg"));
        products.put("tie",new Product(7,"tie",25, "very good ","tie.jpg"));
        products.put("laptop",new Product(8,"laptop",600, "very good ","laptop.jpg"));
        products.put("mug",new Product(9,"mug",20, "very good ","mug.jpg"));
        return products;
    }
}
