package com.mvc.springmvc.bootstrap;

import com.mvc.springmvc.domain.Address;
import com.mvc.springmvc.domain.Customer;
import com.mvc.springmvc.domain.Product;
import com.mvc.springmvc.services.CustomerService;
import com.mvc.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;

    private CustomerService customerService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadCustomers();
        loadProducts();
    }

    public void loadProducts() {
        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");

        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");

        productService.saveOrUpdate(product2);

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");

        productService.saveOrUpdate(product3);

        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");

        productService.saveOrUpdate(product4);

        Product product5 = new Product();
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");

        productService.saveOrUpdate(product5);
    }

    public void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Sebastian");
        customer1.setLastName("Garces");
        customer1.setPhoneNumber("7654133256");
        customer1.setEmail("segarces23");
        customer1.setBillingAddress(new Address());
        customer1.getBillingAddress().setAddressLine1("2081 Malibu Dr");
        customer1.getBillingAddress().setCity("West Lafayette");
        customer1.getBillingAddress().setState("IN");
        customer1.getBillingAddress().setZipCode("47906");

        customerService.saveOrUpdate(customer1);
    }
}
