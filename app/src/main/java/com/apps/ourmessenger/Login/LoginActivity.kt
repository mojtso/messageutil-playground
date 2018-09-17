package com.apps.ourmessenger.Login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.apps.ourmessenger.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        goBackTextView.setOnClickListener {
            finish()
        }
    }
}