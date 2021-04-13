package com.masai.BigBasketReplica.controller;

import com.masai.BigBasketReplica.entity.Basket;
import com.masai.BigBasketReplica.entity.Users;
import com.masai.BigBasketReplica.repository.UserRepository;
import com.masai.BigBasketReplica.service.BasketServices;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.List;

@RestController
public class BasketController {

    @Autowired
    private BasketServices basketServices;

    /**
     * View the Item list of the User with userId
     * @param
     * @return
     */
    @GetMapping("/basket")
    public List<Basket> getBasketByUser(){
//        Users dummyUser = new Users(1);
//
//        List<Basket> basketOfUser = basketServices.listBasketItems(dummyUser)
////        model.addAttribute("BasketItems", basketOfUser);
////        model.addAttribute("pageTitle","Shopping cart");
////        return "basket";
            List<Basket> BasketByUser = basketServices.getBasketByUser(1);
            return BasketByUser;
    }

    /**
     * User can add One item at a time with its quantity mentioned.
     * @param basket
     * @return
     */
    @PostMapping("/basket/{userId}")
    public Basket addItemsToBasketByUser(@RequestBody Basket basket,@PathVariable("userId") Integer userId)
    {
        Basket basket1 = basketServices.addItemsToBasketByUser(basket,userId);
        return basket1;
    }


    /**
     * Allows the user to modify the quantity of an existing Item in the basket
     * @param basket
     * @return
     */
    @PutMapping("/basket/{userId}")
    public Basket updateQuantityOfItemInBasket(@RequestBody Basket basket, @PathVariable("userId")Integer userId)
    {
        Basket basket1 = basketServices.updateQuantityOfItemInBasket(basket,userId);
        return basket1;
    }


    /**
     * Deletes an item from the basket by the user
     * @param userId
     * @param itemId
     * @return
     */
    @DeleteMapping("/basket/{userId}/{itemId}")
    public List<Basket> deleteOneItemFromBasket(@PathVariable("userId") Integer userId, @PathVariable("itemId") Integer itemId)
    {
        List<Basket> basketAfterDeletion = basketServices.deleteOneItemFromBasket(userId,itemId);
        return basketAfterDeletion;
    }
}
