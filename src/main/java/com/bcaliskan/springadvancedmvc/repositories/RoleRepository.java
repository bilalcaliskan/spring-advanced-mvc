package com.bcaliskan.springadvancedmvc.repositories;

import com.bcaliskan.springadvancedmvc.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

}
