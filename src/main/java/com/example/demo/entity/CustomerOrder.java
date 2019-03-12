package com.example.demo.entity;
import javax.persistence.*;

@Entity
public class CustomerOrder{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private  int customerOrderId;

    @OneToOne
    @JoinColumn(name="cartId")
    private Cart cart;

    @OneToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}