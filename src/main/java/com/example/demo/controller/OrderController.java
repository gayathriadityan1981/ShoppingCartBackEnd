package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.example.demo.dao.CartRepository;
import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;
import com.example.demo.dao.CartItemRepository;
import com.example.demo.entity.CartItem;;
import com.example.demo.service.CartItemService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/orders")
public class OrderController{

	@Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

	@Autowired
    CartItemService cartItemService;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartService cartService;

    @Autowired
    CartRepository cartRepository;

    @RequestMapping(value="/getAllProducts")
    public List<Product> getAllProducts()
    {
        List<Product> pdts=productService.findAll();
        return pdts;
    }
    @RequestMapping(value="/getProduct/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public  Product getPdt(@PathVariable("id") int id)
    {
        Product pdt=productService.findById(id);
        System.out.println("---------------------------"+id);
        System.out.println("---------------------------"+pdt.getName());
        return pdt;
    }
    @RequestMapping(value="/deleteProduct/{id}",method = {RequestMethod.GET, RequestMethod.PUT})
    public  void delPdt(@PathVariable("id") int id)
    {
        productService.deleteById(id);
      
    }
    @RequestMapping(value="/saveProduct", method = RequestMethod.POST)
    public  String saveProduct(@RequestBody Product pdt)
    {    
        productService.save(pdt);
        return "success";
    }

    
    @RequestMapping(value="/getAllCartItems")
    public List<CartItem> getAllCartItems()
    {
        List<CartItem> cartItems=cartItemService.findAll();
        return cartItems;
    }
    @RequestMapping(value="/getCartItem/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public  CartItem getCartItem(@PathVariable("id") int id)
    {
        CartItem cartItem=cartItemService.findById(id);
        return cartItem;
    }
    @RequestMapping(value="/deleteCartItem/{id}",method = {RequestMethod.GET, RequestMethod.PUT})
    public  void delCartItem(@PathVariable("id") int id)
    {
        cartItemService.deleteById(id);
      
    }
    @RequestMapping(value="/saveCartItem", method = RequestMethod.POST)
    public  String saveCartItem(@RequestBody CartItem cartItem)
    {    
        System.out.println("------ctrller-------save cart item-----------"+cartItem);
        cartItemService.save(cartItem);
        return "success";
    }
 

// for Cart

 @RequestMapping(value="/getAllCarts")
    public List<Cart> getAllCarts()
    {
        List<Cart> carts=cartService.findAll();
        return carts;
    }
    @RequestMapping(value="/getCart/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public  Cart getCart(@PathVariable("id") int id)
    {
        Cart cart=cartService.findById(id);
        return cart;
    }
    @RequestMapping(value="/deleteCart/{id}",method = {RequestMethod.GET, RequestMethod.PUT})
    public  void delCart(@PathVariable("id") int id)
    {
        cartService.deleteById(id);
      
    }
    @RequestMapping(value="/saveCart", method = RequestMethod.POST)
    public  String saveCart(@RequestBody Cart cart)
    {    
        cartService.save(cart);
        return "success";
    }
}