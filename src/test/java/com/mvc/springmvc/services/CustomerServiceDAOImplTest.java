package com.mvc.springmvc.services;

import com.mvc.springmvc.domain.Customer;
import com.mvc.springmvc.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("dao")
public class CustomerServiceDAOImplTest {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void testListMethod() throws Exception{
        List<Customer> customers = (List<Customer>) customerService.listAll();

        assert customers.size() == 1;
    }

    @Test
    public void testSaveWithUser () throws Exception{
        Customer customer = new Customer();
        User user = new User();
        user.setUsername("segar23");
        user.setPassword("pass69");
        customer.setUser(user);

        Customer savedCustomer = customerService.saveOrUpdate(customer);

        assert savedCustomer.getUser().getId() != null;
    }
}
