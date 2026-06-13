package br.com.dte.travelers_archive.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "fichas")
data class FichaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(length = 255, nullable = false)
    val nome: String,

    @ManyToOne
    @JoinColumn(name = "usuario_proprietario", nullable = false)
    val usuarioProprietario: UsuarioEntity,

    @ManyToMany
    @JoinTable(
        name = "fichas_usuarios",
        joinColumns = [JoinColumn(name = "ficha_id")],
        inverseJoinColumns = [JoinColumn(name = "usuario_id")]
    )
    val usuariosComAcesso: MutableList<UsuarioEntity>? = mutableListOf(),

    @Column(name = "token_pic", length = 255)
    val tokenPic: String?,

    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    val modelo: ModeloEntity,

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    val conteudo: Map<String, Any>?

)