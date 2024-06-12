package com.example.instagram.DATA.VMs

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagram.DATA.API.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

/*
    var viewModelGetUsersListResponse: MutableLiveData<Response<UserInfoResponseList>> = MutableLiveData()
    fun GetUsersList() {
        viewModelScope.launch { //kotlin coroutines
            try {
                val response: Response<UserInfoResponseList> = repository.GetUsersList()
                viewModelGetUsersListResponse.value = response
            } catch (e: Exception) {
                Log.d("GetUsers -->", "${e.message} ")
            }

        }
    }


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