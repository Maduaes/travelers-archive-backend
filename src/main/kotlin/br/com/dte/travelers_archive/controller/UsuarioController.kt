package br.com.dte.travelers_archive.controller

import br.com.dte.travelers_archive.dto.usuario.UsuarioGetDTO
import br.com.dte.travelers_archive.dto.usuario.UsuarioPatchDTO
import br.com.dte.travelers_archive.dto.usuario.UsuarioPostDTO
import br.com.dte.travelers_archive.service.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
class UsuarioController(
    private val service: UsuarioService
) {
    @GetMapping("/{id}")
    fun buscaUsuarioPorId(
        @PathVariable id: Long
    ): ResponseEntity<UsuarioGetDTO> {
        return ResponseEntity.ok(
            service.buscaUsuarioPorId(id)
        )
    }

    @PostMapping("/cadastro")
    fun cadastraUsuario(
        @RequestBody userPostDTO: UsuarioPostDTO
    ): ResponseEntity<UsuarioGetDTO> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                service.cadastraUsuario(userPostDTO)
            )
    }

    @PatchMapping("/{id}")
    fun editaUsuario(
        @PathVariable id: Long,
        @RequestBody userPatchDTO: UsuarioPatchDTO
    ): ResponseEntity<UsuarioGetDTO> {
        return ResponseEntity.ok(
            service.editaUsuario(id, userPatchDTO)
        )
    }

    @DeleteMapping("/{id}")
    fun deletaUsuario(
        @PathVariable id: Long
    ): ResponseEntity<Any> {
        service.deletaUsuario(id)
        return ResponseEntity.noContent().build()
    }
}