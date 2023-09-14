package com.kopring.repository

import com.kopring.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository :JpaRepository<Article,Long> {
    
}