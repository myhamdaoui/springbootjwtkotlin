package com.mhamdaoui.kotlin1.springwithkotlin.config

import com.mhamdaoui.kotlin1.springwithkotlin.security.JWTAuthenticationFilter
import com.mhamdaoui.kotlin1.springwithkotlin.security.JWTAuthorizationFilter
import com.mhamdaoui.kotlin1.springwithkotlin.security.SecurityProperties
import com.mhamdaoui.kotlin1.springwithkotlin.security.UserDetailsServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //  enables the @PreAuthorize annotation
class SecurityConfig(
        private val userDetailsServiceImpl: UserDetailsServiceImpl,
        val securityProperties: SecurityProperties
): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http!!.cors().and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // no sessions
                .and()
                .authorizeRequests()
                .antMatchers("/error/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/register", "/api/v1/login").permitAll()
                .antMatchers("/users/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(JWTAuthenticationFilter(authenticationManager(), securityProperties))
                .addFilter(JWTAuthorizationFilter(authenticationManager(), securityProperties))
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userDetailsServiceImpl)?.passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }
}