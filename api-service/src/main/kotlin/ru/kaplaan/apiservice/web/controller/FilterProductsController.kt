package ru.kaplaan.apiservice.web.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.kaplaan.apiservice.service.ProductService
import ru.kaplaan.apiservice.web.dto.ProductDto
import ru.kaplaan.apiservice.web.dto.UnitOfMeasure

@RestController
@RequestMapping("/ebay")
class FilterProductsController(
    private val productService: ProductService
) {

    @GetMapping("/filter/price/{price-from}/{price-to}")
    @Operation(
        responses = [
            ApiResponse(description = "Validation error", responseCode = "400")
        ]
    )
    fun filterProductsByPrice(
        @PathVariable("price-from") @Valid @Min(0) priceFrom: Long,
        @PathVariable("price-to") @Valid @Min(0) priceTo: Long
    ): List<ProductDto>{
        return productService.findAllByPriceFilter(priceFrom, priceTo)
    }


    @Operation(
        responses = [ApiResponse(description = "Validation error", responseCode = "400")
        ]
    )
    @GetMapping("/filter/unit-of-measure/{unit-of-measure}")
    fun getAllProductsByUnitOfMeasure(
        @PathVariable("unit-of-measure") unitOfMeasure: UnitOfMeasure,
    ): List<ProductDto> {
        return productService.findAllByUnitOfMeasure(unitOfMeasure)
    }
}