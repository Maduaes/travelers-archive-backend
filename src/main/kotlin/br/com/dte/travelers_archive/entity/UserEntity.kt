package br.com.dte.travelers_archive.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val username: String,
    val email: String?,
    val password: String,
    val profilePic: String?
)