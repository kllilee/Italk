package com.example.likunlin.italk.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.Toast
import com.example.likunlin.italk.Onfirebaselogin_Callback
import com.example.likunlin.italk.R

import com.example.likunlin.italk.adapter.message_group_recycleview_adapter
import com.example.likunlin.italk.information.message_group_info
import com.example.likunlin.italk.information.message_group_list
import kotlinx.android.synthetic.main.friends_fragment.*
import kotlinx.android.synthetic.main.message_fragment.*


class message_Fragment : Fragment(){


    var message_group_items_array: ArrayList<message_group_info> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        message_group_items_array.addAll(message_group_list().get())
        setHasOptionsMenu(true)


        return inflater.inflate(R.layout.message_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {



        message_group_recycleview.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        message_group_recycleview.adapter = message_group_recycleview_adapter(message_group_items_array)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).setSupportActionBar(message_toolbar)
        message_toolbar.setTitle("聊天訊息")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.message_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.message_toolbar_1 -> Toast.makeText(context,"test2",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}


