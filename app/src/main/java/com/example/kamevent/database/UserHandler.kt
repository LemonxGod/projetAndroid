package com.example.kamevent.database

import android.util.Log
import androidx.room.Database
import com.example.kamevent.MainActivity
import com.example.kamevent.schemas.User
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.*
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Document

class UserHandler {
    companion object{
        var TAG = "UserHandler"
        var dbName = "users"

        fun create(email: String, firstname: String, lastname: String, age: Int, phone: String) : DocumentReference?{
            val user = User(firstname,lastname, email, age, phone)
            var res : DocumentReference? = null
            Firebase.firestore.collection(dbName).add(user)
                .addOnSuccessListener { docRef ->
                    Log.d(TAG, "User created with ID : ${docRef.id}")
                    res = docRef
                }.addOnFailureListener{ e ->
                    Log.d(TAG, "Error creating a new user.", e)
                }
            return res
        }
    }

}