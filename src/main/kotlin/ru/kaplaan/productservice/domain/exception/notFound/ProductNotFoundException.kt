package ru.kaplaan.productservice.domain.exception.notFound

class ProductNotFoundException: NotFoundException(
    "product.service.notFound",
)