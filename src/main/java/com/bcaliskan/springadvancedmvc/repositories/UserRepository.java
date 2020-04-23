package com.bcaliskan.springadvancedmvc.repositories;

import com.bcaliskan.springadvancedmvc.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
