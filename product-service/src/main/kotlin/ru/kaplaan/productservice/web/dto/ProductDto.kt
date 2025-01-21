package ru.kaplaan.productservice.web.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import org.springframework.validation.annotation.Validated
import java.time.LocalDate

data class ProductDto(
    @field:NotNull(message = "Имя не может быть null!")
    @field:NotEmpty(message = "Строка не может быть пустой!")
    val name: String,
    @field:NotNull(message = "Coordinates не может быть null!")
    val coordinates: CoordinatesDto,
    @field:Min(1, message = "Стоймость должна быть больше 0!")
    val price: Long?,
    @field:NotNull
    val manufactureCost: Float,
    val unitOfMeasure: UnitOfMeasure?,
    @Validated
    val owner: PersonDto?
){
    @field:Null(message = "Id должно быть null!")
    var id: Long? = null

    @field:Null(message = "CreationDate должно быть null!")
    var creationDate: LocalDate? = null
}