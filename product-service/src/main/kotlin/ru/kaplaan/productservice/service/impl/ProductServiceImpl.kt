package ru.kaplaan.productservice.service.impl

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.kaplaan.productservice.domain.entity.Product
import ru.kaplaan.productservice.domain.exception.PageNumberTooLargeException
import ru.kaplaan.productservice.domain.exception.not_found.ProductNotFoundException
import ru.kaplaan.productservice.domain.filter.ProductFilter
import ru.kaplaan.productservice.domain.sorting.SortProductFields
import ru.kaplaan.productservice.repository.ProductRepository
import ru.kaplaan.productservice.service.ProductService
import ru.kaplaan.productservice.web.dto.UpdateProductDto
import ru.kaplaan.productservice.web.mapper.toEntity

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
): ProductService {

    private val log = LoggerFactory.getLogger(ProductServiceImpl::class.java)

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

    override fun update(updateProductDto: UpdateProductDto, productId: Long): Product {
        val product = productRepository.findById(productId)
            ?: throw ProductNotFoundException()

        product.apply {
            this.name = updateProductDto.name ?: product.name
            this.coordinates = updateProductDto.coordinates?.toEntity() ?: product.coordinates
            this.price = updateProductDto.price ?: this.price
            this.manufactureCost = updateProductDto.manufactureCost ?: product.manufactureCost
            this.unitOfMeasure = updateProductDto.unitOfMeasure ?: product.unitOfMeasure
            this.owner = updateProductDto.owner?.toEntity() ?: product.owner
        }
        return productRepository.update(product)
    }

    override fun deleteById(id: Long) {
        return productRepository.deleteById(id)
    }

    override fun getAll(
        productFilter: ProductFilter,
        sortProductFields: SortProductFields?,
        pageSize: Int?,
        pageNumber: Int?
    ): List<Product> {

        val productsPages = productRepository
            .findAll()
            .filter { productFilter.matches(it) }
            .let {
                sortProductFields?.sorted(it) ?: it
            }
            .let { products ->
                pageSize?.let {
                    products.chunked(pageSize)
                } ?: listOf(products)
            }

        if (pageNumber != null) {
            log.info("products pages is ${productsPages.size}")
            log.info("page number is $pageNumber")
            if (productsPages.size < pageNumber)
                throw PageNumberTooLargeException()

            return productsPages[pageNumber - 1]
        }

        return productsPages.first()
    }

    override fun getWithMinName(): Product {
        return productRepository.findAll().minByOrNull { it.name }
            ?: throw ProductNotFoundException("product not found by min name")
    }

    override fun getInfoAboutGroupingByManufactureCost(): Map<Float, Int> {
       return productRepository.findAll().groupingBy { it.manufactureCost }
           .eachCount()
    }

    override fun getAllByNameSubstring(nameSubstring: String): List<Product> {
        return productRepository.findAll().filter { it.name.contains(nameSubstring) }
    }

    @Synchronized
    override fun getAllByPriceFilter(priceFrom: Long, priceTo: Long): List<Product> {
        return productRepository.findAll().filter {
                    it.price != null &&
                    it.price!! >= priceFrom &&
                    it.price!! <= priceTo
        }
    }
}