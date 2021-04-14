package com.masai.BigBasketReplica.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Address {
    @Id
    private Integer addressId;
    @OneToMany(mappedBy = "address")
    private List<Orders> OrdersList = new ArrayList<>();
}
