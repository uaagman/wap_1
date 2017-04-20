package com.webstore.model;

public class ShippingAddress extends Address{
	private String name;
	
	public ShippingAddress(String street, String city, String state, String zipCode, String phone, String name) {
		super(street, city, state, zipCode, phone);
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
