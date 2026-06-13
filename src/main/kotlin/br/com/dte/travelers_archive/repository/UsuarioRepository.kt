package br.com.dte.travelers_archive.repository

import br.com.dte.travelers_archive.entity.UsuarioEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<UsuarioEntity, Long> {
    fun existsByEmail(email: String): Boolean
    fun existsByUsername(username: String): Boolean
}