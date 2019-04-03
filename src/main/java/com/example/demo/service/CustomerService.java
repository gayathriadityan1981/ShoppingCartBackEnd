package com.example.demo.service;

import java.util.List;
import java.io.*;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.dao.StateRepository;
import com.example.demo.entity.Customer;
import com.example.demo.entity.State;
import com.example.demo.entity.order.Order;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerService{

    @Autowired
	CustomerRepository customerRepository;
    
    @Autowired
	OrderRepository orderRepository;
	
	@Autowired
	StateRepository stateRepository;
    
   public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	public Customer save(Customer customer) {
		Customer customr= customerRepository.saveAndFlush(customer);
		return customr;
	}
	public void deleteById(int customerId) {
		customerRepository.deleteById(customerId);
	}
	public Customer update(Customer customer) {

		return customerRepository.save(customer);
	}

	public Customer findById(int customerId) {
        Customer cust=null;
       	 cust=customerRepository.findById(customerId).orElse(null);
        return cust;
	}

    public Order findOrdersByCustomerId(int customerId){
		Order custOrders=null;
    //    CustomerOrder custOrders=customerOrderRepository.findOrdersByCustomerId(Long.parseLong(String.valueOf(id)));
        return custOrders;
    }
	
	public List<State> findAllStates(){
		return stateRepository.findAll();
	}
    }