package ru.kaplaan.productservice.domain.filter

import ru.kaplaan.productservice.domain.entity.Product
import ru.kaplaan.productservice.web.dto.UnitOfMeasure

interface Filter {
    fun matches(product: Product): Boolean
}

class ProductFilter(
    name: String?,
    coordinatesX: Int?,
    coordinatesY: Int?,
    price: Long?,
    manufactureCost: Float?,
    unitOfMeasure: UnitOfMeasure?,
    ownerName: String?
) : Filter {

    private val productNameFilter = ProductNameFilter(name)
    private val coordinatesFilter = CoordinatesFilter(coordinatesX, coordinatesY)
    private val priceFilter = PriceFilter(price)
    private val manufactureCostFilter = ManufactureCostFilter(manufactureCost)
    private val unitOfMeasureFilter = UnitOfMeasureFilter(unitOfMeasure)
    private val ownerNameFilter = OwnerNameFilter(ownerName)

    override fun matches(product: Product): Boolean {
        return productNameFilter.matches(product) &&
                coordinatesFilter.matches(product) &&
                priceFilter.matches(product) &&
                manufactureCostFilter.matches(product) &&
                unitOfMeasureFilter.matches(product) &&
                ownerNameFilter.matches(product)
    }

}

class OwnerNameFilter(private val ownerName: String?) : Filter {
    override fun matches(product: Product): Boolean {
        return ownerName == null || ownerName == product.owner?.name
    }
}

class UnitOfMeasureFilter(private val unitOfMeasure: UnitOfMeasure?) : Filter {
    override fun matches(product: Product): Boolean {
        return unitOfMeasure == null || unitOfMeasure == product.unitOfMeasure
    }

}

class ManufactureCostFilter(private val manufactureCost: Float?) : Filter {
    override fun matches(product: Product): Boolean {
        return manufactureCost == null || manufactureCost == product.manufactureCost
    }

}

class ProductNameFilter(private val productName: String?) : Filter {
    override fun matches(product: Product): Boolean {
        return productName == null || productName == product.name
    }
}

class PriceFilter(private val productPrice: Long?) : Filter {
    override fun matches(product: Product): Boolean {
        return productPrice == null || productPrice == product.price
    }
}

class CoordinatesFilter(private val x: Int?, private val y: Int?) : Filter {
    override fun matches(product: Product): Boolean {
        val xMatches = x == null || x == product.coordinates.x
        val yMatches = y == null || y == product.coordinates.y

        return xMatches && yMatches
    }
}