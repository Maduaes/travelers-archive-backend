package br.com.dte.travelers_archive.dto.usuario

data class UsuarioPatchDTO (
    val username: String? = null,
    val email: String? = null,
    val password: String? = null,
    val profilePic: String? = null,
    val fichasComAcesso: MutableList<Long?>? = null,
    val modelosComAcesso: MutableList<Long?>? = null
)