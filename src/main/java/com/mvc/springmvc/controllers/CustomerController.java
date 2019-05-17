package com.mvc.springmvc.controllers;

import com.mvc.springmvc.domain.Customer;
import com.mvc.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/customers/{id}")
    public String getCustomer (@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String saveOrUpdateCustomer(Customer customer){
        Customer savedCustomer = customerService.saveOrUpdateCustomer(customer);
        return "redirect:/customers/" + savedCustomer.getId();
    }

    @RequestMapping("/customers/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customerform";
    }

    @RequestMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return "redirect:/customers/";
    }
}
