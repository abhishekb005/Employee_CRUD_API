package com.consultadd.training.config;

import com.consultadd.training.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/createEmployee").permitAll()
        .antMatchers("/authenticate").permitAll()
        .antMatchers("/addEmployee").hasRole("ADMIN")
        .antMatchers("/deleteEmployee/**").hasAuthority("ADMIN")
        .antMatchers("/updateEmployee").hasAnyAuthority("ADMIN","USER")
       .antMatchers(HttpMethod.GET,"/getEmployee").hasRole("ADMIN")
        
        .anyRequest().authenticated().and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
        
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  NoOpPasswordEncoder.getInstance();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // TODO Auto-generated method stub
        return super.authenticationManagerBean();
    }
    
}
