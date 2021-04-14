package com.masai.BigBasketReplica.controller;

import com.masai.BigBasketReplica.Dto.GenericDto;
import com.masai.BigBasketReplica.entity.Basket;
import com.masai.BigBasketReplica.entity.Items;
import com.masai.BigBasketReplica.entity.Users;
import com.masai.BigBasketReplica.repository.UserRepository;
import com.masai.BigBasketReplica.service.BasketServices;
import org.apache.catalina.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    @GetMapping("/basket/{userId}")
    public GenericDto getBasketByUser(@PathVariable("userId") Integer userId, HttpServletResponse response){
//        Users dummyUser = new Users(1);
//
//        List<Basket> basketOfUser = basketServices.listBasketItems(dummyUser)
////        model.addAttribute("BasketItems", basketOfUser);
////        model.addAttribute("pageTitle","Shopping cart");
////        return "basket";
            GenericDto BasketByUser = basketServices.getBasketByUser(userId,response);
            return BasketByUser;
    }

    /**
     * User can add One item at a time with its quantity mentioned.
     * @param userId
     * @param itemId
     * @return
     */
    @PostMapping("/basket/{userId}/{itemId}")
    public Basket addItemsToBasketByUser(@PathVariable("userId") Integer userId,
                                         @PathVariable("itemId") Integer itemId)
    {
        /** Object - users = RestFull for userId
            Object - items =    RestFull itemId
            Create and assign to  the objects below
         */
        Items items = new Items();
        Users users =new Users();
        Basket basket1 = basketServices.addItemsToBasketByUser(items,users,1);
        return basket1;
    }


    /**
     * Allows the user to modify the quantity of an existing Item in the basket
     * @param userId
     * @return
     */
    @PutMapping("/basket/{userId}/{itemId}")
    public Basket updateQuantityOfItemInBasket(@PathVariable("userId")Integer userId,@PathVariable("itemId") Integer itemId)
    {
        //Items items = new Items();
        //Users users =new Users();
        Basket basket1 = basketServices.updateQuantityOfItemInBasket(userId,itemId);
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
