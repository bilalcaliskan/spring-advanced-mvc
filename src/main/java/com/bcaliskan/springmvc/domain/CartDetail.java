package com.bcaliskan.springmvc.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class CartDetail extends AbstractDomainClass {

    @ManyToOne
    private Cart cart;

    @OneToOne
    private Product product;

    private Integer quantity;

}