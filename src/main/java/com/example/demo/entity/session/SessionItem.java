package com.example.demo.entity.session;

import lombok.*;
import java.util.*;
import com.example.demo.entity.user.Role;
//import io.swagger.annotations.ApiModelProperty;

@Data
public class SessionItem{
    private String token;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<Role> role;

}
