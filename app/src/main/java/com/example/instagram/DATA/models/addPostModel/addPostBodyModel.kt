package com.example.instagram.DATA.models.addPostModel

import java.io.File

data class addPostBodyModel(
    val text: String,
    val location: String,
    val photo: File,
)
