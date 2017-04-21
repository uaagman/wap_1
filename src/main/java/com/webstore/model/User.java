package com.webstore.model;

public class User {
    private String username;
    private String password;
    private BillingAddress billingAddress = null;
    private ShippingAddress shippingAddress = null;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
