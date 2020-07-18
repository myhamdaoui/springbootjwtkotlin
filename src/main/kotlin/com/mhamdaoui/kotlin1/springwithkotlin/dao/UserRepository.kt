package com.mhamdaoui.kotlin1.springwithkotlin.dao

import com.mhamdaoui.kotlin1.springwithkotlin.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface UserRepository: JpaRepository<User, Long>{
    public fun findByUsername(name: String?): User?
    public fun findByEmail(name: String?): User?
}