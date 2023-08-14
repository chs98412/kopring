package com.kopring.controller

import com.kopring.dto.ArticleRequestDTO
import com.kopring.dto.ArticleResponseDTO
import com.kopring.dto.CommentRequestDTO
import com.kopring.dto.CommentResponseDTO
import com.kopring.service.CommentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("comment")
class CommentController {

    @Autowired
    lateinit var commentService: CommentService

    @PostMapping
    fun createComment(@RequestBody request: CommentRequestDTO): ResponseEntity<CommentResponseDTO> {

        val response = commentService.commentCreate(request)


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response)
    }
    @GetMapping("/article")
    fun getCommentsByArticleId(@RequestParam id:Long): ResponseEntity<List<CommentResponseDTO>> {

        val response= commentService.commentsGetByArticleId(id)

        return ResponseEntity
                .ok()
                .body(response)
    }

}