package com.example.demo.service;

import java.util.List;
import java.io.*;
import com.example.demo.dao.OrderRepository;
import com.example.demo.entity.order.Order;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderService{

    @Autowired
	OrderRepository orderRepository;
    
   public List<Order> findAll(){
		return orderRepository.findAll();
	}
	public Order saveOrder(Order customerOrder) {
		return orderRepository.saveAndFlush(customerOrder);
	}
	public void deleteById(int id) {
		orderRepository.deleteById(id);
	}
	public Order update(Order customerOrder) {
		return orderRepository.save(customerOrder);
	}

	public Order findById(int id) {
        Order order=null;
       	order=orderRepository.findById(id).orElse(null);
        return order;
	}

	
    }