package br.com.dte.travelers_archive.exceptions

import br.com.dte.travelers_archive.dto.ErrorResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleNotFound(
        e: ResourceNotFoundException
    ): ResponseEntity<ErrorResponseDTO> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(
                ErrorResponseDTO(
                    status = 404,
                    message = e.message ?: "Recurso não encontrado"
                )
            )
    }

    @ExceptionHandler(BusinessRuleException::class)
    fun handleBusinessRule(
        e: BusinessRuleException
    ): ResponseEntity<ErrorResponseDTO> {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponseDTO(
                    status = 400,
                    message = e.message ?: "Quebra na Regra de Negócio"
                )
            )
    }
}