package com.masai.BigBasketReplica.service;

import com.masai.BigBasketReplica.entity.Basket;
import com.masai.BigBasketReplica.entity.Users;
import com.masai.BigBasketReplica.repository.BasketRepository;
import com.masai.BigBasketReplica.repository.ItemsRepository;
import com.masai.BigBasketReplica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

@Service
public class BasketServices {
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ItemsRepository itemsRepository;
//    public List<Basket> listBasketItems(Integer UserId)
//    {
//        return basketRepository.fin;
//    }


    /**
     * Returns all the items added to basket by a user.
     * @param userId
     * @return
     */
    public List<Basket> getBasketByUser(Integer userId) {

        return basketRepository.findByUsers(userRepository.findById(userId).get());
    }


    /**
     * Add an item with mentioning the quantity to the basket by User.
     * @param basket
     * @return
     */
    public Basket addItemsToBasketByUser(Basket basket, Integer userId)
    {
        Users users= userRepository.findById(userId).get();
        basket.setUsers(users);
        Basket basket1 = basketRepository.save(basket);
        return basket1;
    }

    /**
     * Update the quantity of an existing item from basket
     * @param basket
     * @param userId
     * @return
     */
    public Basket updateQuantityOfItemInBasket(Basket basket,Integer userId)
    {
        Basket basket1 = basketRepository.findBasketByItemsAndUsers(userRepository.findById(userId).get(),basket.getItems());
        basket1.setQuantity(basket.getQuantity());
        return basket1;
    }


    /**
     * Deletes the selected item from the basket and returns the new basket list of the selected User.
     * @param userId
     * @param itemId
     * @return
     */
    public List<Basket> deleteOneItemFromBasket(Integer userId,Integer itemId)
    {
        Basket basket = basketRepository.findBasketByItemsAndUsers(userRepository.findById(userId).get(),itemsRepository.findById(itemId).get());
        basketRepository.delete(basket);
        return basketRepository.findByUsers(userRepository.findById(userId).get());
    }
}
