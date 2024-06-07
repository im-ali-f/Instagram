package com.example.instagram.homePage

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.instagram.homePage.BottmBarComp
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.homePage.TopBarComp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeComp(navController: NavController,model: InstagramMainVM) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarComp()
        },
        bottomBar = {
            BottmBarComp(model = model)
        }

    ) {
        val scrollState = rememberScrollState()
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            PostsComp(model)
        }

    }
}