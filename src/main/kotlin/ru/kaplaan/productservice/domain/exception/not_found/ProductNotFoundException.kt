package ru.kaplaan.productservice.domain.exception.not_found

class ProductNotFoundException(message: String? = null): NotFoundException(
    "product.not.found",
    message
)