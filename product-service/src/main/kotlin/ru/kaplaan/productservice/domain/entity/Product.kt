package ru.kaplaan.productservice.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table
import ru.kaplaan.productservice.web.dto.UnitOfMeasure
import java.time.LocalDate

@Table("product")
class Product {

    @Id
    var id: Long? = null

    lateinit var name: String

    @field:MappedCollection(idColumn = "product_id")
    lateinit var coordinates: Coordinates

    var price: Long? = null

    @Column("manufacture_cost")
    var manufactureCost: Float? = null

    @Column("unit_of_measure")
    var unitOfMeasure: UnitOfMeasure? = null

    @MappedCollection(idColumn = "product_id")
    var owner: Person? = null

    @Column("creation_date")
    var creationDate: LocalDate = LocalDate.now()

}