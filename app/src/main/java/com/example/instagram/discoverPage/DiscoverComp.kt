package com.example.instagram.discoverPage

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.instagram.DATA.VMs.InstagramMainVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DiscoverComp(model: InstagramMainVM, navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { DiscoverSearchComp(model = model) }
    ) {
        Column (Modifier.fillMaxSize().padding(it).background(Color.Green)){

        }
    }
}