package com.example.demo.entity.data;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import javax.persistence.*;
//import io.swagger.annotations.ApiModelProperty;

@Data
public class SingleSeries{
    private String name;
    private BigDecimal value;

    public SingleSeries(String name,BigDecimal value){
        this.name=name;
        this.value=value;
    }
}