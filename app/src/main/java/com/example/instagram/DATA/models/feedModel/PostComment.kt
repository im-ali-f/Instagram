package com.example.instagram.DATA.models.feedModel

data class PostComment(
    val author: Author,
    val id: Int,
    val posted_on: String,
    val text: String
)