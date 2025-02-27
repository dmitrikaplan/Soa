package ru.kaplaan.apiservice.web.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PublicController {

    @GetMapping("/healthCheck")
    fun healthCheck(): String {
        return "OK"
    }
}