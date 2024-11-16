package ru.kaplaan.apiservice.domain.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import ru.kaplaan.apiservice.domain.exception.ProductServiceResponseException
import ru.kaplaan.apiservice.domain.properties.ProductServiceProperties

@Configuration
class ApiServiceConfig {

    @Bean
    fun restClient(productServiceProperties: ProductServiceProperties): RestClient {
        return RestClient.builder()
            .baseUrl(productServiceProperties.baseUrl)
            .defaultStatusHandler({ it.isError }) { _, response ->
                throw ProductServiceResponseException(response)
            }
            .build()
    }
}