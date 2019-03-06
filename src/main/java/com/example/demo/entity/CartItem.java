package com.example.demo.entity;

import com.example.demo.entity.Product;
import javax.persistence.*;
@Entity
public class CartItem{
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int cartItemId ;

    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name="cartId")
    private Cart cart;


    public int getCartItemId(){
        return cartItemId;
    }
    public void setProduct(Product product){
        this.product=product;
    }
    public Product getProduct(){
        return product;
    }
    public void setCart(Cart cart){
        this.cart=cart;
    }
    public Cart getCart(){
        return cart;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
}