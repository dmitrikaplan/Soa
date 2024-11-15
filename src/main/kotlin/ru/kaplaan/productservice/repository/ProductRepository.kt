package ru.kaplaan.productservice.repository

import org.springframework.stereotype.Repository
import ru.kaplaan.productservice.domain.entity.Product
import ru.kaplaan.productservice.domain.exception.CannotSaveException
import ru.kaplaan.productservice.domain.exception.notFound.ProductNotFoundException
import java.util.concurrent.CopyOnWriteArrayList

@Repository
class ProductRepository {

    private val products: MutableList<Product> = CopyOnWriteArrayList()

    fun save(product: Product): Product {
        if(products.add(product))
            return product

        throw CannotSaveException()
    }

    fun saveAll(products: List<Product>){
        if(this.products.addAll(products))
            return

        throw CannotSaveException()
    }

    fun findById(id: Int): Product? =
        products.find { it.id == id }


    fun update(product: Product): Product {
        val index = products.indexOfFirst { it.id == product.id }

        if(index == -1)
            throw ProductNotFoundException()

        products[index] = product

        return product
    }


    fun deleteById(id: Int) {
        val index = products.indexOfFirst { it.id == id }

        if(index == -1)
            throw Exception() //TODO: кинуть конкретный exception, что элемент не найден

        products.removeAt(index)
    }

    fun findAll(): List<Product> =
        products


    fun clear() {
        products.clear()
    }
}