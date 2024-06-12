package com.example.instagram.DATA.VMs

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.instagram.DATA.models.loginModel.loginBodyModel

class InstagramMainVM(val mainViewModel : MainViewModel , val owner: LifecycleOwner , val navController: NavController):ViewModel() {
    val selectedBottomBar = mutableStateOf(0)

    val StoryListMap = listOf(

        mapOf(
            "name" to "ali",
            "seen" to false,
            "isLive" to true,
            "imageUrl" to Color.Red
        ),
        mapOf(
            "name" to "moniba",
            "seen" to false,
            "isLive" to false,
            "imageUrl" to Color.Cyan
        ),
        mapOf(
            "name" to "ehsan",
            "seen" to false,
            "isLive" to false,
            "imageUrl" to Color.Magenta
        ),
        mapOf(
            "name" to "kiana",
            "seen" to false,
            "isLive" to false,
            "imageUrl" to Color.Yellow
        ),
        mapOf(
            "name" to "sajad",
            "seen" to false,
            "isLive" to false,
            "imageUrl" to Color.Green
        ),
        mapOf(
            "name" to "arman",
            "seen" to false,
            "isLive" to false,
            "imageUrl" to Color.Blue
        ),

        mapOf(
            "name" to "randomPerson",
            "seen" to false,
            "isLive" to true,
            "imageUrl" to Color.Gray
        ),

        mapOf(
            "name" to "lotof_worlds_for_this_name",
            "seen" to false,
            "isLive" to false,
            "imageUrl" to Color.Gray
        ),
    )
    val PostsMapList = listOf(

        mapOf(
            "name" to "im_ali_f",
            "official" to false,
            "place" to "New York, America",
            "imageUrl" to Color.Red,
            "contentList" to listOf(Color.Blue, Color.Gray , Color.Cyan),
            "like" to false,
            "save"  to false,
            "text"  to "The game in Japan was amazing and I want to share some photos",
            "likeCount"  to 444221,
            "followerLiked" to true,
            "followerLikedName" to "someone",
        ),

        mapOf(
            "name" to "ehsan",
            "official" to true,
            "place" to "Tehran, Iran",
            "imageUrl" to Color.Blue,
            "contentList" to listOf(Color.Yellow),
            "like" to false,
            "save"  to false,
            "text"  to "The game in Japan was amazing and I want to share some photos",
            "likeCount"  to 532945,
            "followerLiked" to false,
            "followerLikedName" to "",

            ),

        mapOf(
            "name" to "moniba",
            "official" to true,
            "place" to "Tokyo, Japan",
            "imageUrl" to Color.Cyan,
            "contentList" to listOf(Color.Magenta, Color.Green, Color.Gray , Color.Blue  , Color.DarkGray),
            "like" to false,
            "save"  to false,
            "text"  to "The game in Japan was amazing and I want to share some photos",
            "likeCount"  to 778234,
            "followerLiked" to true,
            "followerLikedName" to "someone_else",

            ),



    )

    //login
    val loginEnteredUsername = mutableStateOf("")
    val loginEnteredPassword = mutableStateOf("")
    val passwordVisible = mutableStateOf(false)



    var loggedInUserName = ""
    var loggedInUserToken = ""

    fun LoginFunctionallity() {

        val bodyToSend = loginBodyModel(username = loginEnteredUsername.value,password = loginEnteredPassword.value)
        mainViewModel.Login(bodyToSend)
        mainViewModel.viewModelLoginResponse.observe(owner, Observer { response ->
            if (response.isSuccessful) {

                Log.d("login --> success", response.body().toString())
                if(response.body()?.token  != ""){
                    loggedInUserToken = response.body()?.token.toString()
                    loggedInUserName = loginEnteredUsername.value
                    navController.navigate("homePage")
                }

                mainViewModel.viewModelLoginResponse = MutableLiveData()

            } else {
                Log.d("login --> error", response.errorBody()?.string() as String)
            }
        })
    }


}