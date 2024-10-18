package ru.kaplaan.productservice.service

import org.springframework.stereotype.Service
import ru.kaplaan.productservice.domain.entity.Product

@Service
interface ProductService {

    fun save(product: Product): Product

    fun saveAll(products: List<Product>)

    fun getById(id: Long): Product

    fun update(product: Product): Product

    fun deleteById(id: Long)

    fun getAll(fieldName: String, pageSize: Int, pageNumber: Int): List<Product>
}