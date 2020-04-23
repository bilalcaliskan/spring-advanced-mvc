package com.bcaliskan.springadvancedmvc.services;

import com.bcaliskan.springadvancedmvc.commands.CustomerForm;
import com.bcaliskan.springadvancedmvc.domain.Customer;

public interface CustomerService extends CRUDService<Customer> {

    Customer saveOrUpdateCustomerForm(CustomerForm customerForm);

}