package com.mvc.springmvc.services;

import com.mvc.springmvc.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null) {
            if (customer.getId() == null) {
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);

            return customer;
        } else {
            throw new RuntimeException("Customer can't be empty");
        }
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }

    private Integer getNextKey() {
        return Collections.max(customers.keySet()) + 1;
    }

    private void loadCustomers() {
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Sebastian");
        customer1.setLastName("Garces");
        /*
        customer1.setEmail("segarces23@gmail.com");
        customer1.setPhoneNumber("7654133256");
        customer1.setAddressLine1("2081 Malibu Dr");
        customer1.setAddressLine2("");
        customer1.setCity("West Lafayette");
        customer1.setState("IN");
        customer1.setZipCode("47906");

         */

        customers.put(customer1.getId(), customer1);
    }
}
