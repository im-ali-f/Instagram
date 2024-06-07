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

}