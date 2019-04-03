package com.example.demo.entity.user;



// io.swagger.annotations.*;
import lombok.*;
import java.util.*;
import com.example.demo.entity.response.*;
@Data

public class Login {

   // @ApiModelProperty(example="demo",required=true)
    private String username="";

   // @ApiModelProperty(example="demo",required=true)
    private String password="";

}
