package com.mvc.springmvc.controllers;

import com.mvc.springmvc.domain.Customer;
import com.mvc.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String listCustomers(Model model){
        model.addAttribute("customers", customerService.getAllCustomers());

        return "customers";
    }

    @RequestMapping("/customers/new")
    public String newCustomer (Model model){
        model.addAttribute("customer", new Customer());
        return "customerform";
    }
}
