package com.mhamdaoui.kotlin1.springwithkotlin.dao

import com.mhamdaoui.kotlin1.springwithkotlin.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface RoleRepository: JpaRepository<Role, Long> {
    public fun findByName(name:String?): Role
}