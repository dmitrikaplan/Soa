package ru.kaplaan.productservice.service.impl

import org.springframework.stereotype.Service
import ru.kaplaan.productservice.domain.entity.Product
import ru.kaplaan.productservice.domain.exception.FieldNotComparableException
import ru.kaplaan.productservice.domain.exception.notFound.FieldNotFoundException
import ru.kaplaan.productservice.domain.exception.PageNumberTooLargeException
import ru.kaplaan.productservice.domain.exception.notFound.ProductNotFoundException
import ru.kaplaan.productservice.repository.ProductRepository
import ru.kaplaan.productservice.service.ProductService
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
): ProductService {

    override fun save(product: Product): Product {
        return productRepository.save(product)
    }

    override fun saveAll(products: List<Product>) {
        productRepository.saveAll(products)
    }

    override fun getById(id: Long): Product {
       return productRepository.findById(id)
            ?: throw ProductNotFoundException()
    }

    override fun update(product: Product): Product {
        return productRepository.update(product)
    }

    override fun deleteById(id: Long) {
        return productRepository.deleteById(id)
    }

    override fun getAll(fieldName: String, pageSize: Int, pageNumber: Int): List<Product> {
        val sortedProducts = sortProductsByField(
            products = productRepository.findAll(),
            fieldName = fieldName
        ).chunked(pageSize)

        if(sortedProducts.size < pageNumber)
            throw PageNumberTooLargeException()

        return sortedProducts[pageNumber - 1]
    }

    private fun sortProductsByField(products: List<Product>, fieldName: String): List<Product> {
        try{
            val property =
                Product::class.memberProperties
                    .firstOrNull {it.name == fieldName}
                    ?.let { it as? KProperty1<Product, Comparable<Any>> }
                    ?: throw FieldNotFoundException()

            return products.sortedBy { property.get(it)}
        } catch (e: ClassCastException){
            throw FieldNotComparableException()
        }
    }
}