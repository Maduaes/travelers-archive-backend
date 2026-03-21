package br.com.dte.travelers_archive.dto.user

data class UserPostDTO(
    val id: Long? = null,
    val username: String,
    val email: String?,
    val password: String,
    val passwordConfirm: String,
    val profilePic: String? = null
)