package com.example.instagram.DATA.models.feedModel

data class feedResponseModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)