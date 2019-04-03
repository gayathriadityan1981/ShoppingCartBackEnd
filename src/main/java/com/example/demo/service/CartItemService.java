package com.example.demo.service;

import java.util.List;
import java.io.*;
import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.order.Order;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
@Service
public class CartItemService{

    @Autowired
	CartItemRepository cartItemRepository;

	@Autowired
	OrderRepository orderRepository;
  
	public List<CartItem> findAll(){
		return cartItemRepository.findAll();
	}
	public List<CartItem> saveCartItem(List<CartItem> cartItems) {
		System.out.println("------service-------save cart item-----------"+cartItems);
	for(CartItem cartItem:cartItems)
		{
		 cartItemRepository.saveAndFlush(cartItem);
		}
		return cartItems;
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

	public Order saveCustomerOrder(Order order){
		return orderRepository.saveAndFlush(order);
	}
    }