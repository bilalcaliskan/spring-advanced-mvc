package com.bcaliskan.springadvancedmvc.repositories;

import com.bcaliskan.springadvancedmvc.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
