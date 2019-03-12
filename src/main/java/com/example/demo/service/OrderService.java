package com.example.demo.service;

import java.util.List;
import java.io.*;
import com.example.demo.dao.CustomerOrderRepository;
import com.example.demo.entity.CustomerOrder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderService{

    @Autowired
	CustomerOrderRepository customerOrderRepository;
    
   public List<CustomerOrder> findAll(){
		return customerOrderRepository.findAll();
	}
	public CustomerOrder save(CustomerOrder customerOrder) {
		return customerOrderRepository.saveAndFlush(customerOrder);
	}
	public void deleteById(int id) {
		customerOrderRepository.deleteById(id);
	}
	public CustomerOrder update(CustomerOrder customerOrder) {
		return customerOrderRepository.save(customerOrder);
	}

	public CustomerOrder findById(int id) {
        CustomerOrder order=null;
       	order=customerOrderRepository.findById(id).orElse(null);
        return order;
	}

	
    }