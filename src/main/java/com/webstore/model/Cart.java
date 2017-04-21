package com.webstore.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashok on 4/20/2017.
 */
public class Cart {
	private int productId;
	private Product product = null;
	private int qty;

	public int getProductId() {
		return productId;
	}

	public int getQty() {
		return qty;
	}

	public Product getProduct() {
		List<Product> pro = new ArrayList<>(Factory.getProducts().values());
		for (Product p : pro) {
			if (p.getId() == this.productId) {
				this.product = p;
				break;
			}
		}
		return this.product;
	}

	public Cart(int productId, int qty) {
		this.productId = productId;
		this.qty = qty;
	}
}
