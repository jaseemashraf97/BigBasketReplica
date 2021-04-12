package com.masai.BigBasketReplica.repository;

import com.masai.BigBasketReplica.entity.Basket;
import com.masai.BigBasketReplica.entity.Items;
import com.masai.BigBasketReplica.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository <Basket, Integer>{
    public List<Basket> findByUsers(Users users);
    public Basket findBasketByItemsAndUsers(Users users, Items items);

}
