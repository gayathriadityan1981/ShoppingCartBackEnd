package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.example.demo.dao.CartRepository;
import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderService;
import com.example.demo.dao.CartItemRepository;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.CustomerOrder;
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

    @Autowired
    OrderService orderService;

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
    public  int saveCartItem(@RequestBody CartItem cartItem)
    {    
       
       CartItem cartItm= cartItemService.save(cartItem);
       int id=cartItm.getCartItemId();
       return id;
    }
    @RequestMapping(value="/updateCartItem/{qty}/{id}", method = RequestMethod.POST)
    public  String updateCartItem(@PathVariable("qty") int qty,@PathVariable("id") int id )
    {
        java.util.Optional<CartItem> cartItmFromDb = cartItemRepository.findById(id);
        
        CartItem item=cartItmFromDb.get();
        item.setQuantity(qty);
        item.setPrice(qty*item.getPrice()) ;
        cartItemRepository.save(item);
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
    //Customer Order
    @RequestMapping(value="/getAllOrders")
    public List<CustomerOrder> getAllOrders()
    {
       System.out.println("-------------ctrller url is hit-------");
       List<CustomerOrder> orders=orderService.findAll();
       return orders;
      
    }
    @RequestMapping(value="/orders/{id}")
    public CustomerOrder getOrderByCustId(@PathVariable("id") int id)
    {
       System.out.println("-----------orders url is hit-------");
       //CustomerOrder custOrders=orderService.findOrdersByCustomerId(id);
       return null;
      
    }

    @RequestMapping(value="/{customerId}")
    public CustomerOrder getOrderById(@PathVariable("customerOrderId") int customerOrderId)
    {
       System.out.println("-----------orders url is hit-------");
       CustomerOrder cust=orderService.findById(customerOrderId);
       return cust;
      
    }
    
    @RequestMapping(value="/deleteCustomerOrder/{id}",method = {RequestMethod.GET, RequestMethod.PUT})
    public  void delCustomer(@PathVariable("id") int id)
    {
        orderService.deleteById(id);
    }
    @RequestMapping(value="/saveCustomerOrder", method = RequestMethod.POST)
    public  CustomerOrder saveCustomerOrder(@RequestBody CustomerOrder customerOrder)
    {    
       
        CustomerOrder custOrder=null;//= orderService.saveCustomerOrder(customerOrder);
        return custOrder;
    }
}