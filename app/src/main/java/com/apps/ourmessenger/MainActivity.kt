package com.apps.ourmessenger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.apps.ourmessenger.Login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        register_button_register.setOnClickListener {
            val email = email_editText_register.text.toString()
            val password = password_editText_register.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Log.d("MainActivity", "Email is $email")
            Log.d("MainActivity", "Password is $password")

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if(!it.isSuccessful) {
                            Log.d("Main", "RegisterException ${it.exception}")
                            return@addOnCompleteListener
                        }

                        Log.d("Main", "Registered ${it.result.user.uid}")
                    }
                    .addOnFailureListener {
                        Log.d("Main", "Failed to create user ${it.message}")
                    }
        }


        alreadyHaveAccount_textView_register.setOnClickListener {
            Log.d("MainActivity", "Try to show Login")
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }


    }
}
