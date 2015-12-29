package com.ims.domain;

public abstract class Result {

	private String productId;
	private int inventoryLevel;
	private String status;

	public Result(String productId, int inventoryLevel, String status){
		this.productId = productId;
		this.inventoryLevel = inventoryLevel;
		this.status = status;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getInventoryLevel() {
		return inventoryLevel;
	}

	public void setInventoryLevel(int inventoryLevel) {
		this.inventoryLevel = inventoryLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



}
