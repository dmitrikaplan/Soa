package ru.kaplaan.productservice.service

import org.springframework.stereotype.Service
import ru.kaplaan.productservice.domain.entity.Product
import ru.kaplaan.productservice.domain.filter.ProductFilter

@Service
interface ProductService {

    fun save(product: Product): Product

    fun saveAll(products: List<Product>)

    fun getById(id: Int): Product

    fun update(product: Product): Product

    fun deleteById(id: Int)

    fun getAll(fieldName: String, filters: List<ProductFilter>, pageSize: Int, pageNumber: Int): List<Product>
}