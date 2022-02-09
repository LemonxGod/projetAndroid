package com.example.kamevent.schemas

data class User(
    val firstname: String,
    val lastname: String,
    val mail: String,
    val age: Int,
    val phone: String,
    val password: String? = null
)