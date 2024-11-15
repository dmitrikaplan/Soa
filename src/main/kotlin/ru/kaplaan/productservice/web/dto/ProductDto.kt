package ru.kaplaan.productservice.web.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import org.springframework.validation.annotation.Validated
import ru.kaplaan.productservice.web.validation.OnCreate
import ru.kaplaan.productservice.web.validation.OnUpdate
import java.time.LocalDate

data class ProductDto(
    @field:NotNull(message = "Имя не может быть null!", groups = [OnCreate::class, OnUpdate::class])
    @field:NotEmpty(message = "Строка не может быть пустой!", groups = [OnCreate::class, OnUpdate::class])
    val name: String,
    @field:NotNull(message = "Coordinates не можкт быть null!", groups = [OnCreate::class, OnUpdate::class])
    val coordinates: CoordinatesDto,
    @field:Min(1, message = "Стоймость должна быть больше 0!", groups = [OnCreate::class, OnUpdate::class])
    val price: Long?,
    @field:NotNull(groups = [OnCreate::class, OnUpdate::class])
    val manufactureCost: Float,
    val unitOfMeasure: UnitOfMeasure?,
    @Validated
    val owner: PersonDto?
){
    @field:Null(message = "Id должно быть не null!", groups = [OnCreate::class])
    @field:NotNull(message = "Id не может быть null!", groups = [OnUpdate::class])
    var id: Int? = null

    @field:Null(message = "CreationDate должно быть не null!", groups = [OnCreate::class])
    @field:NotNull(message = "CreationDate не может быть null!", groups = [OnUpdate::class])
    var creationDate: LocalDate? = null

}