package com.example.likunlin.italk.sign

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.likunlin.italk.R
import com.example.likunlin.italk.R.drawable.account
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_sign.*
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference



class sign : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)


        init()
    }



    private val btn_reginster_click = View.OnClickListener{
        val account = tv_reginster_account.text.toString()
        val mail = tv_reginster_mail.text.toString()
        val password =  tv_reginster_password.text.toString()
        val repassword = tv_reginster_repassword.text.toString()
        val database : FirebaseDatabase = FirebaseDatabase.getInstance();
        val getContactsRef = database.getReference("italk-db2d2").child("member")
        val queryRef = getContactsRef.orderByChild("mail").equalTo(mail)
        queryRef.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {
            Log.v("firebase",p0.toString())

            }

        })
 //       val auth = FirebaseAuth.getInstance()
//        auth.createUserWithEmailAndPassword(mail,password)
//        val reference_mail = FirebaseDatabase.getInstance().getReference().child("member").equalTo(mail)




    }

    private fun reginster(account:String,mail: String,password : String) {
        val check_account :String = check_account(account,mail)


        if (check_account == "確認完成"){


            val database = FirebaseDatabase.getInstance()
            val myRef_mail = database.getReference("member/"+account+"/mail")
            myRef_mail.setValue(mail)
            val myRef_password = database.getReference("member/"+account+"/password")
            myRef_password.setValue(password)

            val myRef_check = database.getReference("member/"+account+"/check")
            myRef_check.setValue("No")
        }else{
            Toast.makeText(this,check_account,Toast.LENGTH_SHORT).show()
        }





    }

    private fun check_account(account: String, mail: String):String {
        var check_result : String



        val reference_mail = FirebaseDatabase.getInstance().getReference("member").equalTo(mail)
        Log.v("test",reference_mail.toString())


        check_result = "確認完成"

        return check_result


    }





    private fun init() {


        btn_reginster.setOnClickListener(btn_reginster_click)

        val data_ref = FirebaseDatabase.getInstance().getReference().child("member")
        val pp =data_ref.equalTo("kllilee21@gmail.com")
        Log.v("test",pp.toString())

    }


}
