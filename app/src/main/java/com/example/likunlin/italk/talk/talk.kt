package com.example.likunlin.italk.talk


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.likunlin.italk.MyView.MyRecycleView
import com.example.likunlin.italk.PaddingDecoration.MyPaddingDecoration
import com.example.likunlin.italk.R
import com.example.likunlin.italk.adapter.MyAdapter
import com.example.likunlin.italk.firebase.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_talk.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class talk : AppCompatActivity(),firebase_message_callback {
    override fun onComplete(message: ArrayList<message_info>) {
        message_items_array = message
        val talk_recyclerView = findViewById(R.id.talk_recycleView) as MyRecycleView

        talk_recyclerView.layoutManager = LinearLayoutManager(this)
        talk_recyclerView.adapter = MyAdapter(message_items_array)
        talk_recyclerView.addItemDecoration( MyPaddingDecoration(this))
        talk_recyclerView.setOnSizeChange(object :MyRecycleView.onSizeChange{
            override fun onChange() {
                talk_recyclerView.scrollToPosition(message_items_array.size-1)
            }

        })
        talk_recyclerView.scrollToPosition(message_items_array.size-1)

    }
    override fun onFail() {
    }

    var message_items_array: ArrayList<message_info> = ArrayList()


    private val ib_send_click = View.OnClickListener{
        val message = et_message.text.toString()
        val mCal = Calendar.getInstance()
        val dateformat = "yyyy/MM/dd kk:mm"
        val df = SimpleDateFormat(dateformat)
        val today = df.format(mCal.getTime())
        val message_objext = message_info(name = user.name,time = today ,img_name = R.mipmap.default_man,message = message,chanel = "Italk")
        firebase_message_write().push(message_objext)
        message_items_array.add(message_objext)
        //items_array.add(message)
        talk_recycleView.adapter = MyAdapter(message_items_array)
        talk_recycleView.scrollToPosition(message_items_array.size-1)//視窗固定在最新訊息
        et_message.setText("")//清空輸入框
        hideKeyboard()//回收鍵盤
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talk)
        setSupportActionBar(toolbar_talk)
        val chanel = intent.getStringExtra("chanel")
        Toast.makeText(this,chanel,Toast.LENGTH_SHORT).show()
        firebase_message_read(this).get(chanel)
        ib_send.setOnClickListener(ib_send_click)
    }

    //按送出後回收鍵盤
    private fun hideKeyboard() {
        val viewFocus = this.currentFocus
        if (viewFocus != null) {
            val imManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imManager.hideSoftInputFromWindow(viewFocus.windowToken, 0)
        }
    }

}


interface firebase_message_callback{
    fun onComplete(message:ArrayList<message_info>)
    fun onFail()
}


class firebase_message_read(val firebase_message_callback: firebase_message_callback){
    fun get(chanel:String){
        val reference_data = FirebaseDatabase.getInstance().getReference("message").child(chanel)
        reference_data.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(dataSnapshot: DatabaseError?) {
            }
            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                val message_list_array = ArrayList<message_info>()

                try{
                    for(ds in dataSnapshot!!.children){
                        val firebase_message_object = ds.getValue(message_info_1::class.java)
                        message_list_array.add(message_info(name = firebase_message_object!!.name,time = firebase_message_object.time,img_name = firebase_message_object.img_name.toInt(),message = firebase_message_object.message,chanel = firebase_message_object.chanel))
                    }
                    firebase_message_callback.onComplete(message_list_array)
                }catch (e: InterruptedException){
                    firebase_message_callback.onFail()
                }
            }
        })
    }

}
