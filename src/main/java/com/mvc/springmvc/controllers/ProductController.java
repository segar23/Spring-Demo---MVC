package com.mvc.springmvc.controllers;

import com.mvc.springmvc.domain.Product;
import com.mvc.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/products")
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"/list", "/"})
    public String listProducts(Model model){

        model.addAttribute("products", productService.listAll());

        return "products";
    }

    @RequestMapping("/{id}")
    public String getProduct(@PathVariable Integer id, Model model){

        model.addAttribute("product", productService.getById(id));

        return "product";
    }

    @RequestMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product){
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/products/" + savedProduct.getId();
    }

    @RequestMapping("/edit/{id}")
    public String editProduct (@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "productform";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct (@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/products/";
    }
}
