package com.masai.BigBasketReplica.controller;

import com.masai.BigBasketReplica.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    @GetMapping("/orders/{userId}")
    public GenericDto orderHistory(@PathVariable("userId") Integer userId)
    {
        GenericDto orders = ordersService.getOrderDetails(userId);
        return orders;
    }

    @PostMapping("/orders/{userId}/{addressId}/{totalPrice}")
    public GenericDto confirmOrder(@PathVariable("userId") Integer userId,@PathVariable("addressId") Integer addressId,@PathVariable("totalPrice") Float totalPrice)
    {
        //Users and address object to retrived of the particular
        Users users = new Users();
        Address address= new Address();
        GenericDto orders = ordersService.confirmOrder(users,address, totalPrice);
        return orders;
    }
}
