package com.kopring.repository

import com.kopring.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository:JpaRepository<Comment,Long> {
}