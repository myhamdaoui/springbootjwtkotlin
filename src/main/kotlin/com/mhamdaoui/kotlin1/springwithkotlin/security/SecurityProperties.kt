package com.mhamdaoui.kotlin1.springwithkotlin.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "jwt-security")
class SecurityProperties {
    var secret = "HAMDAOUIMohammedYassinHAMDAOUIMohammedYassinHAMDAOUIMohammedYassinHAMDAOUIMohammedYassinHAMDAOUIMohammedYassinHAMDAOUIMohammedYassin"
    var expirationTime: Int = 31 // in days
    var tokenPrefix = "Bearer "
    var headerString = "Authorization"
    var strength = 10
}