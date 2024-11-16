package ru.kaplaan.productservice.web.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.kaplaan.productservice.domain.filter.ProductFilter
import ru.kaplaan.productservice.domain.sorting.SortProductFields
import ru.kaplaan.productservice.service.ProductService
import ru.kaplaan.productservice.web.dto.ProductDto
import ru.kaplaan.productservice.web.dto.UnitOfMeasure
import ru.kaplaan.productservice.web.mapper.toDto
import ru.kaplaan.productservice.web.mapper.toEntity
import ru.kaplaan.productservice.web.validation.OnCreate
import ru.kaplaan.productservice.web.validation.OnUpdate

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService,
) {

    @PostMapping
    @Operation(
        responses = [
            ApiResponse(description = "Validation error", responseCode = "400")
        ]
    )
    fun save(
        @RequestBody @Validated(OnCreate::class)
        productDto: ProductDto
    ): ProductDto {
        return productService.save(productDto.toEntity()).toDto()
    }

    @GetMapping("/{id}")
    @Operation(
        responses = [
            ApiResponse(description = "Product not found", responseCode = "404"),
            ApiResponse(description = "Validation error", responseCode = "400")
        ]
    )
    fun getProductByd(@Valid @Min(1) @PathVariable("id") id: Int): ProductDto {
        return productService.getById(id).toDto()
    }

    @GetMapping
    @Operation(
        responses = [
            ApiResponse(description = "Page number too large", responseCode = "400"),
            ApiResponse(description = "Validation error", responseCode = "400")
        ]
    )
    fun getAllProducts(
        @RequestParam @Valid @Min(1) pageNumber: Int?,
        @RequestParam @Valid @Min(1) pageSize: Int?,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false, value = "coordinates_x") coordinatesX: Int?,
        @RequestParam(required = false, value = "coordinates_y") coordinatesY: Int?,
        @RequestParam(required = false) price: Long?,
        @RequestParam(required = false, value = "manufacture_cost") manufactureCost: Float?,
        @RequestParam(required = false, value = "unit_of_measure") unitOfMeasure: UnitOfMeasure?,
        @RequestParam(required = false, value = "owner_name") ownerName: String?,
        @RequestParam(required = false, value = "sortBy") sortBy: SortProductFields?,
    ): List<ProductDto> {
        val productFilter = ProductFilter(
            name = name,
            coordinatesX = coordinatesX,
            coordinatesY = coordinatesY,
            price = price,
            manufactureCost = manufactureCost,
            unitOfMeasure = unitOfMeasure,
            ownerName = ownerName
        )
        return productService.getAll(productFilter, sortBy, pageSize, pageNumber).toDto()
    }

    @GetMapping("/min-name")
    @Operation(
        responses = [
            ApiResponse(description = "Product not found", responseCode = "404")
        ]
    )
    fun getProductWithMinName(): ProductDto {
        return productService.getWithMinName().toDto()
    }

    @GetMapping("/info-about-group-by-manufacture-cost")
    fun getInfoAboutGroupingByManufactureCost(): Map<Float, Int> {
        return productService.getInfoAboutGroupingByManufactureCost()
    }

    @GetMapping("/filter/price/{price-from}/{price-to}")
    @Operation(
        responses = [ApiResponse(description = "Validation error", responseCode = "400")
        ]
    )
    fun getAllProductsByPriceFilter(
        @PathVariable("price-from") @Valid @Min(1) priceFrom: Long,
        @PathVariable("price-to") @Valid @Min(1) priceTo: Long
    ): List<ProductDto> {
        return productService.getAllByPriceFilter(priceFrom, priceTo).toDto()
    }

    @GetMapping("/name")
    @Operation(
        responses = [
            ApiResponse(description = "Product not found", responseCode = "404"),
            ApiResponse(description = "Validation error", responseCode = "400")
        ]
    )
    fun getProductsByNameSubstring(
        @RequestParam(value = "substring") @Valid @NotEmpty nameSubstring: String,
    ): List<ProductDto> {
        return productService.getAllByNameSubstring(nameSubstring).toDto()
    }

    @PutMapping
    @Operation(
        responses = [
            ApiResponse(description = "Product not found", responseCode = "404"),
            ApiResponse(description = "Validation error", responseCode = "400")
        ]
    )
    fun updateProduct(@RequestBody @Validated(OnUpdate::class) productDto: ProductDto): ProductDto {
        return productService.update(productDto.toEntity()).toDto()
    }

    @DeleteMapping("/{id}")
    @Operation(
        responses = [
            ApiResponse(description = "Product not found", responseCode = "404"),
            ApiResponse(description = "Validation error", responseCode = "400")
        ]
    )
    fun deleteProductById(@Valid @Min(1) @PathVariable("id") id: Int) {
        productService.deleteById(id)
    }


}