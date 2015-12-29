package com.ims.domain;

/**
 * PickingResult domain object holds the result of pickProduct() operation
 * on inventory.
 */


public class PickingResult extends Result{

	public PickingResult(String productId, int inventoryLevel, String status) {
		super(productId, inventoryLevel, status);
	}	
	
}
