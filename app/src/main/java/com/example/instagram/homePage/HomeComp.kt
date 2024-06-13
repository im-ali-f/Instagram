package com.example.instagram.homePage

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instagram.homePage.BottmBarComp
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.homePage.TopBarComp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeComp(navController: NavController,model: InstagramMainVM) {

    val innerNavState= rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarComp()
        },
        bottomBar = {
            BottmBarComp(model = model , navController =navController, innerNavController = innerNavState)
        }

    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavHost(navController =innerNavState , startDestination = "homePart"){
                composable("homePart"){
                    PostsComp(model)
                }

            }

        }

    }

}