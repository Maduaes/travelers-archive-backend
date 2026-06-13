package br.com.dte.travelers_archive.mapper

import br.com.dte.travelers_archive.dto.usuario.UsuarioGetDTO
import br.com.dte.travelers_archive.dto.usuario.UsuarioPatchDTO
import br.com.dte.travelers_archive.dto.usuario.UsuarioPostDTO
import br.com.dte.travelers_archive.entity.UsuarioEntity
import org.springframework.stereotype.Component

@Component
class UsuarioMapper() {
    fun entityToGetDTO(
        entity: UsuarioEntity
    ): UsuarioGetDTO {
        val listaFichasAcesso = entity.fichasComAcesso.map { ficha -> ficha.id }.toMutableList()
        val listaModelosAcesso = entity.modelosComAcesso.map { modelo -> modelo.id }.toMutableList()

        return UsuarioGetDTO(
            id = entity.id,
            username = entity.username,
            email = entity.email,
            password = entity.password,
            profilePic = entity.profilePic,
            fichasComAcesso = listaFichasAcesso,
            modelosComAcesso = listaModelosAcesso
        )
    }

    fun postDTOToEntity(
        dto: UsuarioPostDTO
    ): UsuarioEntity {
        return UsuarioEntity(
            username = dto.username,
            email = dto.email,
            password = dto.password,
            profilePic = dto.profilePic,
//          colocar os dados que faltam
        )
    }

    fun patchDTOToEntity(
        dto: UsuarioPatchDTO,
        usuarioAntigo: UsuarioEntity
    ): UsuarioEntity {
        return usuarioAntigo.copy(
            username = dto.username ?: usuarioAntigo.username,
            email = dto.email ?: usuarioAntigo.email,
            password = dto.password ?: usuarioAntigo.password,
            profilePic = dto.profilePic ?: usuarioAntigo.profilePic,
//          colocar os dados que faltam
        )
    }
}