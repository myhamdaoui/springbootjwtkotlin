package com.mhamdaoui.kotlin1.springwithkotlin.controller

import com.mhamdaoui.kotlin1.springwithkotlin.service.UserService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
class UserController(
        val userService: UserService
) {
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public fun adminArea(): String {
        return userService.adminArea()
    }

    @GetMapping("/ba")
    @PreAuthorize("hasRole('BA')")
    public fun baArea(): String {
        return return userService.baArea()
    }
}