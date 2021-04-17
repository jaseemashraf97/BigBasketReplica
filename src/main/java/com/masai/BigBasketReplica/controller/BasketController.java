package com.masai.BigBasketReplica.controller;

import com.masai.BigBasketReplica.Dto.GenericDto;
import com.masai.BigBasketReplica.Dto.ItemDto;
import com.masai.BigBasketReplica.entity.Basket;
import com.masai.BigBasketReplica.service.BasketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

// tasks remaining
// - orders
// - order-details

@RestController
public class BasketController {

    @Autowired
    private BasketServices basketServices;
    /**
     * View the Item list of the User with userId
     * @param
     * @return
     */
    @GetMapping("/basket/{userId}")
    public List<ItemDto> getBasketByUser(@PathVariable("userId") Integer userId, HttpServletResponse response){
             return basketServices.getBasketByUser(userId,response);
    }


    @PostMapping("/basket/{userId}/{itemId}/{quantity}/")
    public Basket addItemsToBasket(@PathVariable("userId") Integer userId,
                                 @PathVariable("itemId") Integer itemId,
                                 @PathVariable("quantity") Integer quantity,
                                   HttpServletResponse response){
        return basketServices.addItemsToBasket(userId,itemId,quantity,response);
    }


    @PutMapping("/basket/{userId}/{itemId}/{quantity}")
    public Basket updateQuantityOfItemInBasket(@PathVariable("userId")Integer userId,
                                             @PathVariable("itemId") Integer itemId,
                                             @PathVariable("quantity") Integer quantity, HttpServletResponse response){

        return basketServices.updateQuantityOfItemInBasket(userId,itemId,quantity,response);
    }

    @DeleteMapping("/basket/{userId}")
    public GenericDto deleteBasket(@PathVariable("userId") Integer userId, HttpServletResponse response){
           return basketServices.deleteBasketByUser(userId,response);
    }
}
