package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
               .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/user").access("hasRole('ROLE_USER')")
                .antMatchers("/home").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}pass").roles("USER")
                .and()
                .withUser("dave").password("{noop}begreat").roles("ADMIN");

    }
}
