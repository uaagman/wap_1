package com.webstore.model;

/**
 * Created by ashok on 4/20/2017.
 */
public class Product {
	private Integer id;
    private String name;
    private double price;
    private String description;
    private String image;

	public Product(Integer id, String name, double price, String description, String image) {
    	this.id = id;

        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}
    
}
