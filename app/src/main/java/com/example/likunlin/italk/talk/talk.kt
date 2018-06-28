package com.example.likunlin.italk.talk


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.likunlin.italk.MyView.MyRecycleView
import com.example.likunlin.italk.PaddingDecoration.MyPaddingDecoration
import com.example.likunlin.italk.R
import com.example.likunlin.italk.adapter.MyAdapter
import com.example.likunlin.italk.firebase.user
import com.example.likunlin.italk.information.message_info
import com.example.likunlin.italk.information.message_list
import kotlinx.android.synthetic.main.activity_talk.*
import java.text.SimpleDateFormat
import java.util.*

class talk : AppCompatActivity() {
    var message_items_array: ArrayList<message_info> = ArrayList()


    private val ib_send_click = View.OnClickListener{
        val message = et_message.text.toString()
        val mCal = Calendar.getInstance()
        val dateformat = "yyyy/MM/dd kk:mm"
        val df = SimpleDateFormat(dateformat)
        val today = df.format(mCal.getTime())

        val message_objext = message_info(name = user.name,time = today ,img_name = "test",message = message,chanel = "admin01")

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

        val test = intent.getStringExtra("position")
        Toast.makeText(this,test,Toast.LENGTH_SHORT).show()

        message_items_array.addAll(message_list().get())
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
