package ru.kaplaan.productservice.web.mapper

import ru.kaplaan.productservice.domain.entity.Coordinates
import ru.kaplaan.productservice.web.dto.CoordinatesDto

fun CoordinatesDto.toEntity(): Coordinates =
    Coordinates(
        x = this.x,
        y = this.y
    )

fun Coordinates.toDto(): CoordinatesDto =
    CoordinatesDto(
        x = this.x,
        y = this.y
    )