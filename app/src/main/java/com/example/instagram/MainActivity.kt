package com.example.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instagram.DATA.API.Repository
import com.example.instagram.DATA.VMs.InstagramMainVM
import com.example.instagram.DATA.VMs.MainViewModel
import com.example.instagram.homePage.HomeComp
import com.example.instagram.lsPages.LoginComp
import com.example.instagram.lsPages.SignupComp
import com.example.instagram.ui.theme.InstagramTheme

class MainActivity : ComponentActivity() {
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
                           // addcomp fun
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