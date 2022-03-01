# projetAndroid
Développement d'un application de réseaux sociaux


# Authenticate

Access to Authenticate class(**Element statique**)
this is instantiated on the MainActivity and accessible on the MainActivity

```kotlin
    MainActivity.auth
```

Test if user is connected
```kotlin
    var currentUser = MainActivity.auth.getCurrentUser()
    // test if user is connected
    if( currentUser != null){
        // Utilisateur connecté
    } else {
        // Utilisateur non connecté
    }
```

SignIn
```kotlin
    var currentUser = signInWithPassword(username, password) // Username = mail
    // As above, signInWithPassword returns the current user and equal null if signIn failed
```

SignOut
```kotlin
    signOut()
```

Create a new User
```kotlin
    // Warning : age is an Int and should not be wrapped by quote characters ( example : 10 is right | "10" is wrong)
    //           phone is a String and should be wrapped by quote characters ( example : "0123456789" is right | 0123456789 is wrong)
   var currentUser = createNewUser(email, password, firstname, lastname, age, phone)
```

