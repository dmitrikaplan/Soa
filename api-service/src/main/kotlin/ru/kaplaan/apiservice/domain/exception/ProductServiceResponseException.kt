package ru.kaplaan.apiservice.domain.exception

import org.springframework.http.client.ClientHttpResponse

class ProductServiceResponseException(
    response: ClientHttpResponse
) : ApiException(
    errorCode = "bad.response.from.product.service",
    statusCode = response.statusCode.value(),
    message = String(response.body.readAllBytes())
)