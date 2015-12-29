package com.ims.domain;

/**
 * This is a singleton class since there should be only one instance of 
 * warehouse within the application
 */

import java.util.HashMap;

public class Warehouse {
	
	private static Warehouse warehouse = null;
	
	private Warehouse(){};
	
	private HashMap<String, Product> products = new HashMap<>();
	
	public boolean hasProduct(String productId){
		return products.containsKey(productId);
	}
	
	public Product getProduct(String productId){
		return products.get(productId);
	}

	public void updateProduct(String productId, Product product){
		products.put(productId, product);
		
	}
	
	public HashMap<String, Product> getProducts() {
		return products;
	}

	public void setProducts(HashMap<String, Product> products) {
		this.products = products;
	}

	public static Warehouse getInstance(){
		if(warehouse == null){
			warehouse = new Warehouse();
		}
		return warehouse;
	}
	
	
}
