package com.bcaliskan.springmvc.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

/*
By MappedSuperclass anotation, we tell the JPA that we will inherit from that class, so JPA will not create a table for
superclass.
 */
@MappedSuperclass
@Getter
@Setter
public class AbstractDomainClass implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Version
    private Integer version;

    private Date dateCreated, lastUpdated;

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        lastUpdated = new Date();
        if (dateCreated==null) {
            dateCreated = new Date();
        }
    }
}