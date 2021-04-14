package com.masai.BigBasketReplica.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer orderId;
    @ManyToOne
    @JoinColumn(name="userId")
    Users users;
    private String placedDate;
    private String placedTime;
    private String status;
    private String deliveredTime;
    private Float totalPrice;
    private String modeOfPay;
    private String discountType;
    private String paymentStatus;
    @ManyToOne()
    @JoinColumn(name = "addressId")
    Address address;
    @OneToMany(mappedBy = "orders")
    private List<OrdersDetails> ordersDetailsList = new ArrayList<>();
}
