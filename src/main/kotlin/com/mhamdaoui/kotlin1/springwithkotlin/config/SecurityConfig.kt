package com.mhamdaoui.kotlin1.springwithkotlin.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
@Configuration
class SecurityConfig: WebSecurityConfigurerAdapter(){
    override fun configure(http: HttpSecurity?) {
        http!!.csrf().disable().cors().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/register").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/login").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
    }
}