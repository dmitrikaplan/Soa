package ru.kaplaan.productservice.web.mapper

import ru.kaplaan.productservice.web.dto.CoordinatesDto
import ru.kaplaan.productservice.domain.entity.Coordinates

fun CoordinatesDto.toEntity(): Coordinates =
    Coordinates(x, y)

fun Coordinates.toDto(): CoordinatesDto =
    CoordinatesDto(
        x = this.x,
        y = this.y
    )