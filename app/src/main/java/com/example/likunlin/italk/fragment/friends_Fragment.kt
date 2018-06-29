package com.example.likunlin.italk.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

import com.example.likunlin.italk.R

import android.support.v7.widget.GridLayoutManager
import android.util.Log


import android.view.*
import android.widget.Toast


import com.example.likunlin.italk.adapter.friends_add_recycleview_adapter
import com.example.likunlin.italk.information.friends_info
import com.example.likunlin.italk.information.friends_list

import kotlinx.android.synthetic.main.friends_fragment.*

import java.util.ArrayList



class friends_Fragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {



        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.friends_fragment, container, false)



    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        var friends_items_array: ArrayList<friends_info> = ArrayList()
        friends_items_array.addAll(friends_list().get())
        friends_add_recycleview.layoutManager = GridLayoutManager( getActivity(),3, GridLayoutManager.VERTICAL, false)
        friends_add_recycleview.adapter = friends_add_recycleview_adapter(friends_items_array)

        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {


        (activity as AppCompatActivity).setSupportActionBar(frind_toolbar)


        frind_toolbar.setTitle("增加好友")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater?) {

        inflater!!.inflate(R.menu.friend_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.friends_item1 -> Toast.makeText(context,"test3", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }







}


