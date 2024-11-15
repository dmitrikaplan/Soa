package ru.kaplaan.productservice.web.controller

import jakarta.validation.Valid
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.kaplaan.productservice.domain.filter.ProductFilter
import ru.kaplaan.productservice.service.ProductService
import ru.kaplaan.productservice.web.dto.ProductDto
import ru.kaplaan.productservice.web.mapper.toDto
import ru.kaplaan.productservice.web.mapper.toEntity
import ru.kaplaan.productservice.web.validation.OnCreate
import ru.kaplaan.productservice.web.validation.OnUpdate

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    fun save(
      @RequestBody @Validated(OnCreate::class)
      productDto: ProductDto
    ): ProductDto {
        return productService.save(productDto.toEntity()).toDto()
    }

    @GetMapping("/{id}")
    fun getProductByd(
      @Valid @Min(1) @PathVariable("id") 
      id: Int): ProductDto {
        return productService.getById(id).toDto()
    }

    @GetMapping("/{pageNumber}")
    fun getAllProducts(
        @PathVariable @Valid @Min(1) 
        pageNumber: Int,

        // XXX(sonya): what? and why was it commented?
        //@RequestBody @Valid filters: List<ProductFilter>
    ): List<ProductDto> {
        return productService.getAll(pageNumber).toDto()
    }

    @PutMapping
    fun updateProduct(
      @RequestBody @Validated(OnUpdate::class) 
      productDto: ProductDto): ProductDto {
        return productService.update(productDto.toEntity()).toDto()
    }

    @DeleteMapping("/{id}")
    fun deleteProductById(
      @Valid @Min(1) @PathVariable("id") 
      id: Int) {
        productService.deleteById(id)
    }


}
