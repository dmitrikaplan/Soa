package ru.kaplaan.productservice.web.mapper

import ru.kaplaan.productservice.web.dto.ProductDto
import ru.kaplaan.productservice.domain.entity.Product

fun ProductDto.toEntity() =
    Product().apply {
        name = this@toEntity.name
        coordinates = this@toEntity.coordinates.toEntity()
        manufactureCost = this@toEntity.manufactureCost
        price = this@toEntity.price
        unitOfMeasure = this@toEntity.unitOfMeasure
        owner = this@toEntity.owner?.toEntity()

    }


fun Product.toDto() =
    ProductDto(
        name = this.name,
        coordinates = this.coordinates.toDto(),
        manufactureCost = this.manufactureCost!!,
        price = this.price,
        unitOfMeasure = this.unitOfMeasure,
        owner = this.owner?.toDto()
    ).apply {
        this.id = this@toDto.id
        this.creationDate = this@toDto.creationDate
    }


fun List<Product>.toDto(): List<ProductDto> =
    this.map { it.toDto() }