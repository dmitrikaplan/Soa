package ru.kaplaan.productservice

import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.kaplaan.productservice.domain.entity.Coordinates
import ru.kaplaan.productservice.domain.entity.Product
import ru.kaplaan.productservice.service.ProductService
import ru.kaplaan.productservice.web.dto.UnitOfMeasure

@SpringBootApplication
class ProductServiceApplication(
    private val productService: ProductService
){

    @PostConstruct
    fun postConstruct(){
        productService.saveAll(
            listOf(
                Product(
                    name = "Пицца",
                    coordinates = Coordinates(0, 1),
                    price = 100,
                    manufactureCost = 56.0f,
                    unitOfMeasure = UnitOfMeasure.KILOGRAMS,
                    owner = null
                ),
                Product(
                    name = "Роллы",
                    coordinates = Coordinates(0, 1),
                    price = 10,
                    manufactureCost = 6.0f,
                    unitOfMeasure = UnitOfMeasure.KILOGRAMS,
                    owner = null
                ),
                Product(
                    name = "Гречка",
                    coordinates = Coordinates(0, 1),
                    price = 78,
                    manufactureCost = 56.0f,
                    unitOfMeasure = UnitOfMeasure.KILOGRAMS,
                    owner = null
                )
            )
        )
    }
}

fun main(args: Array<String>) {
    runApplication<ProductServiceApplication>(*args)
}
