package com.bcaliskan.springmvc.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Product extends AbstractDomainClass {

    private String description, imageUrl;
    private BigDecimal price;

}