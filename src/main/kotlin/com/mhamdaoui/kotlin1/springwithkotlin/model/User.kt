package com.mhamdaoui.kotlin1.springwithkotlin.model

import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "username")
    var username: String? = null,

    @Column(name = "password")
    var password: String? = null,

    @Column(name = "email")
    var email: String? = null,

    @ManyToOne
    @JoinColumn(name = "role_id")
    var role: Role? = null,

    @Column(name = "permissions")
    var permissions: String? = ""
) {

    fun getPermissions(): List<String> {
        if (this.permissions!!.isNotEmpty())
        {
            return listOf<String>(*this.permissions!!.split((",").toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
        }
        return ArrayList<String>()
    }

}