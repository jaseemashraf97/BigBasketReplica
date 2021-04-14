package com.masai.BigBasketReplica.repository;

import com.masai.BigBasketReplica.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {

}
