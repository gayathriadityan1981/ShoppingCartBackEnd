package com.example.demo.entity.Product;
import lombok.*;
import java.util.*;
import javax.persistence.*;


@Data
@Entity
@Table(name = "products")
public class Product  {
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String  productCode;
    private String  productName;
    private String  description;
    private Long    standardCost;
    private Long    listPrice;
    private Integer targetLevel;
    private Integer reorderLevel;
    private Integer minimumReorderQuantity;
    private String  quantityPerUnit;
    private Integer discontinued;
    //@ApiModelProperty(allowableValues = "Camera, Laptop, Tablet, Phone") 
    private String category;
    public Product(){}
}
/*
import javax.persistence.*;
@Entity
public class Product{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id ;
    private String name;
    private float price;
    private String image;

    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setImage(String image){
        this.image=image;
    }
    public String getImage(){
        return image;
    }
    public void setPrice(float price){
        this.price=price;
    }
    public float getPrice(){
        return price;
    }
}*/
