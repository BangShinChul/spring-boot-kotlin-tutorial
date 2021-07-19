package com.springboot.kotlin.tutorial.demo

import org.springframework.stereotype.Service

@Service
class HelloService {
    fun getHello(): String {
        return "hello service"
    }
}
