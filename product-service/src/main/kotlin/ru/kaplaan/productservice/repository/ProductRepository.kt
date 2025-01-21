package ru.kaplaan.productservice.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.kaplaan.productservice.domain.entity.Product

@Repository
interface ProductRepository : CrudRepository<Product, Long>