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
@RequestMapping(value="/reports")
class ReportController{
    @Autowired
    UserService userService;

    @RequestMapping(value="/userReports", method = RequestMethod.POST)
    public  String userReport(@RequestBody List<User> users)
    {    
       String filePath= userService.exportToCsv(users);
       return filePath;
    }
}