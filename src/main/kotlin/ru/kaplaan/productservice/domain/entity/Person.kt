package ru.kaplaan.productservice.domain.entity

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.ZonedDateTime

class Person(
    @field:NotNull
    @field:NotEmpty
    val name: String,
    val birthday: ZonedDateTime?,

    @field:NotNull
    val passportID: String
)