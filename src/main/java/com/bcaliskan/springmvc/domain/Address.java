package com.bcaliskan.springmvc.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable // indicates that it is an embeddable entity. We will embed that into Customer.
public class Address {

    private String addressLine1, addressLine2, city, state, zipCode;

}