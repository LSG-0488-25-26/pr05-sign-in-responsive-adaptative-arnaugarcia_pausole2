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

    fun onNameChange(name: String)
    {
        _signUp.value = _signUp.value?.copy(name = name)
    }

    fun onEmailChange(email: String) {
        _signUp.value = _signUp.value?.copy(email = email)
    }

    fun onBirthdayChange(birthday: String) {
        _signUp.value = _signUp.value?.copy(birthday = birthday)
    }
    fun onPhoneChange(phone: String) {
        _signUp.value = _signUp.value?.copy(phone = phone)
    }

    fun onUsernameChange(username: String) {
        _signUp.value = _signUp.value?.copy(username = username)
    }

    fun onPasswordChange(password: String) {
        _signUp.value = _signUp.value?.copy(password = password)
    }

    fun onConfirmPasswordChange(confirm: String) {
        _signUp.value = _signUp.value?.copy(confirmPassword = confirm)
    }

    fun onTermsChange(accepted: Boolean) {
        _signUp.value = _signUp.value?.copy(acceptedTerms = accepted)
    }
}