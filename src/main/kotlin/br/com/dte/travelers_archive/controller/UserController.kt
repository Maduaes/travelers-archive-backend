package br.com.dte.travelers_archive.controller

import br.com.dte.travelers_archive.dto.user.UserGetDTO
import br.com.dte.travelers_archive.dto.user.UserPostDTO
import br.com.dte.travelers_archive.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val service: UserService
) {
    @GetMapping("/{id}")
    fun buscaUserPorId(
        @PathVariable id: Long
    ): ResponseEntity<UserGetDTO> {
        return ResponseEntity.ok(
            service.buscaUserPorId(id)
        )
    }

    @PostMapping("/cadastro")
    fun cadastraUser(
        @RequestBody userPostDTO: UserPostDTO
    ): ResponseEntity<UserGetDTO> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                service.cadastraUser(userPostDTO)
            )
    }

    @PatchMapping
    fun editaUser(
        @RequestBody userPostDTO: UserPostDTO
    ): ResponseEntity<UserGetDTO> {
        return ResponseEntity.ok(
            service.editaUser(userPostDTO)
        )
    }

    @DeleteMapping("/{id}")
    fun deletaUser(
        @PathVariable id: Long
    ): ResponseEntity<Any> {
        service.deletaUser(id)
        return ResponseEntity.noContent().build()
    }
}