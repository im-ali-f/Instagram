package com.example.instagram.homePage.DATA.VMs

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class InstagramMainVM:ViewModel() {
    val selectedBottomBar = mutableStateOf(0)
}