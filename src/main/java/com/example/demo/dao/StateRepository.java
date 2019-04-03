package com.example.demo.dao;

import com.example.demo.entity.State;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State,Integer>{

}