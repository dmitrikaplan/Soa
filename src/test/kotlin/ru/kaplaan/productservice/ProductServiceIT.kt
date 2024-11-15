package ru.kaplaan.productservice

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import ru.kaplaan.productservice.web.dto.CoordinatesDto
import ru.kaplaan.productservice.web.dto.ProductDto
import ru.kaplaan.productservice.web.dto.UnitOfMeasure

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = [
        TestConfig::class
    ],
)
class ProductServiceIT {

    @Autowired
    lateinit var mvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `save valid product`() {
        val product = ProductDto(
            name = "productName",
            coordinates = CoordinatesDto(x = 10, y = 20),
            price = 100,
            manufactureCost = 100.0f,
            unitOfMeasure = UnitOfMeasure.KILOGRAMS,
            owner = null
        )
        val productFromServer = saveProduct(product)
        assertEquals(product, productFromServer)
    }

    fun saveProduct(productDto: ProductDto): ProductDto {
       return mvc.post("/products") {
            content = objectMapper.writeValueAsString(productDto)
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status {
                isOk()
            }
        }.andReturn()
            .response
            .contentAsString
            .let {
                objectMapper.readValue(it, ProductDto::class.java)
            }
    }


    fun getAllProducts(): List<ProductDto>? {
        return mvc.get("products/1")
            .andExpect {
                status {
                    isOk()
                }
            }.andReturn()
            .response
            .contentAsString
            .let {
                toParametrizedList(it)
            }
    }


    fun toParametrizedList(json: String): List<ProductDto>? {
        return objectMapper.readValue(
            json,
            object: TypeReference<List<ProductDto>>() {}
            )
    }
}