package com.example.demo.service;

import java.util.List;
import java.io.*;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.UserDao;;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;

@Service
public class UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
	UserDao userDao;
    
    public boolean isValidUser(String username,String password){
      /* boolean result=false;
       User userAvailable= userDao.findByUsernamePassword(username,password);
       System.out.println("-------------user----1---"+userAvailable);
       if(userAvailable!=null){
        System.out.println("-------------user-----2--"+userAvailable);
            result=true;
       }    
       
       System.out.println("-----------result----atlast--"+result);*/
       return true;
    
    }
    public String exportToCsv(List<User> users){
        String filePath="d:\\gayathri\\excelFile.xls";
        try{
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Excel Sheet");
        HSSFRow rowhead = sheet.createRow((short) 0);
        rowhead.createCell((short) 0).setCellValue("Name");
        rowhead.createCell((short) 1).setCellValue("Address1");
        rowhead.createCell((short) 2).setCellValue("Address2");
        rowhead.createCell((short) 3).setCellValue("City");
      
       
        int index = 1;
        int i=0;
        while (i<=users.size()) {
            
            System.out.println("----index--------"+index);
            System.out.println("-----i-------"+i);
                HSSFRow row = sheet.createRow((short) index);
                row.createCell((short) 0).setCellValue(users.get(i).getName());
                row.createCell((short) 1).setCellValue(users.get(i).getAddress1());
                row.createCell((short) 2).setCellValue(users.get(i).getAddress2());
                row.createCell((short) 3).setCellValue(users.get(i).getCity());
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

	
    }