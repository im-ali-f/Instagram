package com.example.instagram.DATA.models.feedModel

data class Result(
    val author: Author,
    val id: String,
    val liked_by_req_user: Boolean,
    val location: String,
    val number_of_comments: Int,
    val number_of_likes: Int,
    val photo: String,
    val post_comments: List<PostComment>,
    val posted_on: String,
    val text: String
)