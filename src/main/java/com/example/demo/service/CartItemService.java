package com.example.demo.service;

import java.util.List;
import java.io.*;
import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CustomerOrderRepository;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.CustomerOrder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CartItemService{

    @Autowired
	CartItemRepository cartItemRepository;

	@Autowired
	CustomerOrderRepository customerOrderRepository;
  
	public List<CartItem> findAll(){
		return cartItemRepository.findAll();
	}
	public CartItem save(CartItem cartItem) {
		System.out.println("------service-------save cart item-----------"+cartItem);
		return cartItemRepository.saveAndFlush(cartItem);
	}
	public void deleteById(int id) {
		cartItemRepository.deleteById(id);
	}
	public CartItem update(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	public CartItem findById(int id) {
        CartItem cartItem=null;
     
		cartItem=cartItemRepository.findById(id).orElse(null);
        return cartItem;
	}

	public CustomerOrder saveCustomerOrder(CustomerOrder customerOrder){
		return customerOrderRepository.saveAndFlush(customerOrder);
	}
    }