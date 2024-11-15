package ru.kaplaan.productservice.web.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import ru.kaplaan.productservice.domain.validation.Greater
import ru.kaplaan.productservice.web.validation.OnCreate
import ru.kaplaan.productservice.web.validation.OnUpdate

data class CoordinatesDto(
    @field:NotNull(message = "x не может быть null!", groups = [OnCreate::class, OnUpdate::class])
    @field:Greater(value = -642)
    val x: Int,
    @field:NotNull(message = "y не может быть null!", groups = [OnCreate::class, OnUpdate::class])
    @field:Max(643, message = "y не может быть больше 643!", groups = [OnCreate::class, OnUpdate::class])
    val y: Int
)