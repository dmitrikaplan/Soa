package ru.kaplaan.apiservice.domain.exception

import org.springframework.http.HttpStatus


class EmptyBodyException: ApiException(
    errorCode = "empty.body",
    statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value(),
    message = null
)