package com.example.instagram.DATA.VMs

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class InstagramMainVM:ViewModel() {
    val selectedBottomBar = mutableStateOf(0)

    val StoryListMap = listOf(

        mapOf(
            "name" to "ali",
            "seen" to false,
            "isLive" to true,
            "imageUrl" to Color.Red
        ),
        mapOf(
            "name" to "moniba",
            "seen" to false,
            "isLive" to false,
            "imageUrl" to Color.Cyan
        ),
        mapOf(
            "name" to "ehsan",
            "seen" to false,
            "isLive" to false,
            "imageUrl" to Color.Magenta
        ),
        mapOf(
            "name" to "kiana",
            "seen" to false,
            "isLive" to false,
            "imageUrl" to Color.Yellow
        ),
        mapOf(
            "name" to "sajad",
            "seen" to false,
            "isLive" to false,
            "imageUrl" to Color.Green
        ),
        mapOf(
            "name" to "arman",
            "seen" to false,
            "isLive" to false,
            "imageUrl" to Color.Blue
        ),

        mapOf(
            "name" to "randomPerson",
            "seen" to false,
            "isLive" to true,
            "imageUrl" to Color.Gray
        ),

        mapOf(
            "name" to "lotof_worlds_for_this_name",
            "seen" to false,
            "isLive" to false,
            "imageUrl" to Color.Gray
        ),
    )
    val PostsMapList = listOf(

        mapOf(
            "name" to "im_ali_f",
            "official" to false,
            "place" to "New York, America",
            "imageUrl" to Color.Red,
            "pageCount" to 3,
            "contentList" to listOf(Color.Yellow, Color.Gray , Color.Blue),
            "like" to false,
            "save"  to false,
            "text"  to "The game in Japan was amazing and I want to share some photos",
            "likeCount"  to 444221,
            "followerLiked" to true,
            "followerLikedName" to "someone",
        ),

        mapOf(
            "name" to "ehsan",
            "official" to true,
            "place" to "Tehran, Iran",
            "imageUrl" to Color.Blue,
            "pageCount" to 1,
            "contentList" to listOf(Color.Yellow),
            "like" to false,
            "save"  to false,
            "text"  to "The game in Japan was amazing and I want to share some photos",
            "likeCount"  to 532945,
            "followerLiked" to false,
            "followerLikedName" to "",

            ),

        mapOf(
            "name" to "moniba",
            "official" to true,
            "place" to "Tokyo, Japan",
            "imageUrl" to Color.Cyan,
            "pageCount" to 5,
            "contentList" to listOf(Color.Yellow, Color.Gray , Color.Blue , Color.Green , Color.LightGray),
            "like" to false,
            "save"  to false,
            "text"  to "The game in Japan was amazing and I want to share some photos",
            "likeCount"  to 778234,
            "followerLiked" to true,
            "followerLikedName" to "someone_else",

            ),



    )

}