package br.com.dte.travelers_archive.entity

import br.com.dte.travelers_archive.constants.AcessoEnum
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
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
@Table(name = "modelos")
data class ModeloEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(length = 255, nullable = false)
    val nome: String,

    @Column(name = "acesso_externo", nullable = false)
    @Enumerated(EnumType.STRING)
    val acessoExterno: AcessoEnum,

    @ManyToOne
    @JoinColumn(name = "usuario_proprietario", nullable = false)
    val usuarioProprietario: UsuarioEntity,

    @ManyToMany
    @JoinTable(
        name = "modelos_usuarios",
        joinColumns = [JoinColumn(name = "modelo_id")],
        inverseJoinColumns = [JoinColumn(name = "usuario_id")]
    )
    val usuariosComAcesso: MutableList<UsuarioEntity> = mutableListOf(),

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    val config: Map<String, Any>,

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    val layout: Map<String, Any>,

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    val estrutura: Map<String, Any>
)