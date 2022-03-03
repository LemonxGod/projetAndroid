package com.example.kamevent.database

import android.util.Log
import com.example.kamevent.schemas.Likes
import com.example.kamevent.schemas.Post
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

class PostHandler {
    companion object{
        var TAG = "PostHandler"
        var dbName = "posts"

        fun create(
            userId: String,
            title: String? = null,
            date: Date,
            text: String,
            image: String? = null,
            video: String? = null,
            likes: Likes
        ) : DocumentReference? {
            val post = Post(userId, title, date, text, image, video, likes)
            var res: DocumentReference? = null
            Firebase.firestore.collection(dbName).add(post)
                .addOnSuccessListener { docRef ->
                    Log.d(TAG, "Post created with Id : ${docRef.id}")
                    res = docRef
                }.addOnFailureListener { e ->
                    Log.d(TAG, "Error creating a new post", e)
                }
            return res
        }
    }
}