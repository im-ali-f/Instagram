package com.example.instagram.DATA.VMs

import android.content.ContentUris
import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.instagram.DATA.API.RetrofitInstance
import com.example.instagram.DATA.models.addPostModel.addPostBodyModel
import com.example.instagram.DATA.models.loginModel.loginBodyModel
import com.example.instagram.DATA.models.signupModel.signupBodyModel
import com.example.instagram.DATA.models.userModel.userResponseModel
import com.example.instagram.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.io.InputStream
import java.net.URI

class InstagramMainVM(val mainViewModel : MainViewModel , val owner: LifecycleOwner , val navController: NavController , context: Context):ViewModel() {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun saveData(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getData(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

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
                    saveData("token", response.body()?.token.toString() )
                    navController.navigate("homePage")
                }

                mainViewModel.viewModelLoginResponse = MutableLiveData()

            } else {
                Log.d("login --> error", response.errorBody()?.string() as String)
            }
        })
    }


    //signup
    val signupEnteredUsername = mutableStateOf("")
    val signupEnteredPassword = mutableStateOf("")
    val signupEnteredEmail = mutableStateOf("")
    val signupEnteredFullName = mutableStateOf("")
    val signupPasswordVisible = mutableStateOf(false)

    fun SignupFunctionallity() {

        val bodyToSend = signupBodyModel(username = signupEnteredUsername.value , password = signupEnteredPassword.value, email = signupEnteredEmail.value, fullname = signupEnteredFullName.value)
        mainViewModel.Signup(bodyToSend)
        mainViewModel.viewModelSignupResponse.observe(owner, Observer { response ->
            if (response.isSuccessful) {

                Log.d("Signup --> success", response.body().toString())

                navController.navigate("loginPage")

                mainViewModel.viewModelSignupResponse = MutableLiveData()

            } else {
                Log.d("Signup --> error", response.errorBody()?.string() as String)
            }
        })
    }

   // log out

    fun LogoutFunctionallity(){
        saveData("token","")
        loginEnteredUsername.value = ""
        loginEnteredPassword.value = ""
        passwordVisible.value = false
        signupEnteredUsername.value = ""
        signupEnteredPassword.value = ""
        signupEnteredEmail.value = ""
        signupEnteredFullName.value = ""
        signupPasswordVisible.value = false
        navController.navigate("loginPage")
    }

    fun validateToken () :String{
        val token =getData("token","")
        if(token == ""){
            return "signupPage"
        }
        else{
            return "homePage"
        }
    }

    //Discover
    val discoverEnteredSearch = mutableStateOf("")
    val foundedUser = mutableStateOf(userResponseModel(username = "", fullname = "", id = 0, bio = "", followed_by_req_user = false, number_of_followers = 0, number_of_following = 0, user_posts = emptyList(), number_of_posts = 0, profile_pic = ""))

    fun GetUserInfoFunctionallity() {

        val tokenToSend = getData("token", "")
        mainViewModel.GetUserInfo("JWT $tokenToSend" , discoverEnteredSearch.value)
        mainViewModel.viewModelGetUserInfoResponse.observe(owner, Observer { response ->
            if (response.isSuccessful) {

                Log.d("GetUserInfo --> success", response.body().toString())

                foundedUser.value = response.body() as userResponseModel

                mainViewModel.viewModelGetUserInfoResponse = MutableLiveData()

            } else {
                Log.d("GetUserInfo --> error", response.errorBody()?.string() as String)
                foundedUser.value = userResponseModel(username = "", fullname = "", id = 0, bio = "", followed_by_req_user = false, number_of_followers = 0, number_of_following = 0, user_posts = emptyList(), number_of_posts = 0, profile_pic = "")

            }
        })
    }

    fun FollowUserFunctionallity(username : String) {

        val tokenToSend = getData("token", "")
        mainViewModel.FollowUser("JWT $tokenToSend" , username)
        mainViewModel.viewModelFollowUserResponse.observe(owner, Observer { response ->
            if (response.isSuccessful) {

                Log.d("FollowUser --> success", response.body().toString())
                val tempObj = foundedUser.value
                tempObj.followed_by_req_user =  !tempObj.followed_by_req_user
                foundedUser.value = userResponseModel(username = "", fullname = "", id = 0, bio = "", followed_by_req_user = false, number_of_followers = 0, number_of_following = 0, user_posts = emptyList(), number_of_posts = 0, profile_pic = "")
                foundedUser.value = tempObj

                mainViewModel.viewModelFollowUserResponse = MutableLiveData()

            } else {
                Log.d("FollowUser --> error", response.errorBody()?.string() as String)
            }
        })
    }

    val monkeyList = listOf(
        R.drawable.m1,
        R.drawable.m2,
        R.drawable.m14,
        R.drawable.m3,
        R.drawable.m16,
        R.drawable.m4,
        R.drawable.m5,
        R.drawable.m6,
        R.drawable.m7,
        R.drawable.m8,
        R.drawable.m9,
        R.drawable.m10,
        R.drawable.m11,
        R.drawable.m12,
        R.drawable.m13,
        R.drawable.m15,
        R.drawable.m16,
        R.drawable.m1,
        R.drawable.m2,
        R.drawable.m3,
        R.drawable.m4,
        R.drawable.m5,
        R.drawable.m6,
        R.drawable.m7,
        R.drawable.m8,
        R.drawable.m9,
        R.drawable.m10,
        R.drawable.m11,
        R.drawable.m12,
        R.drawable.m16,
        R.drawable.m13,
        R.drawable.m14,
        R.drawable.m15,
        R.drawable.m1,
        R.drawable.m2,
        R.drawable.m3,
        R.drawable.m4,
        R.drawable.m5,
        R.drawable.m14,
        R.drawable.m6,
        R.drawable.m7,
        R.drawable.m8,
        R.drawable.m9,
        R.drawable.m10,
        R.drawable.m11,
        R.drawable.m12,
        R.drawable.m13,
        R.drawable.m15,
        R.drawable.m16,

    )
    val focusedOnSearchBar = mutableStateOf(false)

    val SelectedBottomBarAdd = mutableStateOf(1)


    //addPage
    val selectedImage = mutableStateOf<Uri?>(null)


    fun fetchGalleryImages(context: Context): List<Uri> {
        val images = mutableListOf<Uri>()
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(MediaStore.Images.Media._ID)
        val cursor = context.contentResolver.query(uri, projection, null, null, null)
        cursor?.use {
            val idColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            while (it.moveToNext()) {
                val id = it.getLong(idColumn)
                val contentUri = ContentUris.withAppendedId(uri, id)
                images.add(contentUri)
            }
        }
        selectedImage.value = images.first()
        return images
    }

    //location description
    val enteredLocation = mutableStateOf("")
    val enteredDescription = mutableStateOf("")
    val showLoadingAddPost = mutableStateOf(false)




    fun AddPostFunctionallity(context: Context) {


        selectedImage.value?.let { uri ->
            val file = uriToFile(context, uri)
            file?.let {
                val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), it)
                val imagePart = MultipartBody.Part.createFormData("photo", it.name, requestFile)
                val descriptionPart = RequestBody.create("text/plain".toMediaTypeOrNull(), enteredDescription.value)
                val locationPart = RequestBody.create("text/plain".toMediaTypeOrNull(), enteredLocation.value)

                val tokenToSend = getData("token", "")

                mainViewModel.CreatePost(
                    tokenUser = "JWT $tokenToSend",
                    photo = imagePart,
                    text = descriptionPart,
                    location = locationPart
                )
                showLoadingAddPost.value = true
                mainViewModel.viewModelCreatePostResponse.observe(owner, Observer { response ->
                    if (response.isSuccessful) {

                        Log.d("AddPost --> success", response.body().toString())

                        mainViewModel.viewModelCreatePostResponse = MutableLiveData()
                        navController.navigate("homePage")
                        enteredDescription.value = ""
                        enteredLocation.value = ""
                        selectedImage.value = null
                        showLoadingAddPost.value = false

                    } else {
                        Log.d("AddPost --> error", response.errorBody()?.string() as String)
                        showLoadingAddPost.value = false
                    }
                })

            }
        }


    }

    fun uriToFile(context: Context, uri: Uri): File? {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        inputStream?.let {
            val fileExtension = context.contentResolver.getType(uri)?.substringAfterLast('/')
            val tempFile = File(context.cacheDir, "${uri.lastPathSegment ?: "tempImage"}.$fileExtension")
            tempFile.outputStream().use { outputStream ->
                inputStream.copyTo(outputStream)
            }
            return tempFile
        }
        return null
    }


}