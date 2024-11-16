package ru.kaplaan.apiservice.domain.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "product-service")
class ProductServiceProperties(
    val baseUrl: String
)