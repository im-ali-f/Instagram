package com.example.instagram.DATA.API


import com.example.instagram.DATA.models.loginModel.loginBodyModel
import com.example.instagram.DATA.models.loginModel.loginResponseModel
import com.example.instagram.DATA.models.signupModel.signupBodyModel
import com.example.instagram.DATA.models.signupModel.signupResponseModel
import retrofit2.Response

class Repository {

    suspend fun Login(body:loginBodyModel): Response<loginResponseModel> {

        return RetrofitInstance.api.Login(body)
    }
    suspend fun Signup(body:signupBodyModel): Response<signupResponseModel> {

        return RetrofitInstance.api.Signup(body)
    }

/*
    suspend fun CreateUser(body:UserInfoResponseListItem): Response<UserInfoResponseListItem> {

        return RetrofitInstance.api.CreateUser(body)
    }

     */
}