package ru.kaplaan.apiservice.domain.exception

abstract class ApiException(
    val errorCode: String,
    val statusCode: Int,
    override val message: String? = null,
): RuntimeException()