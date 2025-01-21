package ru.kaplaan.productservice.service

import org.springframework.stereotype.Service
import ru.kaplaan.productservice.domain.entity.Product
import ru.kaplaan.productservice.domain.filter.ProductFilter
import ru.kaplaan.productservice.domain.sorting.SortProductFields
import ru.kaplaan.productservice.web.dto.UpdateProductDto

@Service
interface ProductService {

    fun save(product: Product): Product

    fun saveAll(products: List<Product>)

    fun getById(id: Long): Product

    fun update(updateProductDto: UpdateProductDto, productId: Long): Product

    fun deleteById(id: Long)

    fun getAll(
        productFilter: ProductFilter,
        sortProductFields: SortProductFields?,
        pageSize: Int?,
        pageNumber: Int?
    ): List<Product>

    fun getWithMinName(): Product

    fun getInfoAboutGroupingByManufactureCost(): Map<Float, Int>

    fun getAllByNameSubstring(nameSubstring: String): List<Product>

    fun getAllByPriceFilter(priceFrom: Long, priceTo: Long): List<Product>
}