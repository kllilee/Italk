package com.example.likunlin.italk

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AlertDialog
import android.util.Log

import android.view.View
import android.widget.Toast
import com.example.likunlin.italk.firebase.firebase

import com.example.likunlin.italk.firebase.user

import com.example.likunlin.italk.sign.sign
import com.example.likunlin.italk.talk.talk
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() ,Onfirebaselogin_Callback,shareperference_user_callback{


    override fun s_onComplete() {
        if(user.name == ""){

        }else{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun s_onFail() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onComplete(message: String,password: String) {
        if(message == "YES"){
            val message_dialog = AlertDialog.Builder(this)
            message_dialog.setMessage("是否紀錄帳號密碼")
            message_dialog.setPositiveButton("確定",{dialog,whichButton->
                val preference = PreferenceManager.getDefaultSharedPreferences(this)
                val editor = preference.edit()
                editor.putString("login_name",user.name)
                editor.putString("login_password",password)
                editor.putString("login_imgpath",user.img_path)
                editor.putString("login_mail",user.mail)
                editor.putString("login_check",user.check)
                editor.commit()

                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

            })
            message_dialog.setNegativeButton("拒絕",{dialog,whichButton->
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

            })
            val alert = message_dialog.create()
            alert.show()





        }else{
            Toast.makeText(this,"資格尚在審核中 請稍候",Toast.LENGTH_SHORT).show()
        }


    }

    override fun onFail() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        shareperference_get(this)

        tv_signup.setOnClickListener(tv_signup_click)
        btn_login.setOnClickListener(btn_login_click)
        tv_forgot.setOnClickListener(tv_forgot_click)






    }

    private fun shareperference_get(shareperference: shareperference_user_callback) {
        val preference = PreferenceManager.getDefaultSharedPreferences(this)
        user.name = preference.getString("login_name","")
        user.check = preference.getString("login_check","")
        user.img_path = preference.getString("login_imgpath","")
        user.mail = preference.getString("login_mail","")
        val password = preference.getString("login_password","")
        if(user.name.isEmpty()){

        }else{
            shareperference.s_onComplete()

        }



    }

    private val tv_signup_click = View.OnClickListener{
        inter_sign()

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
                    firebase_Login(this).start_Login(email,password)
                }
            }
        }



    }


    private val tv_forgot_click = View.OnClickListener{
        val intent = Intent(this, talk::class.java)
        startActivity(intent)
    }




    fun inter_sign(){
        val intent = Intent(this,sign::class.java)
        startActivity(intent)
    }

}
interface Onfirebaselogin_Callback {
    fun onComplete(message: String,password:String)
    fun onFail()
}



interface shareperference_user_callback{
    fun s_onComplete()
    fun s_onFail()

}

class firebase_Login(private val firebase_login_callback: Onfirebaselogin_Callback) {


    fun start_Login(email:String,password: String) {
        var reference_data = FirebaseDatabase.getInstance().getReference("member").orderByChild("mail").equalTo(email)
        reference_data.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(dataSnapshot: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                try{
                    dataSnapshot!!.children.iterator().forEach {it->
                        val user_firebase = it.getValue(firebase::class.java)
                        user.name = user_firebase!!.name
                        user.mail = user_firebase!!.mail
                        user.img_path = user_firebase!!.img_path
                        user.check = user_firebase!!.check
                        Log.v("firebase",user.check)
                    }

                    firebase_login_callback.onComplete(user.check,password)
                }catch (e: InterruptedException){
                    firebase_login_callback.onFail()

                }


            }
        })
    }
}

