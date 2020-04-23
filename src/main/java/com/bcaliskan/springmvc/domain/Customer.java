package com.bcaliskan.springmvc.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Customer extends AbstractDomainClass {

    private String firstName, lastName, email, phoneNumber;

    @Embedded // We are embedding embeddable Address entity as billingAddress into Customer table
    private Address billingAddress;

    @Embedded // We are embedding embeddable Address entity as shippingAddress into Customer table
    private Address shippingAddress;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private User user;

}
