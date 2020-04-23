package com.bcaliskan.springmvc.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class OrderDetail extends AbstractDomainClass {

    @ManyToOne
    private Order order;

    @OneToOne
    private Product product;

    private Integer quantity;

}
