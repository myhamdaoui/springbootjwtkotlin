package com.mhamdaoui.kotlin1.springwithkotlin.controller

import com.mhamdaoui.kotlin1.springwithkotlin.dao.RoleRepository
import com.mhamdaoui.kotlin1.springwithkotlin.dao.UserRepository
import com.mhamdaoui.kotlin1.springwithkotlin.dto.RegisterRequest
import com.mhamdaoui.kotlin1.springwithkotlin.dto.RegisterResponse
import com.mhamdaoui.kotlin1.springwithkotlin.model.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
class AuthController (private val roleRepository: RoleRepository, private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder) {

    @PostMapping("/register")
    public fun register(@RequestBody registerRequest: RegisterRequest): RegisterResponse {
        // Check if user exists
        var emailExists = userRepository.findByEmail(registerRequest.email)

        var userNameExists = userRepository.findByUsername(registerRequest.username)

        if(emailExists != null) throw RuntimeException("EMAIL_TAKEN")

        if(userNameExists != null) throw RuntimeException("USERNAME_TAKEN")

        // Create new user
        var user = User()

        user.username = registerRequest.username
        user.email = registerRequest.email
        user.password = passwordEncoder.encode(registerRequest.password)
        user.permissions = registerRequest.permissions

        // Find role
        val role = roleRepository.findByName(registerRequest.role)
        user.role = role

        // Save user to DB
        userRepository.save(user)

        return RegisterResponse("REGISTER_SUCCESS")
    }
}