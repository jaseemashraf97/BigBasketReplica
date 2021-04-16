package com.masai.BigBasketReplica.service;

import com.masai.BigBasketReplica.Dto.GenericDto;
import com.masai.BigBasketReplica.entity.Orders;
import com.masai.BigBasketReplica.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class OrdersService {
    @Autowired
    private OrderRepository orderRepository;


    public GenericDto getOrderDetails(Integer userId)
    {
        GenericDto orders = new GenericDto();
        orders.setData(orderRepository.findOrdersByUserId(userId));
        orders.setMessage("Orders fetch completed");
        return orders;
    }

    public GenericDto confirmOrder(Integer userId,Integer addressId,Float totalPrice)
    {
        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setPlacedDate(LocalDate.now());
        orders.setPlacedTime(LocalTime.now());
        orders.setStatus("Incomplete");
        orders.setDeliveredTime(orders.getPlacedTime().plusHours(3));
        orders.setModeOfPay("Cash on Delivery");
        orders.setPaymentStatus("Incomplete");
        orders.setAddressId(addressId);
        orders.setTotalPrice(totalPrice);
        GenericDto genericDto = new GenericDto();
        genericDto.setData(orderRepository.save(orders));
        return genericDto;

    }
}
