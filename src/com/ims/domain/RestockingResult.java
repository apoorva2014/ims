package com.ims.domain;

/**
 * 
 * RestockingResult domain object holds the result of restockProduct() operation
 * on inventory.
 * 
 */

public class RestockingResult extends Result{

	public RestockingResult(String productId, int inventoryLevel, String status) {
		super(productId, inventoryLevel, status);
	}

}
