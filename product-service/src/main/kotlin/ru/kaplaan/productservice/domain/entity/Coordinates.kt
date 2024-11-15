package ru.kaplaan.productservice.domain.entity

import jakarta.validation.constraints.Max
import ru.kaplaan.productservice.domain.validation.Greater

class Coordinates(
    @field:Greater(value = -642)
    val x: Int,
    @field:Max(value = 643)
    val y: Int
)