package com.kopring.entity
import jakarta.persistence.*


@Entity
data class Article (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?=null,
        val title: String,
        val body: String
)
