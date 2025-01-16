//package ru.kaplaan.productservice
//
//import org.springframework.boot.test.context.TestConfiguration
//import org.springframework.context.annotation.Bean
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers
//import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
//import org.springframework.test.web.servlet.setup.MockMvcBuilders
//import org.springframework.web.context.WebApplicationContext
//
//@TestConfiguration
//class TestConfig {
//
//    @Bean
//    fun mockMvc(webApplicationContext: WebApplicationContext): MockMvc {
//        return MockMvcBuilders
//            .webAppContextSetup(webApplicationContext)
//            .alwaysDo<DefaultMockMvcBuilder>(MockMvcResultHandlers.print())
//            .build()
//    }
//}