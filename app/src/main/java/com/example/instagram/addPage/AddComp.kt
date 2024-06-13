package com.example.instagram.addPage

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.homePage.TopBarComp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddComp(navController: NavController, model: InstagramMainVM) {
    Scaffold(Modifier.fillMaxSize(),

        topBar = {
                 TopBarAddComp(navController)
        },

        bottomBar = {}

    ) {


    }

}