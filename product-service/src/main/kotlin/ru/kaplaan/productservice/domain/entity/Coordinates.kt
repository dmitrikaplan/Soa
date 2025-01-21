package ru.kaplaan.productservice.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import kotlin.properties.Delegates

@Table("coordinates")
class Coordinates(
    var x: Int,
    var y: Int
) {

    @Id
    var id: Long? = null

    @Column("product_id")
    var productId: Long? = null
}