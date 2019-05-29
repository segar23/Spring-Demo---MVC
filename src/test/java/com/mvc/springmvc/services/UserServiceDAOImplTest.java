package com.mvc.springmvc.services;

import com.mvc.springmvc.domain.*;
import org.junit.Assert;
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
public class UserServiceDAOImplTest {

    private UserService userService;
    private ProductService productService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @Test
    public void testSaveOrUpdateUser() throws Exception{
        User user = new User();

        user.setUsername("segar23");
        user.setPassword("pass69");

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getEncryptedPassword() != null;

        System.out.println("Encrypted Password");
        System.out.println(savedUser.getEncryptedPassword());
    }

    @Test
    public void testSaveOfUserWithCustomer () throws Exception{
        User user = new User();

        user.setUsername("segar23");
        user.setPassword("pass69");

        Customer customer = new Customer();

        customer.setFirstName("John");
        customer.setLastName("Doe");

        user.setCustomer(customer);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCustomer() != null;
        assert savedUser.getCustomer().getId() != null;
    }

    @Test
    public void addCartToUser() throws Exception{
        User user = new User();

        user.setUsername("segar23");
        user.setPassword("pass69");

        user.setCart(new Cart());

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
    }

    @Test
    public void testAddCartToUserWithCartDetails() throws Exception{
        User user = new User();

        user.setUsername("segar23");
        user.setPassword("pass69");

        user.setCart(new Cart());

        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartProduct1 = new CartDetail();
        cartProduct1.setProduct(storedProducts.get(0));
        user.getCart().addCardDetail(cartProduct1);

        CartDetail cartProduct2 = new CartDetail();
        cartProduct2.setProduct(storedProducts.get(1));
        user.getCart().addCardDetail(cartProduct2);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCart() != null;
        assert savedUser.getCart().getId() != null;
        assert savedUser.getCart().getCartDetails().size() == 2;
    }

    @Test
    public void testAddAndRemoveCartToUserWithCartDetails() throws Exception{
        User user = new User();

        user.setUsername("segar23");
        user.setPassword("pass69");

        user.setCart(new Cart());

        List<Product> storedProducts = (List<Product>) productService.listAll();

        CartDetail cartProduct1 = new CartDetail();
        cartProduct1.setProduct(storedProducts.get(0));
        user.getCart().addCardDetail(cartProduct1);

        CartDetail cartProduct2 = new CartDetail();
        cartProduct2.setProduct(storedProducts.get(1));
        user.getCart().addCardDetail(cartProduct2);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getCart().getCartDetails().size() == 2;

        savedUser.getCart().removeCartDetail(savedUser.getCart().getCartDetails().get(0));

        userService.saveOrUpdate(savedUser);

        assert savedUser.getCart().getCartDetails().size() == 1;
    }
}
