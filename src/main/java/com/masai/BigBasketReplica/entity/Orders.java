package com.masai.BigBasketReplica.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private Integer userId;
    private LocalDate placedDate;
    private LocalTime placedTime;
    private String status;
    private LocalTime deliveredTime;
    private Float totalPrice;
    private String modeOfPay;
    private String discountType;
    private String paymentStatus;
    private Integer addressId;
    @OneToMany(mappedBy = "orders")
    private List<OrdersDetails> ordersDetailsList = new ArrayList<>();
}
