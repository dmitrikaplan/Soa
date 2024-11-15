package ru.kaplaan.productservice.domain.exception

abstract class ApiException(
    val errorCode: String,
    override val message: String? = null
): RuntimeException()