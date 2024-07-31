package com.example.instagram

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.instagram.DATA.API.Repository
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.DATA.VMs.MainViewModel
import com.example.instagram.addPage.AddComp
import com.example.instagram.addPage.locDesComp
import com.example.instagram.discoverPage.DetailComp
import com.example.instagram.homePage.HomeComp
import com.example.instagram.lsPages.LoginComp
import com.example.instagram.lsPages.SignupComp
import com.example.instagram.ui.theme.InstagramTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalSharedTransitionApi::class)
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramTheme {

                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navStateBig = rememberNavController()

                    val context = LocalContext.current
                    val repo = Repository()
                    val viewModel = MainViewModel(repo)
                    val model = InstagramMainVM(mainViewModel = viewModel, owner = this, navController = navStateBig , context)


                    val startDestination = model.validateToken()
                    //val startDestination = "homePage"


                        NavHost(navController = navStateBig , startDestination = startDestination ){
                            composable("signupPage"){
                                SignupComp(navStateBig , model)
                            }
                            composable("loginPage"){
                                LoginComp(navStateBig , model)
                            }
                            composable("homePage"){
                                HomeComp(navStateBig , model)
                            }
                            composable("addPage"){
                                AddComp(navController = navStateBig , model = model)
                            }
                            composable("locDesPage"){
                                locDesComp(navController = navStateBig , model = model)
                            }



                        }


                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InstagramTheme {

    }
}