package com.example.kamevent.schemas

import java.util.*

data class Comment (
    val userId: String,
    val date: Date,
    val text: String,
    val likes: Likes,
    val answers: List<Comment>
)