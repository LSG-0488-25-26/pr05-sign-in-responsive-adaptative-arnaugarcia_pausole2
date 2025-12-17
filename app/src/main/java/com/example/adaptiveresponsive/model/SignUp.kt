package com.example.adaptiveresponsive.model

data class SignUp(
    var name: String,
    var email: String,
    var phone: String,
    var username: String,
    var password: String,
    var confirmPassword: String,
    var acceptedTerms: Boolean
)
