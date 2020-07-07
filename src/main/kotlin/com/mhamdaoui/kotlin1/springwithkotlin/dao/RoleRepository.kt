package com.mhamdaoui.kotlin1.springwithkotlin.dao

import com.mhamdaoui.kotlin1.springwithkotlin.model.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<Role, Long> {
    public fun findByName(name:String?): Role
}