package com.masai.BigBasketReplica.controller;

import com.masai.BigBasketReplica.Dto.GenericDto;
import com.masai.BigBasketReplica.entity.Basket;
import com.masai.BigBasketReplica.service.BasketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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


    @GetMapping("basket/{userId}/totalprice")
    public GenericDto getTotalPriceBeforeCheckout(@PathVariable("userId") Integer userId)
    {
        GenericDto totalPrice = basketServices.getTotalPrice(userId);
        return totalPrice;
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
