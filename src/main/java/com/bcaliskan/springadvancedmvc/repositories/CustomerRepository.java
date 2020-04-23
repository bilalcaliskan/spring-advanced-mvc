package com.bcaliskan.springadvancedmvc.repositories;

import com.bcaliskan.springadvancedmvc.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
