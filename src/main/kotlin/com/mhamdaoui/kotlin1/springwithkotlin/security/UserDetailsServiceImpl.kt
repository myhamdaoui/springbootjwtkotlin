package com.mhamdaoui.kotlin1.springwithkotlin.security

import com.mhamdaoui.kotlin1.springwithkotlin.dao.RoleRepository
import com.mhamdaoui.kotlin1.springwithkotlin.dao.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val userRepository: UserRepository): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByUsername(username)
        return UserDetailsImpl(user)
    }
}