package com.example.likunlin.italk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.likunlin.italk.sign.sign
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private val tv_signup_click = View.OnClickListener{

        val intent = Intent(this,sign::class.java)
        startActivity(intent)

    }


    private val btn_login_click = View.OnClickListener{

        val email = tv_mail.text.toString()
        val password = tv_password.text.toString()
        var auth= FirebaseAuth.getInstance()

        if (email == ""|| password ==""){
            Toast.makeText(this,"請輸入正確的帳號密碼", Toast.LENGTH_SHORT).show()
        }else{
            auth!!.signInWithEmailAndPassword(email,password).addOnCompleteListener {Task->

                if (!Task.isSuccessful) {
                    Toast.makeText(this,"帳號密碼錯誤", Toast.LENGTH_SHORT).show()
                }else{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }



    }

    private fun init() {
        tv_signup.setOnClickListener(tv_signup_click)
        btn_login.setOnClickListener(btn_login_click)



    }
}
