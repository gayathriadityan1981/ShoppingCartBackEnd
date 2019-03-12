package com.example.demo.service;

import java.util.List;
import java.io.*;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.CustomerOrderRepository;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerOrder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerService{

    @Autowired
	CustomerRepository customerRepository;
    
    @Autowired
	CustomerOrderRepository customerOrderRepository;
    
   public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	public Customer save(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}
	public void deleteById(int id) {
		customerRepository.deleteById(id);
	}
	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer findById(int id) {
        Customer cust=null;
       	 cust=customerRepository.findById(id).orElse(null);
        return cust;
	}

    public CustomerOrder findOrdersByCustomerId(int id){
        CustomerOrder custOrders=customerOrderRepository.findOrdersByCustomerId(Long.parseLong(String.valueOf(id)));
        return custOrders;
    }
	
    }