package com.kopring.service

import com.kopring.dto.CommentRequestDTO
import com.kopring.dto.CommentResponseDTO
import com.kopring.repository.ArticleRepository
import com.kopring.repository.CommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommentService {


    @Autowired
    lateinit var commentRepository: CommentRepository

    @Autowired
    lateinit var articleRepository: ArticleRepository


    fun commentCreate(request: CommentRequestDTO): CommentResponseDTO {
        val article = articleRepository.findById(request.articleId).get()

        val comment=request.toEntity()
        comment.article=article

        commentRepository.save(comment)

        return CommentResponseDTO(comment.id, comment.body)

    }
}