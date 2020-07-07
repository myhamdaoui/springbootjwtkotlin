package com.mhamdaoui.kotlin1.springwithkotlin.config

import com.mhamdaoui.kotlin1.springwithkotlin.security.UserDetailsServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import org.springframework.security.crypto.password.PasswordEncoder




@EnableWebSecurity
@Configuration
class SecurityConfig(private val userDetailsServiceImpl: UserDetailsServiceImpl): WebSecurityConfigurerAdapter(){
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

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userDetailsServiceImpl)?.passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}