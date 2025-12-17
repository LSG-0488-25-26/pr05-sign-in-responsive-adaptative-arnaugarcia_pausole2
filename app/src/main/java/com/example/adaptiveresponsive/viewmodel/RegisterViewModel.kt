package com.example.adaptiveresponsive.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adaptiveresponsive.model.SignUp

class RegisterViewModel : ViewModel() {
    private val _signUp = MutableLiveData(
        SignUp("", "", "",
            "","", "",
            "",false))
    val signUp: LiveData<SignUp> = _signUp

    fun chanegName(name: String)
    {
        _signUp.value!!.name = name;
    }
}