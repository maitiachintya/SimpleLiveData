package com.example.simplelivedataexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplelivedataexample.model.User

class MainViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user : LiveData<User> = _user

    fun updateUser(name : String, age : Int){
        _user.value = User(name, age)
    }
}