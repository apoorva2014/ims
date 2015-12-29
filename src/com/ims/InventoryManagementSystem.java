package com.ims;

import com.ims.domain.PickingResult;
import com.ims.domain.RestockingResult;

/**
* access to shared data must be thread-safe.
**/
public interface InventoryManagementSystem {

PickingResult pickProduct(String productId, int amountToPick);

RestockingResult restockProduct(String productId, int amountToRestock);
}