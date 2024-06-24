package com.example.instagram.DATA.API


import com.example.instagram.DATA.models.addPostModel.addPostBodyModel
import com.example.instagram.DATA.models.addPostModel.addPostResponseModel
import com.example.instagram.DATA.models.feedModel.feedResponseModel
import com.example.instagram.DATA.models.followModel.followResponseModel
import com.example.instagram.DATA.models.loginModel.loginBodyModel
import com.example.instagram.DATA.models.loginModel.loginResponseModel
import com.example.instagram.DATA.models.signupModel.signupBodyModel
import com.example.instagram.DATA.models.signupModel.signupResponseModel
import com.example.instagram.DATA.models.userModel.userResponseModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response

class Repository {

    suspend fun Login(body:loginBodyModel): Response<loginResponseModel> {

        return RetrofitInstance.api.Login(body)
    }
    suspend fun Signup(body:signupBodyModel): Response<signupResponseModel> {

        return RetrofitInstance.api.Signup(body)
    }

    suspend fun GetUserInfo(tokenUser :String , username:String): Response<userResponseModel> {

        return RetrofitInstance.api.GetUserInfo(tokenUser = tokenUser, username = username)
    }

    suspend fun FollowUser(tokenUser :String , username:String): Response<followResponseModel> {

        return RetrofitInstance.api.FollowUser(tokenUser = tokenUser, username = username)
    }


    suspend fun CreatePost(tokenUser :String , location:RequestBody , text : RequestBody ,photo :MultipartBody.Part ): Response<addPostResponseModel> {

        return RetrofitInstance.api.CreatePost(tokenUser = tokenUser, location =location, text = text, photo = photo )
    }

    suspend fun GetFeed(tokenUser :String , limit:String , offset:String): Response<feedResponseModel> {

        return RetrofitInstance.api.GetFeed(tokenUser = tokenUser, limit = limit, offset = offset)
    }



/*
    suspend fun CreateUser(body:UserInfoResponseListItem): Response<UserInfoResponseListItem> {

        return RetrofitInstance.api.CreateUser(body)
    }

     */
}