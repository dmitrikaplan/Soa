package ru.kaplaan.productservice.web.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotNull
import validation.Greater

data class CoordinatesDto(
    @field:NotNull(message = "x не может быть null!")
    @field:Greater(value = -642)
    val x: Int,
    @field:NotNull(message = "y не может быть null!")
    @field:Max(643, message = "y не может быть больше 643!")
    val y: Int
)