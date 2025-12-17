package com.example.adaptiveresponsive.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adaptiveresponsive.model.SignUp

class RegisterViewModel : ViewModel() {
    private val _signUp = MutableLiveData<SignUp>()
    val signUp: LiveData<SignUp> = _signUp
}