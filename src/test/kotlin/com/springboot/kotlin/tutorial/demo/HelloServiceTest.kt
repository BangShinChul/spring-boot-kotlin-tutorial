package com.springboot.kotlin.tutorial.demo

import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.springframework.context.annotation.Import

@Import(value = [HelloService::class])
@DisplayName("HelloService 클래스")
class HelloServiceTest() {

    private val helloService: HelloService = HelloService()

    @Test
    fun `getHello 메서드를 호출하면 "hello service" 문자열을 응답한다`() {
        val result = helloService.getHello()
        Assert.assertEquals("hello service", result)
    }
}
