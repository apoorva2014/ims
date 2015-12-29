package com.ims.domain;

/**
 * Product domain object contains information associated with product
 */

public class Product {

	private String productId;
	private String locationId;
	private int inventoryLevel;

	public Product(String productId, String locationId, int inventoryLevel){
		this.productId = productId;
		this.locationId = locationId;
		this.inventoryLevel = inventoryLevel;
	}

	/*This method allows only one thread to access the current product*/
	
	public synchronized PickingResult subtractInventory(int amount){
		int updatedInventory = inventoryLevel - amount;
		PickingResult pickingResult = null;

		if(updatedInventory >= 0){
			this.setInventoryLevel(updatedInventory);
			pickingResult = new PickingResult(productId, updatedInventory, "SUCCESS");
		}else{
			pickingResult = new PickingResult(productId, inventoryLevel, "FAILURE - product understock");
		}
		return pickingResult;

	}

	/*This method allows only one thread to access the current product*/
	
	public synchronized RestockingResult addInventory(int amount){
		int updatedInventory = inventoryLevel + amount;
		this.setInventoryLevel(updatedInventory);
		return new RestockingResult(productId, updatedInventory, "SUCCESS");
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public int getInventoryLevel() {
		return inventoryLevel;
	}

	public void setInventoryLevel(int inventoryLevel) {
		this.inventoryLevel = inventoryLevel;
	}

}
