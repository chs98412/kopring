package com.kopring.controller

import com.kopring.dto.ArticleRequestDTO
import com.kopring.dto.ArticleResponseDTO
import com.kopring.dto.HelloDTO
import com.kopring.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("article")
class ArticleController {

    @Autowired
    lateinit var articleService: ArticleService

    @PostMapping
    fun createArticle(@RequestBody request: ArticleRequestDTO): ResponseEntity<ArticleResponseDTO> {

        val response = articleService.articleCreate(request)


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response)
    }

    @GetMapping
    fun getAllArticles(): ResponseEntity<List<ArticleResponseDTO>> {

        val response= articleService.articleGetAll()

        return ResponseEntity
                .ok()
                .body(response)
    }

}