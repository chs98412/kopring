
package com.kopring.controller

import com.kopring.dto.HelloDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


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

    @PostMapping("/hellopost")
    fun helloPost(@RequestBody request: HelloDTO): ResponseEntity<Any> {
        println(request)
        println(request.id)
        println(request.name)

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(request)
    }

}