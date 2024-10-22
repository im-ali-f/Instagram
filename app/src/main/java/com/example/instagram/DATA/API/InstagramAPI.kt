package com.example.instagram.DATA.API

import com.example.instagram.DATA.models.addPostModel.addPostBodyModel
import com.example.instagram.DATA.models.addPostModel.addPostResponseModel
import com.example.instagram.DATA.models.feedModel.feedResponseModel
import com.example.instagram.DATA.models.followModel.followResponseModel
import com.example.instagram.DATA.models.likeModel.likeResponse
import com.example.instagram.DATA.models.loginModel.loginBodyModel
import com.example.instagram.DATA.models.loginModel.loginResponseModel
import com.example.instagram.DATA.models.profileModel.meResponse
import com.example.instagram.DATA.models.profileModel.profileInfoResponse
import com.example.instagram.DATA.models.signupModel.signupBodyModel
import com.example.instagram.DATA.models.signupModel.signupResponseModel
import com.example.instagram.DATA.models.userModel.userResponseModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query


interface InstagramAPI {
    @POST("users/login/")
    suspend fun Login(
        @Body loginBodyModel: loginBodyModel
    ): Response<loginResponseModel>

    @POST("users/register/")
    suspend fun Signup(
        @Body userInfoResponseListItem: signupBodyModel
    ):Response<signupResponseModel>

    @GET("users/{username}/")
    suspend fun GetUserInfo(
        @Path("username")username: String,
        @Header("Authorization") tokenUser:String
    ):Response<userResponseModel>

    @GET("users/{username}/follow/")
    suspend fun FollowUser(
        @Path("username")username: String,
        @Header("Authorization") tokenUser:String
    ):Response<followResponseModel>


    @Multipart
    @POST("posts/")
    suspend fun CreatePost(
        @Header("Authorization") tokenUser: String,
        @Part photo: MultipartBody.Part,
        @Part("text") text: RequestBody,
        @Part("location") location: RequestBody
    ): Response<addPostResponseModel>

    @GET("posts/feed/")
    suspend fun GetFeed(
        @Query("limit")limit: String,
        @Query("offset")offset: String,
        @Header("Authorization") tokenUser:String
    ):Response<feedResponseModel>

    @GET("posts/like/{postId}/")
    suspend fun Like(
        @Path("postId")postId: String,
        @Header("Authorization") tokenUser:String
    ):Response<likeResponse>

    @GET("users/me/")
    suspend fun Me(
        @Header("Authorization") tokenUser:String
    ):Response<meResponse>


    @GET("users/{username}/")
    suspend fun GetProfile(
        @Path("username")username: String,
        @Header("Authorization") tokenUser:String
    ):Response<profileInfoResponse>

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