package com.example.instagram.DATA.models.userModel

data class UserPost(
    val id: String,
    val location: String,
    val number_of_comments: Int,
    val number_of_likes: Int,
    val photo: String,
    val posted_on: String,
    val text: String
)