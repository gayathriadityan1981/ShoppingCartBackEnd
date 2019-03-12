package com.example.demo.service;

import java.util.List;
import java.io.*;
import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService{

    @Autowired
	ProductRepository productRepository;
    
   

	public List<Product> findAll(){
		return productRepository.findAll();
	}
	public Product save(Product product) {
		return productRepository.saveAndFlush(product);
	}
	public void deleteById(int id) {
		productRepository.deleteById(id);
	}
	public Product update(Product product) {
		return productRepository.save(product);
	}

	public Product findById(int id) {
        Product product=null;
       
		product=productRepository.findById(id).orElse(null);
	   return product;
	}

	
    }