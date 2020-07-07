package com.mhamdaoui.kotlin1.springwithkotlin.model

import javax.persistence.*

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
    var role: Role? = null
) {

}