package ru.kaplaan.apiservice.domain.exception.exceptionHandler

import jakarta.validation.ConstraintViolationException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.kaplaan.apiservice.domain.exception.ApiException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ApiException::class)
    fun handleProductServiceResponseException(e: ApiException): ResponseEntity<List<String?>> {
        return ResponseEntity
            .status(e.statusCode)
            .body(
                listOf(
                    e.errorCode,
                    e.message
                )
            )
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(e: ConstraintViolationException): ResponseEntity<List<String>> {
        return ResponseEntity
            .badRequest()
            .body(
                e.constraintViolations.map { it.message }
            )
    }
}