package com.example.likunlin.italk.talk


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.likunlin.italk.PaddingDecoration.MyPaddingDecoration
import com.example.likunlin.italk.R
import com.example.likunlin.italk.adapter.MyAdapter
import com.example.likunlin.italk.information.message_info
import com.example.likunlin.italk.information.message_list
import kotlinx.android.synthetic.main.activity_talk.*
import java.text.SimpleDateFormat
import java.util.*

class talk : AppCompatActivity() {
    var items_array: ArrayList<message_info> = ArrayList()


    private val ib_send_click = View.OnClickListener{
        val message = et_message.text.toString()
        val mCal = Calendar.getInstance()
        val dateformat = "yyyy/MM/dd kk:mm"
        val df = SimpleDateFormat(dateformat)
        val today = df.format(mCal.getTime())

        val message_objext = message_info(name = "Ted",time = today ,img_name = "test",message = message,chanel = "admin01")

        items_array.add(message_objext)
        //items_array.add(message)
        recycleView.adapter = MyAdapter(items_array)

        recycleView.scrollToPosition(items_array.size-1)//視窗固定在最新訊息



        et_message.setText("")//清空輸入框

        hideKeyboard()//回收鍵盤
    }

    private val f_btn_voice_click = View.OnClickListener{

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talk)



        items_array.addAll(message_list().get())
        val recyclerView = findViewById(R.id.recycleView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(items_array)
        recyclerView.addItemDecoration( MyPaddingDecoration(this))
        recycleView.scrollToPosition(items_array.size-1)
        ib_send.setOnClickListener(ib_send_click)
        f_btn_voice.setOnClickListener(f_btn_voice_click)
        Log.d("array",message_list().toString())
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
