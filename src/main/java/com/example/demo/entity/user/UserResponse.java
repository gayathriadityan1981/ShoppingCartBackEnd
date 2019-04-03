package com.example.demo.entity.user;


//import io.swagger.*;
import lombok.*;
import java.util.*;
import com.example.demo.entity.response.*;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserResponse extends OperationResponse{
    private User data=new User();
}