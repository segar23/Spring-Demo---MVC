package com.mvc.springmvc.controllers;

import com.mvc.springmvc.domain.Product;
import com.mvc.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String listProducts(Model model){

        model.addAttribute("products", productService.listAllProducts());

        return "products";
    }

    @RequestMapping("/products/{id}")
    public String getProduct(@PathVariable Integer id, Model model){

        model.addAttribute("product", productService.getProductById(id));

        return "product";
    }

    @RequestMapping("/products/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product){
        Product savedProduct = productService.saveOrUpdateProduct(product);
        return "redirect:/products/" + savedProduct.getId();
    }

    @RequestMapping("products/edit/{id}")
    public String editProduct (@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    @RequestMapping("products/delete/{id}")
    public String deleteProduct (@PathVariable Integer id){
        productService.deleteProduct(id);
        return "redirect:/products/";
    }
}
