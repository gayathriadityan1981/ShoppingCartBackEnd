package com.example.demo.dao;

import com.example.demo.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CustomerRepository
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
  
}