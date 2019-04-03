package com.example.demo.entity;
import javax.persistence.*;

@Entity
public class State{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int stateId;
    private String abbreviation;
    private String name;

    public int getStateId(){
        return stateId;
    }
    public void setStateId(int stateId){
        this.stateId=stateId;
    }
    public String getAbbreviation(){
        return abbreviation;
    }
    public void setAbbreviation(String abbreviation){
        this.abbreviation=abbreviation;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}