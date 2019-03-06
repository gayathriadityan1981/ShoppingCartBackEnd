package com.example.demo.dao;

import com.example.demo.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductRepository
 */
public interface ProductRepository extends JpaRepository<Product,Integer>{
   
    
}