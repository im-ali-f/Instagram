@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.example.instagram.homePage

import android.annotation.SuppressLint
import android.provider.ContactsContract.Profile
import android.util.Log
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.instagram.homePage.BottmBarComp
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.discoverPage.DetailComp
import com.example.instagram.discoverPage.DiscoverComp
import com.example.instagram.homePage.TopBarComp
import com.example.instagram.profilePage.ProfileComp
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeComp(navController: NavController,model: InstagramMainVM) {

    val innerNavState= rememberNavController()

    val showBottomBar = remember {
        mutableStateOf(true)
    }

    val showTopBar = remember {
        mutableStateOf(true)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if(showTopBar.value){
                TopBarComp()
            }

        },
        bottomBar = {
            if(showBottomBar.value) {
                BottmBarComp(
                    model = model,
                    navController = navController,
                    innerNavController = innerNavState
                )
            }
            }

    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            SharedTransitionLayout {
                NavHost(navController = innerNavState, startDestination = "homePart") {
                    composable("homePart") {
                        model.selectedBottomBar.value = 1
                        showTopBar.value = true
                        showBottomBar.value = true
                        PostsComp(model)
                    }
                    composable("discoverPart") {
                        model.selectedBottomBar.value = 2
                        DiscoverComp(model = model, navControllerInner = innerNavState, navController = navController, animatedVisibilityScope = this)
                        showTopBar.value = false
                        showBottomBar.value = true
                    }
                    composable("detail/{index}", arguments = listOf(
                        navArgument("index") {
                            type = NavType.IntType
                        }
                    )) {
                        var index = it.arguments?.getInt("index")
                        DetailComp(
                            model = model,
                            navController = navController,
                            index = index as Int,
                            animatedVisibilityScope = this
                        )
                    }
                    composable("profilePart") {
                        model.selectedBottomBar.value = 5
                        ProfileComp(model = model)
                        showTopBar.value = false
                        showBottomBar.value = true
                    }

                }
            }

        }

    }

}