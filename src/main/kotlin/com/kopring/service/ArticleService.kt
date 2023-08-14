package com.kopring.service

import com.kopring.dto.ArticleRequestDTO
import com.kopring.dto.ArticleResponseDTO
import com.kopring.entity.Article
import com.kopring.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleService {


    @Autowired
    lateinit var articleRepository: ArticleRepository


    fun articleCreate(request: ArticleRequestDTO): ArticleResponseDTO {
        var article = request.toEntity()

        articleRepository.save(article)

        return ArticleResponseDTO(article.id,article.title,article.body)
    }


}