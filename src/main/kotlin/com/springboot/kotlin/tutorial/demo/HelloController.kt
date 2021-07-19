package com.springboot.kotlin.tutorial.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(val helloService: HelloService) {

    @GetMapping("/hello")
    fun helloKotlin(): String {
        return "hello world!"
    }

    @GetMapping("/hello-service")
    fun helloKotlinService(): String {
        return helloService.getHello()
    }

    @GetMapping("/hello-dto")
    fun helloKotlinDto(): HelloDto {
        return HelloDto("hello from the dto")
    }
}
