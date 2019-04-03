package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;
import java.util.Optional;
import java.util.*;
import com.example.demo.entity.Product.*;
import org.springframework.transaction.annotation.Transactional;
/**
 * ProductRepository
 */
public interface ProductRepository extends JpaRepository<Product,Integer>{
    public List<Product> findAll();
    public Page<Product> findAll(Pageable p);
    Optional<Product> findOneById(Integer id);
    
}