package br.com.dte.travelers_archive.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "usuarios")
data class UsuarioEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(length = 60, nullable = false, unique = true)
    val username: String,
    @Column(length = 255, unique = true)
    val email: String?,
    @Column(length = 255, nullable = false)
    val password: String,
    @Column(name = "profile_pic", length = 500)
    val profilePic: String?,

    @ManyToMany(mappedBy = "usuariosComAcesso")
    val fichasComAcesso: MutableList<FichaEntity> = mutableListOf(),

    @ManyToMany(mappedBy = "usuariosComAcesso")
    val modelosComAcesso: MutableList<ModeloEntity> = mutableListOf()
)