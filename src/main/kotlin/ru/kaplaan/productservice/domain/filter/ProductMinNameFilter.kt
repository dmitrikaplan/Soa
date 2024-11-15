package ru.kaplaan.productservice.domain.filter

import ru.kaplaan.productservice.domain.entity.Product

class ProductMinNameFilter: ProductFilter {

    override fun filter(products: List<Product>): List<Product> {
        if(products.isEmpty())
            return listOf()

        return listOf(products.minBy { it.name })
    }
}