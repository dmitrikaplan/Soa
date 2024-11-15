package ru.kaplaan.productservice.domain.entity

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import ru.kaplaan.productservice.web.dto.PersonDto
import ru.kaplaan.productservice.web.dto.UnitOfMeasure
import java.time.LocalDate

class Product(
    @field:NotNull
    @field:NotEmpty
    val name: String,

    @field:NotNull
    val coordinates: Coordinates,

    @field:Positive
    val price: Long?,

    @field:NotNull
    val manufactureCost: Float,
    val unitOfMeasure: UnitOfMeasure?,
    val owner: Person?
){

    val id: Int = productId++
    val creationDate: LocalDate = LocalDate.now()


    companion object{
        private var productId: Int = 1
    }

}