package com.example.demo.service;

import java.util.List;
import java.io.*;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.user.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
@Service
public class UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
	UserDao userDao;
    /*
    public User isValidUser(String username,String password){
      User userAvailable=null;
      userAvailable= userRepository.findByEmailAndPasswrd(username,password);
      System.out.println("----service------userAvailable--"+userAvailable);
      return userAvailable;
    
    }*/
    public String exportToCsv(List<User> users){
        String filePath="d:\\gayathri\\excelFile.xls";
        try{
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Excel Sheet");
        HSSFRow rowhead = sheet.createRow((short) 0);
        rowhead.createCell((short) 0).setCellValue("Name");
        rowhead.createCell((short) 1).setCellValue("Address1");
        rowhead.createCell((short) 2).setCellValue("Address2");
        rowhead.createCell((short) 3).setCellValue("Company");
      
       
        int index = 1;
        int i=0;
        while (i<=users.size()) {
            
            System.out.println("----index--------"+index);
            System.out.println("-----i-------"+i);
                HSSFRow row = sheet.createRow((short) index);
                row.createCell((short) 0).setCellValue(users.get(i).getFullName());
                row.createCell((short) 1).setCellValue(users.get(i).getAddress1());
                row.createCell((short) 2).setCellValue(users.get(i).getAddress2());
                row.createCell((short) 3).setCellValue(users.get(i).getCompany());
                index++;
                i++;
                if(i==users.size()&& index>i){
                    break;
                }
               
        }
       
        FileOutputStream fileOut = new FileOutputStream(filePath);
        wb.write(fileOut);
        fileOut.close();
        System.out.println("Data is saved in excel file successfully.");
    }
    catch(Exception e){
        e.printStackTrace();
    }
    return filePath;
    }

	public List<User> findAll(){
		return userRepository.findAll();
	}
	public User save(User user) {
        System.out.println("--------save -------service------"+user);
		return userRepository.saveAndFlush(user);
	}
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}
	public User update(User user) {
		return userRepository.save(user);
	}

	public User findById(Long id) {
        User user=null;
        //commented to test login
		//User user=userRepository.findById(id).orElse(null);
        return user;
	}
//newly added methods

public String getLoggedInUserId(){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth==null){
        return "nosession";
    }
    return auth.getName();
}


public User getLoggedInUser() {
    String loggedInUserId = this.getLoggedInUserId();
    User user = this.getUserInfoByUserId(loggedInUserId);
    return user;
}

public User getUserInfoByUserId(String userId){
        User user = this.userRepository.findOneByUserId(userId).orElseGet( () -> new User());
        return user;
}

public boolean insertOrSaveUser(User user) {
    this.userRepository.save(user);
    return true;
}

public boolean addNewUser(User user) {
    User newUser = this.getUserInfoByUserId(String.valueOf(user.getUserId()));
    if (String.valueOf(newUser.getUserId()).equals("new")){
        // This means the username is not found therfore its is returning a default value of "new"
        return this.insertOrSaveUser(user);
    }
    else{
        return false;
    }
}
	
    }