package br.com.dte.travelers_archive.mapper

import br.com.dte.travelers_archive.dto.user.UserGetDTO
import br.com.dte.travelers_archive.dto.user.UserPostDTO
import br.com.dte.travelers_archive.entity.UserEntity
import org.springframework.stereotype.Component
import kotlin.Long

@Component
class UserMapper() {
    fun entityToDTO(
        entity: UserEntity
    ): UserGetDTO {
        return UserGetDTO(
            id = entity.id,
            username = entity.username,
            email = entity.email,
            password = entity.password,
            profilePic = entity.profilePic
        )
    }

    fun dtoToEntity(
        dto: UserPostDTO
    ): UserEntity {
        return UserEntity(
            id = dto.id,
            username = dto.username,
            email = dto.email,
            password = dto.password,
            profilePic = dto.profilePic
        )
    }
}