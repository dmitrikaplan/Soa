package ru.kaplaan.productservice.domain.exception.notFound

import ru.kaplaan.productservice.domain.exception.ApiException

abstract class NotFoundException(errorCode: String): ApiException(errorCode)