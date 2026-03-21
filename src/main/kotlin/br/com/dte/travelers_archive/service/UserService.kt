package br.com.dte.travelers_archive.service

import br.com.dte.travelers_archive.dto.user.UserGetDTO
import br.com.dte.travelers_archive.dto.user.UserPostDTO
import br.com.dte.travelers_archive.mapper.UserMapper
import br.com.dte.travelers_archive.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository,
    private val mapper: UserMapper
) {
    fun buscaUserPorId(
        id: Long
    ): UserGetDTO {
        try{
            val userEntity = repository.findById(id).orElseThrow {
                Exception("Not Found")
            }
            return mapper.entityToDTO(userEntity)
        }catch (e: Exception) {
            println(e.message)
            throw Exception(e.message)
        }
    }

    fun cadastraUser(
        userPostDTO: UserPostDTO
    ): UserGetDTO {
       TODO()
    }

    fun editaUser(
        userPostDTO: UserPostDTO
    ): UserGetDTO {
        TODO()
    }

    fun deletaUser(
        id: Long
    ) {
        TODO()
    }
}