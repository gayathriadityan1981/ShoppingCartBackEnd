package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.user.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/users")
class HomeController{

	@Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @RequestMapping(value="/getAllUsers")
    public List<User> getAllUser()
    {
        List<User> users=userService.findAll();
        System.out.println("--------users-------------"+users);
        return users;
    }
    @RequestMapping(value="/getUser/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public  User getUser(@PathVariable("id") Long id)
    {
           User user=userService.findById(id);
           return user;
     //   User user=userRepository.findById(id).orElse(null);
     //   return user;
    }
    @RequestMapping(value="/deleteUser/{id}",method = {RequestMethod.GET, RequestMethod.PUT})
    public  void delUser(@PathVariable("id") int id)
    {
        userService.deleteById(id);
    }
    @RequestMapping(value="/saveUser", method = RequestMethod.POST)
    public  User saveUser(@RequestBody User user)
    {    
        System.out.println("--------save -------ctrller------"+user);
        User usr= userService.save(user);
        return usr;
    }
    /*@RequestMapping(value="/login", method = RequestMethod.POST)
    public  String login(@RequestBody User user)
    {    
        System.out.println("---------ctrller is hit-------1");
        boolean result=userService.isValidUser(user.getUsername(),user.getPassword());
        if (!result) {
            System.out.println("username-------"+user.getPassword());
            return null;
        }
        System.out.println("username-------"+result);
      //  return user;
		System.out.println("username-------"+user.getUsername());
		System.out.println("username-------"+user.getPassword());
        return "success";
    }
 */
   /* @RequestMapping(value="/editUser", method = RequestMethod.POST)
    public  String getUser(@RequestBody User user)
    {
        java.util.Optional<User> userFromDb = userRepository.findById(user.getId());
        
        User usr=userFromDb.get();
        usr.setName(user.getName());
        usr.setAddress1(user.getAddress1()); 
        usr.setAddress2(user.getAddress2()); 
        usr.setCity(user.getCity()); 
        userRepository.save(usr);
        return "success";
    }*/
   //code blocked to test login
   /*
    @RequestMapping(value="/editUser", method = RequestMethod.POST)
    public  String getUser(@RequestBody User user)
    {
     
        java.util.Optional<User> userFromDb = userRepository.findById(user.getId());
        
        User usr=userFromDb.get();
        usr.setName(user.getName());
        usr.setAddress1(user.getAddress1()); 
        usr.setAddress2(user.getAddress2()); 
        usr.setCity(user.getCity()); 
        userRepository.save(usr);
        return "success";
    }*/
}
