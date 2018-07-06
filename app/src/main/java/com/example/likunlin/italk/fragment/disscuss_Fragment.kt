package com.example.likunlin.italk.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.*
import android.widget.Toast
import com.example.likunlin.italk.PaddingDecoration.MyPaddingDecoration

import com.example.likunlin.italk.R
import com.example.likunlin.italk.adapter.discuss_recycle_adapter
import com.example.likunlin.italk.information.discuss_info
import com.example.likunlin.italk.information.discuss_list
import kotlinx.android.synthetic.main.disscuss_fragment.*



class disscuss_Fragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {



        return inflater.inflate(R.layout.disscuss_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        var discuss_items_array: ArrayList<discuss_info> = ArrayList()
        discuss_items_array.addAll(discuss_list().get())
        discuss_add_recycleview.layoutManager =  LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        discuss_add_recycleview.adapter = discuss_recycle_adapter(discuss_items_array)
        discuss_add_recycleview.addItemDecoration( MyPaddingDecoration(view!!.context))

        (activity as AppCompatActivity).setSupportActionBar(discuss_toolbar)
        discuss_toolbar.setTitle("討論區")


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).setSupportActionBar(discuss_toolbar)
        discuss_toolbar.setTitle("討論區")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.discuss_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.discuss_menu_item1 -> Toast.makeText(context,"test3", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


}


