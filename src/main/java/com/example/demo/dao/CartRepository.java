package com.example.demo.dao;

import com.example.demo.entity.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CartRepository
 */
public interface CartRepository extends JpaRepository<Cart,Integer>{
  
}