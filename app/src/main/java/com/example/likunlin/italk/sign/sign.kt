package com.example.likunlin.italk.sign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Toast
import com.example.likunlin.italk.R
import com.example.likunlin.italk.firebase.firebase
import com.example.likunlin.italk.login

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_sign.*


import com.google.firebase.auth.AuthResult
import com.google.firebase.database.FirebaseDatabase


class sign : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)


        init()
    }


    private val creat_user_auth = OnCompleteListener<AuthResult>{it ->


    }
    private val btn_reginster_click = View.OnClickListener{
        val account = tv_reginster_account.text.toString()
        val mail = tv_reginster_mail.text.toString()
        val password =  tv_reginster_password.text.toString()
        val repassword = tv_reginster_repassword.text.toString()
        if(account == "" || mail == "" || password == ""|| repassword ==""){
            Toast.makeText(this,"請確實填寫資料 資料不可空白",Toast.LENGTH_SHORT).show()
        }else{
            if(password == repassword){
                val auth = FirebaseAuth.getInstance()
                auth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener{task ->
                    if (task.isSuccessful){
                        val firebase_db_User =firebase_db_User(name = account,mail = mail,check = "NO",img_path = "NO")
                        val userRef = FirebaseDatabase.getInstance().getReference().child("member").child(account)
                        userRef.setValue(firebase_db_User)
                        Toast.makeText(this,"註冊成功 請靜待管理員審核",Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,login::class.java)


                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"信箱已註冊過 請重新註冊",Toast.LENGTH_SHORT).show()
                    }
                }

            }else{
                Toast.makeText(this,"密碼重複錯誤 請重新填寫",Toast.LENGTH_SHORT).show()
            }
        }


    }




    private fun init() {


        btn_reginster.setOnClickListener(btn_reginster_click)


    }


}

class firebase_db_User(val name :String , val check :String,val mail:String,val img_path:String){


}


