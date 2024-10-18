package ru.kaplaan.productservice.domain.entity

import java.time.ZonedDateTime

class Person(
    val name: String,
    val birthday: ZonedDateTime?,
    val passportID: String
)