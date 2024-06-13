package com.example.instagram.DATA.VMs

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagram.DATA.API.Repository
import com.example.instagram.DATA.models.loginModel.loginBodyModel
import com.example.instagram.DATA.models.loginModel.loginResponseModel
import com.example.instagram.DATA.models.signupModel.signupBodyModel
import com.example.instagram.DATA.models.signupModel.signupResponseModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    var viewModelLoginResponse: MutableLiveData<Response<loginResponseModel>> = MutableLiveData()
    fun Login(body:loginBodyModel) {
        viewModelScope.launch { //kotlin coroutines
            try {
                val response: Response<loginResponseModel> = repository.Login(body)
                viewModelLoginResponse.value = response
            } catch (e: Exception) {
                Log.d("Login mainVM --> Error", "${e.message} ")
            }

        }
    }

    var viewModelSignupResponse: MutableLiveData<Response<signupResponseModel>> = MutableLiveData()
    fun Signup(body:signupBodyModel) {
        viewModelScope.launch { //kotlin coroutines
            try {
                val response: Response<signupResponseModel> = repository.Signup(body)
                viewModelSignupResponse.value = response
            } catch (e: Exception) {
                Log.d("Signup mainVM --> Error", "${e.message} ")
            }

        }
    }

/*



    var viewModelCreateUserResponse: MutableLiveData<Response<UserInfoResponseListItem>> = MutableLiveData()
    fun CreateUser(body:UserInfoResponseListItem) {
        viewModelScope.launch { //kotlin coroutines
            try {
                val response: Response<UserInfoResponseListItem> = repository.CreateUser(body)
                viewModelCreateUserResponse.value = response
            } catch (e: Exception) {
                Log.d("Create User -->", "${e.message} ")
            }

        }
    }

 */


}