package com.mhamdaoui.kotlin1.springwithkotlin.security

import com.mhamdaoui.kotlin1.springwithkotlin.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(private val user: User): UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities = ArrayList<GrantedAuthority>()
        this.user.getPermissions().forEach { p->
            val authority = SimpleGrantedAuthority(p)
            authorities.add(authority) }

        val authority = SimpleGrantedAuthority("ROLE_" + user.role!!.name)
        authorities.add(authority)

        return authorities
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return this.user.username!!
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return this.user.password!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}