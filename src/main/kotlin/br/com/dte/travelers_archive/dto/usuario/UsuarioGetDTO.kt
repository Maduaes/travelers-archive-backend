package br.com.dte.travelers_archive.dto.usuario

data class UsuarioGetDTO(
    val id: Long?,
    val username: String,
    val email: String?,
    val password: String,
    val profilePic: String?,
    val fichasComAcesso: MutableList<Long?> = mutableListOf(),
    val modelosComAcesso: MutableList<Long?> = mutableListOf()
)