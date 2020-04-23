package com.bcaliskan.springadvancedmvc.repositories;

import com.bcaliskan.springadvancedmvc.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}