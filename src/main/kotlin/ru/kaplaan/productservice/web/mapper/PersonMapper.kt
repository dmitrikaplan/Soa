package ru.kaplaan.productservice.web.mapper

import ru.kaplaan.productservice.domain.entity.Person
import ru.kaplaan.productservice.web.dto.PersonDto

fun PersonDto.toEntity() =
    Person(
        name = this.name,
        birthday = this.birthday,
        passportID = this.passportID
    )


fun Person.toDto() =
    PersonDto(
        name = this.name,
        birthday = this.birthday,
        passportID = this.passportID
    )