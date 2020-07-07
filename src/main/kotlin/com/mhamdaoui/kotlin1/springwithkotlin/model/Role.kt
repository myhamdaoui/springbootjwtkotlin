package com.mhamdaoui.kotlin1.springwithkotlin.model

import javax.persistence.*

@Entity
@Table(name="roles")
class Role (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String? = null,

        @OneToMany(mappedBy = "role")
        var users: List<User>? = null
)