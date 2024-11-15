package ru.kaplaan.productservice.service.impl

import org.springframework.stereotype.Service
import ru.kaplaan.productservice.domain.entity.Product
import ru.kaplaan.productservice.domain.exception.PageNumberTooLargeException
import ru.kaplaan.productservice.domain.exception.notFound.ProductNotFoundException
import ru.kaplaan.productservice.domain.filter.ProductFilter
import ru.kaplaan.productservice.domain.sorting.SortProductFields
import ru.kaplaan.productservice.repository.ProductRepository
import ru.kaplaan.productservice.service.ProductService

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

    override fun getById(id: Int): Product {
       return productRepository.findById(id)
            ?: throw ProductNotFoundException()
    }

    override fun update(product: Product): Product {
        return productRepository.update(product)
    }

    override fun deleteById(id: Int) {
        return productRepository.deleteById(id)
    }

    override fun getAll(
        productFilter: ProductFilter,
        sortProductFields: SortProductFields?,
        pageSize: Int,
        pageNumber: Int
    ): List<Product> {

        val productsPages = productRepository
            .findAll()
            .filter { productFilter.matches(it) }
            .let {
                sortProductFields?.sorted(it) ?: it
            }
            .chunked(pageSize)

        if(productsPages.size < pageNumber)
            throw PageNumberTooLargeException()

        return productsPages[pageNumber - 1]
    }
}