package com.masai.BigBasketReplica.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Items {
    @Id
    private Integer itemsId;
    @OneToMany(mappedBy = "items")
    private List<Basket> basketList = new ArrayList<>();
}
