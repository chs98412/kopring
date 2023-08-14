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

    fun commentsGetByArticleId(id: Long): List<CommentResponseDTO> {

        val article = articleRepository.findById(id).get()

        val comments = commentRepository.findAllByArticle(article)

        val response = arrayListOf<CommentResponseDTO>()
        for (comment in comments) {
            val dto=CommentResponseDTO(comment.id,comment.body)
            response.add(dto)
        }
        return response

    }
}