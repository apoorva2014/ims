package com.ims;

import com.ims.domain.PickingResult;
import com.ims.domain.Product;
import com.ims.domain.RestockingResult;
import com.ims.domain.Warehouse;


public class Inventory implements InventoryManagementSystem{

	Warehouse warehouse = Warehouse.getInstance();

	@Override
	public PickingResult pickProduct(String productId, int amountToPick) {
		Product product = null;

		//Check whether the product is available in warehouse
		if(!warehouse.hasProduct(productId)){
			return new PickingResult(productId, 0, "FAILURE - product not found");
		}else{
			product = warehouse.getProduct(productId);
			PickingResult result = product.subtractInventory(amountToPick);
			warehouse.updateProduct(productId, product);
			return result;
		}

	}


	@Override
	public RestockingResult restockProduct(String productId, int amountToRestock) {
		Product product = null;

		//Check whether the product is available in warehouse
		if(!warehouse.hasProduct(productId)){
			return new RestockingResult(productId, 0, "FAILURE - product not found");
		}else{
			product = warehouse.getProduct(productId);
			RestockingResult result = product.addInventory(amountToRestock);
			warehouse.updateProduct(productId, product);
			return result;
		}

	}

}
