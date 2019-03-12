package com.example.demo.entity;
import javax.persistence.*;
@Entity
public  class Login{

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;
	private String username ;
    private String password ;
    public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}