package com.example.instagram.homePage

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.instagram.homePage.DATA.VMs.InstagramMainVM

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

    }
}