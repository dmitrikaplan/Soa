package ru.kaplaan.productservice.web.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.time.ZonedDateTime

data class PersonDto(
    @field:NotNull(message = "name не может быть null!")
    @field:NotEmpty(message = "name не может быть пустым!")
    val name: String,
    val birthday: ZonedDateTime?,
    @field:NotNull
    val passportID: String
)