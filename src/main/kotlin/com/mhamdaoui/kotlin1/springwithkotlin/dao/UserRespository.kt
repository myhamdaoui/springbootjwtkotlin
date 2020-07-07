package com.mhamdaoui.kotlin1.springwithkotlin.dao

import com.mhamdaoui.kotlin1.springwithkotlin.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRespository: JpaRepository<User, Long>{
}