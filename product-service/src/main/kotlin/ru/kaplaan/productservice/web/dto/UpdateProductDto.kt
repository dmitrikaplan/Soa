package ru.kaplaan.productservice.web.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import org.springframework.validation.annotation.Validated


data class UpdateProductDto(
    @field:NotEmpty(message = "Строка не может быть пустой!")
    val name: String?,
    val coordinates: CoordinatesDto?,
    @field:Min(1, message = "Стоймость должна быть больше 0!")
    val price: Long?,
    val manufactureCost: Float?,
    val unitOfMeasure: UnitOfMeasure?,
    @Validated
    val owner: PersonDto?
)