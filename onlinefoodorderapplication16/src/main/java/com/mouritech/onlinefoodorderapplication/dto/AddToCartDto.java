package com.mouritech.onlinefoodorderapplication.dto;



import javax.validation.constraints.NotNull;

public class AddToCartDto {
    private Integer id;
    private @NotNull long itemId;
    private @NotNull Integer quantity;

    public AddToCartDto() {
    	
    }

   public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


   
    public long getItemId() {
		return itemId;
	}





	public void setItemId(long itemId) {
		this.itemId = itemId;
	}





	public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
