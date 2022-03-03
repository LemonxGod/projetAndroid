package com.example.kamevent.database

import android.util.Log
import androidx.room.Database
import com.example.kamevent.MainActivity
import com.example.kamevent.schemas.User
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.*
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Document
import java.util.*
import kotlin.math.log

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

        fun get(userId : String) : User?{
            var res : User? = null
            val docRef = Firebase.firestore.collection(dbName).document(userId)
            docRef.get().addOnSuccessListener { documentSnapshot  ->
                    res = documentSnapshot.toObject<User>()
                Log.d(TAG, "Get : ${res.toString()}")
            }
            return res
        }
    }

}