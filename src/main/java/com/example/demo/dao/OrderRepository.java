package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;
import java.util.Optional;
import java.util.*;
import com.example.demo.entity.order.*;
import org.springframework.transaction.annotation.Transactional;
/**
 * ProductRepository
 */
public interface OrderRepository extends JpaRepository<Order,Integer>{
    public List<Order> findAll();

   // @Query("SELECT c.customerOrderId FROM CustomerOrder c  where c.customerOrderId = :customerOrderId ") 
    //Order findOrdersByCustomerId(@Param("customerOrderId") Long customerOrderId);
 
    public Page<Order> findAll(Pageable p);
    Optional<Order> findOneById(Integer id);
    
}