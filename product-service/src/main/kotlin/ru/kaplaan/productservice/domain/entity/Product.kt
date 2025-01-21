package ru.kaplaan.productservice.domain.entity

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import ru.kaplaan.productservice.web.dto.UnitOfMeasure
import java.time.LocalDate

class Product(
    @field:NotNull
    @field:NotEmpty
    var name: String,

    @field:NotNull
    var coordinates: Coordinates,

    @field:Positive
    var price: Long?,

    @field:NotNull
    var manufactureCost: Float,
    var unitOfMeasure: UnitOfMeasure?,
    var owner: Person?
){

    var id: Int = productId++
    var creationDate: LocalDate = LocalDate.now()


    companion object{
        private var productId: Int = 1
    }

}