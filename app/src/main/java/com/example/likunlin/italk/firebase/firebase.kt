package com.example.likunlin.italk.firebase

import android.util.Log


import com.example.likunlin.italk.talk.firebase_message_callback
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



class firebase_message_write{
    fun push(message:message_info){

        val userRef = FirebaseDatabase.getInstance().getReference().child("message").child("Italk")
        userRef.push().setValue(message)

    }
}
