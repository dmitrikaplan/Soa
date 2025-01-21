package ru.kaplaan.productservice.domain.entity

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.time.ZonedDateTime

@Table("person")
class Person{

    @Id
    var id: Long? = null

    @field:NotNull
    @field:NotEmpty
    lateinit var name: String
    var birthday: LocalDate? = null

    @field:NotNull
    lateinit var passportID: String

    @Column("product_id")
    var productId: Long? = null
}