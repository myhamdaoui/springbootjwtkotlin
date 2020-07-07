package com.mhamdaoui.kotlin1.springwithkotlin.controller

import com.mhamdaoui.kotlin1.springwithkotlin.dao.RoleRepository
import com.mhamdaoui.kotlin1.springwithkotlin.dao.UserRespository
import com.mhamdaoui.kotlin1.springwithkotlin.dto.RegisterRequest
import com.mhamdaoui.kotlin1.springwithkotlin.dto.RegisterResponse
import com.mhamdaoui.kotlin1.springwithkotlin.model.User
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class AuthController (private val roleRepository: RoleRepository, private val userRespository: UserRespository) {

    @PostMapping("/register")
    public fun register(@RequestBody registerRequest: RegisterRequest): RegisterResponse {
        // Create new user
        var user = User()
        user.username = registerRequest.username
        user.email = registerRequest.email
        user.password = registerRequest.password

        // Find role
        val role = roleRepository.findByName(registerRequest.role)
        user.role = role

        // Save user to DB
        userRespository.save(user)

        return RegisterResponse("REGISTER_SUCCESS")
    }
}