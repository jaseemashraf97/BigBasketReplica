package com.masai.BigBasketReplica.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users {
    @Id
    private Integer userId;

    @OneToMany(mappedBy = "users")
    private List<Basket> basketsList = new ArrayList<>();

}
