package com.example.demo.entity;

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
}