package com.example.demo.dao;

import com.example.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    public User findOneByUsername(String username);
    
    public User findByUsernameAndPassword(String username,String password);

   // @Query("SELECT t.title FROM Todo t where t.id = :id") 
    //String findTitleById(@Param("id") Long id);
     
}