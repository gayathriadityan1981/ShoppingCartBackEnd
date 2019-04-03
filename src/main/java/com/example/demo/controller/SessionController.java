package com.example.demo.controller;
//import io.swagger.annotations.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.example.demo.dao.*;
import com.example.demo.entity.*;
import com.example.demo.entity.session.*;
import com.example.demo.entity.response.*;
import com.example.demo.entity.user.*;
import static com.example.demo.entity.response.OperationResponse.*;

/*
This is a dummy rest controller, for the purpose of documentation (/session) path is map to a filter
 - This will only be invoked if security is disabled
 - If Security is enabled then SessionFilter.java is invoked
 - Enabling and Disabling Security is done at config/applicaton.properties 'security.ignored=/**'
*/

@RestController
//@Api(tags = {"Authentication"})
@RequestMapping(value = "/sessionauth")
public class SessionController {

    @Autowired
    private UserRepository userRepo;

   // @ApiResponses(value = { @ApiResponse(code = 200, message = "Will return a security token, which must be passed in every request", response = SessionResponse.class) })
    @RequestMapping(value = "/session", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SessionResponse newSession(@RequestBody Login login, HttpServletRequest request, HttpServletResponse response) {
        User user = userRepo.findOneByUserIdAndPassword(login.getUsername(), login.getPassword()).orElse(null);
        System.out.println("-------------ctrl come sto controller------"+login.getUsername());
        System.out.println("-------------ctrl come sto controller------"+login.getPassword());
        SessionResponse resp = new SessionResponse();
        SessionItem sessionItem = new SessionItem();
        if (user != null){
            sessionItem.setToken("xxx.xxx.xxx");
            sessionItem.setUserId(user.getUserId());
            sessionItem.setFirstName(user.getFirstName());
            sessionItem.setLastName(user.getLastName());
            sessionItem.setEmail(user.getEmail());
            System.out.println("==========role====in user"+user.getUserId());
            System.out.println("==========role====in user"+user.getRole());
            List<Role> roles=new ArrayList();
            roles.add(user.getRole());
            sessionItem.setRole(roles);
            System.out.println("==========role========"+sessionItem.getRole());
            resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
            resp.setOperationMessage("Dummy Login Success");
            resp.setItem(sessionItem);
      }
      else{
            resp.setOperationStatus(ResponseStatusEnum.ERROR);
            resp.setOperationMessage("Login Failed");
      }
     
      return resp;
  }

}