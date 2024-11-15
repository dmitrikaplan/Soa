package ru.kaplaan.productservice.domain.exception.not_found

import ru.kaplaan.productservice.domain.exception.ApiException

abstract class NotFoundException(
    errorCode: String,
    message: String?
): ApiException(errorCode, message)