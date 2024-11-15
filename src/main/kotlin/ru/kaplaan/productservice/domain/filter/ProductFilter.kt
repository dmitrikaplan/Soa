package ru.kaplaan.productservice.domain.filter

import ru.kaplaan.productservice.domain.entity.Product

interface ProductFilter {

    fun filter(products: List<Product>): List<Product>

}