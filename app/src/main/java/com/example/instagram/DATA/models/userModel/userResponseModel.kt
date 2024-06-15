package com.example.instagram.DATA.models.userModel

data class userResponseModel(
    val bio: String,
    var followed_by_req_user: Boolean,
    val fullname: String,
    val id: Int,
    val number_of_followers: Int,
    val number_of_following: Int,
    val number_of_posts: Int,
    val profile_pic: String,
    val user_posts: List<UserPost>,
    val username: String
)