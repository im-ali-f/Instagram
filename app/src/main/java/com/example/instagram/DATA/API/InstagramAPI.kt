package com.example.instagram.DATA.API

import com.example.instagram.DATA.models.loginModel.loginBodyModel
import com.example.instagram.DATA.models.loginModel.loginResponseModel
import com.example.instagram.DATA.models.signupModel.signupBodyModel
import com.example.instagram.DATA.models.signupModel.signupResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface InstagramAPI {
    @POST("users/login/")
    suspend fun Login(
        @Body loginBodyModel: loginBodyModel
    ): Response<loginResponseModel>

    @POST("users/register/")
    suspend fun Signup(
        @Body userInfoResponseListItem: signupBodyModel
    ):Response<signupResponseModel>

    /*
    @GET("user")

    suspend fun GetUserList(
    ):Response<UserInfoResponseList>


    @POST("user")
    suspend fun CreateUser(
        @Body userInfoResponseListItem: UserInfoResponseListItem
    ):Response<UserInfoResponseListItem>





    @GET("v1/use")
    suspend fun getUserInfo(
        @Header("Authorization") tokenUser:String
    ):Response<UserModel>

    @PUT("v1/users/person")
    suspend fun putUserInfo(
        @Header("Authorization") tokenUser:String,
        @Body updateUserModel: UpdateUserModel
    ):Response<UpdateUserResponseModel>


     */


}