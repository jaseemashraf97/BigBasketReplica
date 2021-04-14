package com.masai.BigBasketReplica.Dto;

import lombok.Data;

@Data
public class GenericDto<T> {
    private T data;
    private String message;
}
