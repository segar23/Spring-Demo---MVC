package com.mvc.springmvc.services;

import com.mvc.springmvc.domain.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomerById(Integer id);

    List<Customer> getAllCustomers();

    Customer saveOrUpdateCustomer (Customer customer);

    void deleteCustomer (Integer id);
}
