package com.kopring.dto

import com.kopring.entity.Article

data class ArticleRequestDTO(
        val title: String,
        val body: String,
){
    fun toEntity(): Article {
        return Article(
                title = title,
                body =  body
        )
    }
}
