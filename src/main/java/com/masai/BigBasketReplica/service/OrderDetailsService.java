package com.masai.BigBasketReplica.service;

import com.masai.BigBasketReplica.entity.Basket;
import com.masai.BigBasketReplica.entity.Orders;
import com.masai.BigBasketReplica.entity.OrdersDetails;
import com.masai.BigBasketReplica.repository.BasketRepository;
import com.masai.BigBasketReplica.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    public String ProceedItemsForCheckOut(Integer userId, Orders orders)
    {
        List<Basket> basketList= basketRepository.findBasketsByUserId(userId);
        for (int i=0;i<basketList.size();i++)
        {
            OrdersDetails ordersDetails=new OrdersDetails();
            ordersDetails.setOrders(orders);
            ordersDetails.setItemId(basketList.get(i).getItemId());
            ordersDetails.setItemQuantity(basketList.get(i).getQuantity());
            //Item price shud be accessed using items micro services
            ordersDetails.setPricePerItem(10);
            orderDetailsRepository.save(ordersDetails);
            basketRepository.delete(basketList.get(i));
        }
        return "items moved from basket successfully";
    }
}
