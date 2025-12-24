package com.example.adaptiveresponsive.viewmodel

import android.telephony.PhoneNumberUtils
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.adaptiveresponsive.model.SignUp
import com.example.adaptiveresponsive.nav.Routes
import java.util.Calendar

class RegisterViewModel : ViewModel() {
    private val _signUp = MutableLiveData(
        SignUp("", "", "",
            "","", "",
            "",false))
    val signUp: LiveData<SignUp> = _signUp

    private val _loginEmail = MutableLiveData<String>()
    val loginEmail: LiveData<String> = _loginEmail

    private val _loginPassword = MutableLiveData<String>()
    val loginPassword: LiveData<String> = _loginPassword

    fun onLoginEmailChange(name: String)
    {
        _loginEmail.value = name
    }

    fun onLoginPasswordChange(pass: String)
    {
        _loginPassword.value = pass
    }

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

    fun validateRegister(navController: NavController): String
    {
        if (!validateName())
            return "Nom invàlid"

        if (!validateEmail())
            return "Email invàlid"

        if (!validatePhone())
            return "Telèfon invàlid"

        if (!validateBirthday())
            return "Data invàlida! Has de ser major de 18"

        if (!validateUsername())
            return "Nom d'usuari invàlid"

        if (!validatePassword())
            return "Contrasenya invàlida"

        if (!validateConfirmPassword())
            return "Contrasenya de confirmació invàlida"

        if (!checkSamePassword())
            return "Les contrasenyes no coincideixen"

        if (!_signUp.value.acceptedTerms)
            return "Termes no acceptats"

        navController.navigate(Routes.LoginScreen.route)
        return "Usuari completat correctament!"

    }

    fun cleanString(str: String): String
    {
        val cleanString = str;
        return cleanString.trim();
    }

    //https://stackoverflow.com/questions/67314008/android-kotlin-check-is-user-older-than-18
    //D'aquí és d'on he tret la informació per fer la validació d'anys
    fun getYears(birthday: String): Int {
        val date = birthday.split("/")
        val year = date[2].toInt()
        val month = date[1].toInt()
        val day = date[0].toInt()
        val c1 = Calendar.getInstance()
        c1[year, month - 1, day, 0] = 0 // as MONTH in calender is 0 based.
        val c2 = Calendar.getInstance()
        var diff = c2[Calendar.YEAR] - c1[Calendar.YEAR]
        if (c1[Calendar.MONTH] > c2[Calendar.MONTH] ||
            c1[Calendar.MONTH] == c2[Calendar.MONTH] && c1[Calendar.DATE] > c2[Calendar.DATE]
        ) {
            diff--
        }
        return diff
    }

    fun validateName(): Boolean
    {
        val name = cleanString(_signUp.value.name)
        if (name.isEmpty())
            return false
        return name.contains(Regex("^[A-z]"))
    }

    fun validateEmail(): Boolean
    {
        val email = cleanString(_signUp.value.email)

        if (email.isEmpty())
            return false

        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun validateBirthday(): Boolean
    {
        val birthday = cleanString(_signUp.value.birthday)
        return getYears(birthday) >= 18
    }

    fun validatePhone(): Boolean
    {
        val phone = cleanString(_signUp.value.phone)
        return PhoneNumberUtils.isGlobalPhoneNumber(phone)
    }

    fun validateUsername(): Boolean
    {
        val username = cleanString(_signUp.value.username)
        return username.isNotEmpty()
    }

    fun validatePassword(): Boolean
    {
        val pass = cleanString(_signUp.value.password)
        return pass.isNotEmpty()
    }

    fun validateConfirmPassword(): Boolean
    {
        val pass = cleanString(_signUp.value.confirmPassword)
        return pass.isNotEmpty()
    }

    fun checkSamePassword(): Boolean
    {
        return cleanString(_signUp.value.confirmPassword) == cleanString(_signUp.value.password)
    }


    fun checkLogin(navController: NavController): String
    {


        if (_signUp.value.email != _loginEmail.value)
        {
            return "Email no es correcte"
        }

        if (_signUp.value.password != _loginPassword.value)
        {
            return "Contrasenya no es correcte"
        }

        navController.navigate(Routes.WelcomeScreen.route)
        return ""
    }

}