package com.mvc.springmvc.services;

import com.mvc.springmvc.domain.Customer;
import com.mvc.springmvc.domain.DomainObject;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    public CustomerServiceImpl() {
        loadDomainObjects();
    }

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Customer getById(Integer id){
        return (Customer)super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer)super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id){
        super.delete(id);
    }



    @Override
    protected void loadDomainObjects() {
        domainMap = new HashMap<>();

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

        domainMap.put(customer1.getId(), customer1);
    }
}
