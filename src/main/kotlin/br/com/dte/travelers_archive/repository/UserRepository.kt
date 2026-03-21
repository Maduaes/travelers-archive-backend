package br.com.dte.travelers_archive.repository

import br.com.dte.travelers_archive.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserEntity, Long> {
//    fun findById(id: Long): UserEntity?
}