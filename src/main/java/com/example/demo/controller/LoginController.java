package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import java.security.Principal;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
//import com.example.demo.entity.User;
import com.example.demo.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Base64;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/auth")
class LoginController{

    @Autowired
	UserService userService;
/*
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public  User login(@RequestBody User user)
    {    
        System.out.println("---------ctrller is hit-------1");
        User result=null;
      //  result=userService.isValidUser(user.getEmail(),user.getPassword());
      
		System.out.println("username-------"+user.getEmail());
		System.out.println("username-------"+user.getPassword());
        return result;
    }
	*/
}