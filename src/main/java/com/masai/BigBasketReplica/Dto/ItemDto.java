package com.masai.BigBasketReplica.Dto;

import lombok.Data;

@Data
public class ItemDto {
    String itemName;
    Integer itemId;
    Integer unitPrice;
    Integer itemQty;
    Integer totalPrice;
}
