package com.bcaliskan.springadvancedmvc.services.reposervices;

import com.bcaliskan.springadvancedmvc.domain.User;
import com.bcaliskan.springadvancedmvc.repositories.CustomerRepository;
import com.bcaliskan.springadvancedmvc.repositories.UserRepository;
import com.bcaliskan.springadvancedmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Profile("springdatajpa")
public class UserServiceRepoImpl implements UserService {

    private UserRepository userRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<?> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add); //fun with Java 8
        return users;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return userRepository.save(domainObject);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        User user = userRepository.findOne(id);
        customerRepository.delete(user.getCustomer());
        userRepository.delete(user);
    }

}
