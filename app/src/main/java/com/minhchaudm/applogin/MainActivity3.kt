package com.minhchaudm.applogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        auth = FirebaseAuth.getInstance();
        sign_up.setOnClickListener {
           signUp()
        }
    }
  private  fun signUp(){
        if (tv_email.text.toString().isEmpty()){
            tv_email.error = "please input user"
            tv_email.requestFocus()
            return
        }
      if (!Patterns.EMAIL_ADDRESS.matcher(tv_email.text.toString()).matches()) {
          tv_email.error = "Please enter valid email"
          tv_email.requestFocus()
          return
      }

      if (tv_password.text.toString().isEmpty()){
            tv_password.error = "please input password"
           tv_password.requestFocus()
            return
        }
      auth.createUserWithEmailAndPassword(tv_email.text.toString(), tv_password.text.toString())
          .addOnCompleteListener(this) { task ->
              if (task.isSuccessful) {
                  startActivity(Intent(this,MainActivity::class.java))
                  finish()
              } else {
                  Toast.makeText(baseContext, "Sign Up failed. Try again after some time.",
                      Toast.LENGTH_SHORT).show()
              }
          }
    }

}