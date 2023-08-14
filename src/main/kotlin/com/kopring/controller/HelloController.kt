
package com.kopring.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("hello")
class HelloController {


    @GetMapping
    fun helloWorld(): String {
        return "Hello World"
    }


    @GetMapping("/responseentity")
    fun helloResponseEntity(): ResponseEntity<Any> {
        return ResponseEntity
                .ok()
                .body("Hello ResponseEntity")
    }

}