package ru.kaplaan.productservice.domain.entity

import ru.kaplaan.productservice.web.dto.PersonDto
import ru.kaplaan.productservice.web.dto.UnitOfMeasure
import java.time.LocalDate

class Product(
    val name: String,
    val coordinates: Coordinates,
    val price: Double,
    val manufactureCost: Float?,
    val unitOfMeasure: UnitOfMeasure?,
    val owner: Person?
){

    val id: Long = productId++
    val creationDate: LocalDate = LocalDate.now()


    companion object{
        private var productId: Long = 1
    }

}