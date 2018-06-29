package com.example.likunlin.italk.information

import com.example.likunlin.italk.R
import com.google.firebase.database.*
import java.util.*

class discuss_info(val title:String,val img_path:Int,val chanel :String){

}

class discuss_list:ArrayList<discuss_info>() {


    fun get():ArrayList<discuss_info> {
        val discuss_info_1 = ArrayList<discuss_info>()
        val firebase_discuss_message = FirebaseDatabase.getInstance().getReference().child("message").equalTo("italk")
        firebase_discuss_message.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot?) {


            }

        })

        discuss_info_1.add(discuss_info(title = "Italk",img_path= R.mipmap.disscuss_italk,chanel = "Italk"))



        return discuss_info_1
    }
}