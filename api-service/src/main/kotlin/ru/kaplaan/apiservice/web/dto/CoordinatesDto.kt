package ru.kaplaan.apiservice.web.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotNull
import ru.kaplaan.apiservice.web.validation.OnCreate
import ru.kaplaan.apiservice.web.validation.OnUpdate
import ru.kaplaan.apiservice.web.validation.Greater

data class CoordinatesDto(
    @field:NotNull(message = "x не может быть null!", groups = [OnCreate::class, OnUpdate::class])
    @field:Greater(value = -642)
    val x: Int,
    @field:NotNull(message = "y не может быть null!", groups = [OnCreate::class, OnUpdate::class])
    @field:Max(643, message = "y не может быть больше 643!", groups = [OnCreate::class, OnUpdate::class])
    val y: Int
)