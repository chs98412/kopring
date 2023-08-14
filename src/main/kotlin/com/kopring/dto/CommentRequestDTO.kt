package com.kopring.dto

import com.kopring.entity.Comment

data class CommentRequestDTO(
        val articleId: Long,
        val body: String,
){
    fun toEntity(): Comment {
        return Comment(
                body =  body
        )
    }
}