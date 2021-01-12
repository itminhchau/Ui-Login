package com.minhchaudm.applogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


    }


    fun signUp(view: View) {
        val intent = Intent(this,MainActivity3::class.java)
        startActivity(intent)
    }

    fun login(view: View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}