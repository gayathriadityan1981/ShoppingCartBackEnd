package com.example.demo.controller.product;

import javax.servlet.http.*;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import java.util.*;
import java.lang.*;
import com.example.demo.controller.*;
import com.example.demo.entity.Product.*;
import com.example.demo.dao.*;
import com.example.demo.entity.response.*;
import static com.example.demo.entity.response.OperationResponse.*;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)

public class ProductController {

    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private ProductRepository productRepo;

    
    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    public List<Product> getAllProducts()
    {
       System.out.println("--------pdt-----ctrller url is hit-------");
       List<Product> pdts=productRepo.findAll();
       return pdts;
      
    }
    
    @RequestMapping(value = "/products", method = RequestMethod.POST, produces = {"application/json"})
    public OperationResponse addNewProduct(@RequestBody Product product, HttpServletRequest req) {

        OperationResponse resp = new OperationResponse();

        if (this.productRepo.existsById(product.getId()) ){
            resp.setOperationStatus(ResponseStatusEnum.ERROR);
            resp.setOperationMessage("Unable to add Product - Product allready exist ");
        }
        else{
            //Product addedProduct = this.productRepo.save(product);
            this.productRepo.save(product);
            resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
            resp.setOperationMessage("Product Added");
        }
        return resp;
    }

    @RequestMapping(value="/{productId}")
    public Product getCustomer(@PathVariable("productId") int productId)
    {
       System.out.println("--------findbyid---pdts url is hit-------");
       Product pdt=productRepo.findById(productId).orElse(null);
       return pdt;
      
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE, produces = {"application/json"})
    public OperationResponse deleteProduct(@PathVariable("productId") Integer productId, HttpServletRequest req) {
        OperationResponse resp = new OperationResponse();
        if (this.productRepo.existsById(productId) ){
            this.productRepo.deleteById(productId);
            resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
            resp.setOperationMessage("Product Deleted");
        }
        else{
            resp.setOperationStatus(ResponseStatusEnum.ERROR);
            resp.setOperationMessage("No Product Exist");
        }
        return resp;
    }



}