package ru.kaplaan.apiservice.service

import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.util.UriComponentsBuilder
import ru.kaplaan.apiservice.domain.exception.EmptyBodyException
import ru.kaplaan.apiservice.web.dto.ProductDto
import ru.kaplaan.apiservice.web.dto.UnitOfMeasure

@Service
class ProductService(
    private val restClient: RestClient
) {

    fun findAllByPriceFilter(priceFrom: Long, priceTo: Long): List<ProductDto> {
        return restClient
            .get()
            .uri("/products/filter/${priceFrom}/${priceTo}")
            .retrieve()
            .body(object : ParameterizedTypeReference<List<ProductDto>>() {})
            .also {
                if (it == null)
                    throw EmptyBodyException()
            }!!
    }


    fun findAllByUnitOfMeasure(unitOfMeasure: UnitOfMeasure): List<ProductDto> {
        val uri = UriComponentsBuilder.fromUriString("/products")
            .queryParam("unit_of_measure", unitOfMeasure)
            .build().toUri()

        return restClient
            .get()
            .uri(uri)
            .retrieve()
            .body(object : ParameterizedTypeReference<List<ProductDto>>() {})
            .also {
                if (it == null)
                    throw EmptyBodyException()
            }!!
    }
}