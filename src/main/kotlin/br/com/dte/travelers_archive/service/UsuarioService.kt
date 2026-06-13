package br.com.dte.travelers_archive.service

import br.com.dte.travelers_archive.dto.usuario.UsuarioGetDTO
import br.com.dte.travelers_archive.dto.usuario.UsuarioPatchDTO
import br.com.dte.travelers_archive.dto.usuario.UsuarioPostDTO
import br.com.dte.travelers_archive.exceptions.BusinessRuleException
import br.com.dte.travelers_archive.exceptions.ResourceNotFoundException
import br.com.dte.travelers_archive.mapper.UsuarioMapper
import br.com.dte.travelers_archive.repository.UsuarioRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val mapper: UsuarioMapper,
    private val passwordEncoder: PasswordEncoder
) {
    fun buscaUsuarioPorId(
        id: Long
    ): UsuarioGetDTO {
        val usuarioEntity = repository.findById(id).orElseThrow {
            ResourceNotFoundException("Usuário não encontrado")
        }
        return mapper.entityToGetDTO(usuarioEntity)
    }

    fun cadastraUsuario(
        dto: UsuarioPostDTO
    ): UsuarioGetDTO {
        if(repository.existsByUsername(dto.username)) {
            throw BusinessRuleException("Username já está sendo utilizado!")
        }
        if(repository.existsByEmail(dto.email)) {
            throw BusinessRuleException("Dados inválidos! Tente Novamente.")
        }
        val usuarioEntity = mapper.postDTOToEntity(dto)

        val salvo = repository.save(usuarioEntity)
        return mapper.entityToGetDTO(salvo)
    }

    fun editaUsuario(
        id: Long,
        dto: UsuarioPatchDTO
    ): UsuarioGetDTO {
        val usuarioAntigo = repository.findById(id).orElseThrow {
            ResourceNotFoundException("Usuário não encontrado")
        }
        if(dto.username != null && usuarioAntigo.username != dto.username && repository.existsByUsername(dto.username)) {
            throw BusinessRuleException("Username já está sendo utilizado!")
        }
        if(dto.email != null && usuarioAntigo.email != dto.email && repository.existsByEmail(dto.email)) {
            throw BusinessRuleException("Dados Inválidos! Tente Novamente.")
        }

        val usuarioAtualizado = mapper.patchDTOToEntity(dto, usuarioAntigo)

        val salvo = repository.save(usuarioAtualizado)
        return mapper.entityToGetDTO(salvo)
    }

    fun deletaUsuario(id: Long) {
        if (!repository.existsById(id)) {
            throw ResourceNotFoundException("Usuário não encontrado")
        }
        repository.deleteById(id)
    }
}