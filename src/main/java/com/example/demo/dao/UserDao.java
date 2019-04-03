package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
@Repository
@CrossOrigin(origins = "*")
public class UserDao {

    @Autowired
    EntityManager entityManager;
  

   
    public User findByUsernamePassword(String username,String password){
        String qry = "SELECT ua FROM User ua WHERE ua.username=:username and ua.password=:password";
        Query query = entityManager.createQuery(qry);
        query.setParameter("username", username);
        query.setParameter("password", password);
        User ua = (User) query.getSingleResult();
        System.out.print("-----dao-------"+ua);
        return ua;
    }
}