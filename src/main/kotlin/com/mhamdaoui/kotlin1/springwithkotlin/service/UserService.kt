package com.mhamdaoui.kotlin1.springwithkotlin.service

import org.springframework.stereotype.Service

@Service
class UserService {
    public fun adminArea() = "Admin area"

    public fun baArea() = "BA area"
}