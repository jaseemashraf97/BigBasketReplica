package com.masai.BigBasketReplica.repository;

import com.masai.BigBasketReplica.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository <Basket, Integer>{
    List<Basket> findByUsers(Users users);
    Basket findBasketByItemsAndUsers(Users users, Items items);

}
