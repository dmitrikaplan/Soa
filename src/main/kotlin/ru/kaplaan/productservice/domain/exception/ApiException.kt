package ru.kaplaan.productservice.domain.exception

abstract class ApiException(val errorCode: String): RuntimeException()