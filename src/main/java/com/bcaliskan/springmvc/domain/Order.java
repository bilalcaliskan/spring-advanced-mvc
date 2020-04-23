package com.bcaliskan.springmvc.domain;

import com.bcaliskan.springmvc.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ORDER_HEADER")
public class Order extends AbstractDomainClass {

    @OneToOne
    private Customer customer;

    @Embedded
    private Address shipToAddress;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    private OrderStatus orderStatus;
    private Date dateShipped;

    public void addToOrderDetails(OrderDetail orderDetail){
        orderDetail.setOrder(this);
        orderDetails.add(orderDetail);
    }

    public void removeOrderDetail(OrderDetail orderDetail){
        orderDetail.setOrder(null);
        orderDetails.remove(orderDetail);
    }

}
