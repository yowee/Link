package com.Link.Link.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class AppUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val username: String,
    val email: String,
    val age: Int,
    var isActive: Boolean = true,
    val lastLogin: LocalDateTime? = null
)
