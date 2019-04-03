package com.example.demo.entity;
import javax.persistence.*;
import java.util.*;
@Entity
public class Cart{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String cartId;
    @OneToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    @OneToMany(mappedBy="cart",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<CartItem> cartItems;

    private double totalPrice;

    public double getTotalPrice(){
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice){
        this.totalPrice=totalPrice;
    }

    public String getCartId(){
        return cartId;
    }

    public void setCartId(String cartId){
        this.cartId=cartId;
    }
   public Customer getCustomer()
   {
      return customer;
   }
   public void setCustomer(Customer customer){
       this.customer=customer;
   }

   public void setCartItem(List<CartItem> cartItems){
       this.cartItems=cartItems;
   }
   public List<CartItem> getCartItems(){
       return cartItems;
   }
}