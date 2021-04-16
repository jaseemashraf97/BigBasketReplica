package com.masai.BigBasketReplica.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrdersDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailsId;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders orders;
    private Integer itemId;
    private Integer itemQuantity;
    private float pricePerItem;
}
