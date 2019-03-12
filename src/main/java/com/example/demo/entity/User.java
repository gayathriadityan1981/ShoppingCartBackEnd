package com.example.demo.entity;
import javax.persistence.*;
@Entity
public  class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;
	private String username ;
	private String password ;
	private String  role;
    private String name;
    private String address1;
    private String address2;
	private String city;
	public User(){}
	public String getAddress1(){
        return address1;
    }
    public void setAddress1(String address1){
        this.address1=address1;
    }
    public String getAddress2(){
        return address2;
    }
    public void setAddress2(String address2){
        this.address2=address2;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city=city;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	
}