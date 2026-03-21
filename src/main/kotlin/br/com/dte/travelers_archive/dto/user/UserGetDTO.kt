package br.com.dte.travelers_archive.dto.user

data class UserGetDTO(
    val id: Long?,
    val username: String,
    val email: String?,
    val password: String,
    val profilePic: String?
)