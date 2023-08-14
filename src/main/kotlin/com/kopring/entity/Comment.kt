package com.kopring.entity

import jakarta.persistence.*

@Entity
data class Comment(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?=null,
        @ManyToOne
        var article: Article?=null,
        val body: String
)