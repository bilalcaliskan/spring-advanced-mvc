package com.bcaliskan.springmvc.services.jpaservices;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class AbstractJpaDaoService {

    protected EntityManagerFactory emf;

    /*
    Below annotation injects entityManagerFactory bean into productServiceJpaDaoImpl bean.
    We used EntityManagerFactory because it is thread safe, while EntityManager is not.
    */
    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}