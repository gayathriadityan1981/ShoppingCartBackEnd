package com.example.demo.dao;

import com.example.demo.entity.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    public User findOneByEmail(String email);
    
    //public User findByEmailAndPassword(String email,String password);

    @Query("select c from User c where c.email=?1 AND c.password =?2 ")
    public User findByEmailAndPasswrd(String email, String password);

   // @Query("SELECT t.title FROM Todo t where t.id = :id") 
    //String findTitleById(@Param("id") Long id);
     
    Optional<User> findOneByUserId(String userId);
    Optional<User> findOneByUserIdAndPassword(String userId,String password);
}