package com.example.kamevent.schemas

data class User(
    var firstname: String? = null,
    var lastname: String? = null,
    var mail: String? = null,
    var age: Int? = null,
    var phone: String? = null,
    var password: String? = null
)