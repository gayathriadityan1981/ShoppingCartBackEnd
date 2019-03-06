package com.example.demo.service;

import java.util.List;
import java.io.*;
import com.example.demo.dao.CartRepository;
import com.example.demo.entity.Cart;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CartService{

    @Autowired
	CartRepository cartRepository;
    
   public List<Cart> findAll(){
		return cartRepository.findAll();
	}
	public Cart save(Cart cart) {
		return cartRepository.saveAndFlush(cart);
	}
	public void deleteById(int id) {
		cartRepository.deleteById(id);
	}
	public Cart update(Cart cart) {
		return cartRepository.save(cart);
	}

	public Cart findById(int id) {
        Cart cart=null;
       	 cart=cartRepository.findById(id).orElse(null);
        return cart;
	}

	
    }