package com.example.mangacomiclist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class LogInActivity : AppCompatActivity() {

    private var log_mail: EditText? = null
    private var log_pass: EditText? = null
    private var reg_name: EditText? = null
    private var reg_mail: EditText? = null
    private var reg_pass: EditText? = null
    private var reg_pass_re: EditText? = null

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        initialize()
    }

    private fun initialize() {

        log_mail = findViewById<View>(R.id.editText_login_mail) as EditText
        log_pass = findViewById<View>(R.id.editText_login_password) as EditText
        reg_name = findViewById<View>(R.id.editText_register_name) as EditText
        reg_mail = findViewById<View>(R.id.editText_register_email) as EditText
        reg_pass = findViewById<View>(R.id.editText_register_pass) as EditText
        reg_pass_re = findViewById<View>(R.id.editText_register_pass_re) as EditText

        auth = FirebaseAuth.getInstance()
    }

    fun logIn(view: View) {
        val email = log_mail?.text.toString()
        val password = log_pass?.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all the required fields", Toast.LENGTH_SHORT).show()
            return
        }

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "You are now logged!", Toast.LENGTH_SHORT).show()
                    val homepage_intent = Intent(this, MainActivity::class.java)
                    startActivity(homepage_intent)
                } else {
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun register(view: View) {
        val name = reg_name?.text.toString()
        val email = reg_mail?.text.toString()
        val password = reg_pass?.text.toString()
        val password_re = reg_pass_re?.text.toString()

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || password_re.isEmpty()) {
            Toast.makeText(this, "Please fill all the required fields", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != password_re) {
            Toast.makeText(this, "Password fields aren't matching", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "You are now registered!", Toast.LENGTH_SHORT).show()
                    var user = auth.currentUser
                    val profil_update = UserProfileChangeRequest.Builder().setDisplayName(name).build()
                    user?.updateProfile(profil_update)
                    val homepage_intent = Intent(this, MainActivity::class.java)
                    startActivity(homepage_intent)
                } else {
                    Toast.makeText(this, "Authentification failed: " +  task.exception, Toast.LENGTH_SHORT).show()
                }
            }
    }
}
