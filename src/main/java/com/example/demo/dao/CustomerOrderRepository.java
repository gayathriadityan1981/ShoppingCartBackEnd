package com.example.demo.dao;

import com.example.demo.entity.CustomerOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

/**
 * CustomerOrderRepository
 */
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Integer>{

   @Query("SELECT c.customerOrderId FROM CustomerOrder c  where c.customerOrderId = :customerOrderId ") 
   CustomerOrder findOrdersByCustomerId(@Param("customerOrderId") Long customerOrderId);
}