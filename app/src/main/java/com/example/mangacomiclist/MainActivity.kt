package com.example.mangacomiclist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    var user: FirebaseUser? = null
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        auth = FirebaseAuth.getInstance()
        user = auth.currentUser
        findViewById<TextView>(R.id.textView_user).text = getString(R.string.logged_user, user?.displayName)
    }

    fun logIn(view: View) {
        val log_in_intent = Intent(this, LogInActivity::class.java)
        startActivity(log_in_intent)

    }

    fun goToList(view: View) {

    }

    fun addElement(view: View) {

    }
}
