package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entity.State;
import com.example.demo.entity.Customer;
import com.example.demo.entity.order.Order;
import com.example.demo.service.CustomerService;
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
@RequestMapping(value="/customers")
class CustomerController{

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value="/getAllCustomers")
    public List<Customer> getAllCustomers()
    {
       System.out.println("-------------ctrller url is hit-------");
       List<Customer> customers=customerService.findAll();
       return customers;
      
    }
    @RequestMapping(value="/orders/{id}")
    public Order getCustomerOrder(@PathVariable("id") int id)
    {
       System.out.println("-----------orders url is hit-------");
       Order custOrders=customerService.findOrdersByCustomerId(id);
       return custOrders;
      
    }

    @RequestMapping(value="/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId)
    {
       System.out.println("-----------orders url is hit-------");
       Customer cust=customerService.findById(customerId);
       return cust;
      
    }
    
    @RequestMapping(value="/deleteCustomer/{customerId}",method = {RequestMethod.GET, RequestMethod.PUT})
    public  void delCustomer(@PathVariable("customerId") int customerId)
    {
      customerService.deleteById(customerId);
    }
    @RequestMapping(value="/saveCustomer", method = RequestMethod.POST)
    public  Customer saveCustomer(@RequestBody Customer customer)
    {    
      Customer cust=null;
      try{
         
      cust=customerService.save(customer);
      }
      catch(Exception e){
         e.printStackTrace();
      }
      return cust;
    }
    /*
    @RequestMapping(value="/editCustomer", method = RequestMethod.POST)
    public  String editCustomer(@RequestBody Customer customer)
    {
        java.util.Optional<Customer> custFromDb = customerRepository.findByCustomerId(Long.parseLong(customer.getCustomerId().toString()));
        
        Customer cust=custFromDb.get();
        cust.setFirstName(customer.getFirstName());
        cust.setShippingAddress(customer.getShippingAddress()); 
        cust.setState(customer.getState()); 
        cust.setCity(customer.getCity()); 
        customerRepository.save(cust);
        return "success";
    }*/
    //to fetch all states for states select box
    @RequestMapping(value="/getAllStates")
    public List<State> getAllStates()
    {   
       List<State> states=customerService.findAllStates();
       System.out.println("-------------ctrller url is hit---getAllStates----"+states);
       return states;
    }
}