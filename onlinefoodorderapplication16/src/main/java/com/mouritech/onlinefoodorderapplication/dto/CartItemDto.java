package com.mouritech.onlinefoodorderapplication.dto;


import javax.validation.constraints.NotNull;

import com.mouritech.onlinefoodorderapplication.entity.FoodCart;
import com.mouritech.onlinefoodorderapplication.entity.Items;

public class CartItemDto {
    private long id;
    private @NotNull Integer quantity;
    private @NotNull Items  items;

    public CartItemDto() {
    }

    public CartItemDto(FoodCart cart) {
        this.setId(cart.getCartId());
        this.setQuantity(cart.getQuantity());
        this.setItems(cart.getItems());
    }

   

   

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
   

}
