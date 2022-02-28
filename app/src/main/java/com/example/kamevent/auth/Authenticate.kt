package com.example.kamevent.auth


import android.content.ContentValues.TAG
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kamevent.database.UserHandler
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firestore.v1.FirestoreGrpc


class Authenticate constructor() : AppCompatActivity() {
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }

    private val providers = arrayListOf(
        AuthUI.IdpConfig.EmailBuilder().build(),
        AuthUI.IdpConfig.GoogleBuilder().build()
    )

    private val signInIntent = AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setAvailableProviders(providers)
        .build()

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) : FirebaseUser?{
        if (result.resultCode == RESULT_OK) {
            val user = FirebaseAuth.getInstance().currentUser
            return user
        } else {
            // Sign in failed @TODO
            return null
        }
    }

    fun signInWithPassword(username: String, password: String): FirebaseUser? {
        Firebase.auth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful){
                    Log.d(TAG, "signInWithEmail:success")
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                }
            }
        return Firebase.auth.currentUser
    }

    fun signOut() {
        AuthUI.getInstance()
            .signOut(this)
            .addOnCompleteListener {
                // task @TODO
            }
    }

    fun getCurrentUser() : FirebaseUser? {
        return Firebase.auth.currentUser
    }

    fun createNewUser(email: String, password: String, firstname: String, lastname: String, age: Int, phone: String): FirebaseUser? {
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(){ task ->
                if (task.isSuccessful){
                    if( UserHandler.create(email, firstname, lastname, age, phone) != null){
                        Log.d(TAG, "createUserWithEmail:success")
                    }else {
                        Log.w(TAG, "createFirestoreUser:failure")
                    }
                }else{
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                }
            }
        return Firebase.auth.currentUser
    }
}