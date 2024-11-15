package ru.kaplaan.productservice.domain.sorting

import ru.kaplaan.productservice.domain.entity.Product

enum class SortProductFields {
    PRODUCT_NAME, COORDINATES_X, COORDINATES_Y,
    PRICE, MANUFACTURE_COST, UNIT_OF_MEASURE, OWNER_NAME;

    fun sorted(products: List<Product>): List<Product> {
        return when (this) {
            PRODUCT_NAME -> products.sortedBy { it.name }
            COORDINATES_X -> products.sortedBy { it.coordinates.x }
            COORDINATES_Y -> products.sortedBy { it.coordinates.y }
            PRICE -> products.sortedBy { it.price }
            MANUFACTURE_COST -> products.sortedBy { it.manufactureCost }
            UNIT_OF_MEASURE -> products.sortedBy { it.unitOfMeasure }
            OWNER_NAME -> products.sortedBy { it.owner?.name }
        }
    }
}