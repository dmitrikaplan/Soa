package ru.kaplaan.productservice.web.controller.exceptionHandler

import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.kaplaan.productservice.domain.exception.ApiException
import ru.kaplaan.productservice.domain.exception.not_found.NotFoundException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(e: ConstraintViolationException): ResponseEntity<List<String>> {
        return ResponseEntity
            .badRequest()
            .body(
                e.constraintViolations.map { it.message }
            )
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(e: NotFoundException): ResponseEntity<List<String?>> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND.value())
            .body(
                listOf(
                    e.errorCode,
                    e.message
                )
            )
    }


    @ExceptionHandler(ApiException::class)
    fun handleApiException(e: ApiException): ResponseEntity<List<String?>> {
        return ResponseEntity.badRequest().body(
            listOf(
                e.errorCode,
                e.message
            )
        )
    }
}