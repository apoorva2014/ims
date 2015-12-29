package com.ims;

/**
 * This is a test client for IMS
 */

import java.util.HashMap;

import com.ims.domain.PickingResult;
import com.ims.domain.Product;
import com.ims.domain.RestockingResult;
import com.ims.domain.Warehouse;

public class TestInventory{

	public static void main(String[] args) throws Exception{
		Product product = new Product("123", "123", 20);
		HashMap<String, Product> products = new HashMap<>();
		products.put(product.getProductId(), product);
		final Inventory inventory = new Inventory();

		Warehouse warehouse = Warehouse.getInstance();
		warehouse.setProducts(products);

		Runnable run1 = new Runnable() {

			@Override
			public void run() {
				PickingResult result = inventory.pickProduct("123", 10);
				System.out.println("status of picking operation: " + result.getStatus() + "\n" + "inventory level : " + result.getInventoryLevel());
			}
		};

		Thread t1 = new Thread(run1);
		t1.start();

		//t1.sleep(2000);

		Runnable run2 = new Runnable() {

			@Override
			public void run() {
				RestockingResult result = inventory.restockProduct("123", 5);
				System.out.println("status of restocking operation: " + result.getStatus() + "\n" + "inventory level : " + result.getInventoryLevel());
			}
		};

		Thread t2 = new Thread(run2);
		t2.start();

	}

}
