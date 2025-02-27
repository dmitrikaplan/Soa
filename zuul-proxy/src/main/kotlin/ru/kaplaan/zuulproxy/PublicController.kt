package ru.kaplaan.zuulproxy

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PublicController {

    @GetMapping("/healthCheck")
    fun healthCheck(): String {
       return "OK"
    }
}