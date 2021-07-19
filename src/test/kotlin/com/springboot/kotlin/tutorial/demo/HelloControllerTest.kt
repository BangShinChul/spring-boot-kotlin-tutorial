package com.springboot.kotlin.tutorial.demo

import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.DisplayName
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(
    classes = arrayOf(DemoApplication::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@DisplayName("HelloController 클래스")
class HelloControllerTest {
    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun `GET hello 으로 요청을 하면 "hello world!"를 응답한다`() {
        val result = testRestTemplate
            .getForEntity("/hello", String::class.java)

        Assert.assertNotNull(result)
        Assert.assertEquals(result?.statusCode, HttpStatus.OK)
        Assert.assertEquals(result?.body, "hello world!")
    }

    @Test
    fun `GET hello-service 으로 요청을 하면 "hello service"를 응답한다`() {
        val result = testRestTemplate
            .getForEntity("/hello-service", String::class.java)

        Assert.assertNotNull(result)
        Assert.assertEquals(result?.statusCode, HttpStatus.OK)
        Assert.assertEquals(result?.body, "hello service")
    }

    @Test
    fun `GET hello-dto 으로 요청을 하면 "hello from the dto"를 응답한다`() {
        val result = testRestTemplate
            .getForEntity("/hello-dto", HelloDto::class.java)

        Assert.assertNotNull(result)
        Assert.assertEquals(result?.statusCode, HttpStatus.OK)
        Assert.assertEquals(result?.body, HelloDto("hello from the dto"))
    }

}
