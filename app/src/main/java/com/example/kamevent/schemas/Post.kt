package com.example.kamevent.schemas

import java.util.*

data class Post(
    val userId: String,
    val title: String? = null,
    val date: Date,
    val text: String,
    val image: String? = null,
    val video: String? = null,
    val likes: Likes
)