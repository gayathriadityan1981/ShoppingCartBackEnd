package com.example.demo.config;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.example.demo.identity.*;
import org.springframework.core.annotation.Order;


@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenUtil tokenUtil;

 

    //If Security is not working check application.properties if it is set to ignore
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("---Security--------"+http); 
        http.authorizeRequests().antMatchers("/", "/register","/users/saveUser", "users/getAllUsers","orders/saveCartItems","/products/getAllProducts","/sessionauth/session","/login", "/logout","/customers/deleteCustomer/*").permitAll();
        http
        .exceptionHandling().and()
        .anonymous().and()
        // Disable Cross site references
        .csrf().disable()
        // Add CORS Filter
        .addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
        // Custom Token based authentication based on the header previously given to the client
      /*  .addFilterBefore(new VerifyTokenFilter(tokenUtil), UsernamePasswordAuthenticationFilter.class)
        // custom JSON based authentication by POST of {"username":"<name>","password":"<password>"} which sets the token header upon authentication
        .addFilterBefore(new GenerateTokenForUserFilter ("/session", authenticationManager(), tokenUtil), UsernamePasswordAuthenticationFilter.class)  
        .authorizeRequests()
        .anyRequest().authenticated()
        ;*/
    }

    /*
    * If You want to store encoded password in your databases and authenticate user
    * based on encoded password then uncomment the below method and provde an encoder
    //@Autowired
    //private UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    */
}
