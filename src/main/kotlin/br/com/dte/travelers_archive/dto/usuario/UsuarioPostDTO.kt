package br.com.dte.travelers_archive.dto.usuario

data class UsuarioPostDTO(
    val username: String,
    val email: String,
    val password: String,
    val passwordConfirm: String,
    val profilePic: String? = null,
    val fichasComAcesso: MutableList<Long?> = mutableListOf(),
    val modelosComAcesso: MutableList<Long?> = mutableListOf()
)