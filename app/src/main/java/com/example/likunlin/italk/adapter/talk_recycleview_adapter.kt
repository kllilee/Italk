package com.example.likunlin.italk.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.likunlin.italk.R
import com.example.likunlin.italk.information.*
class  MyAdapter(val items : ArrayList<message_info>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(view: CardView) : RecyclerView.ViewHolder(view){
        var my_message = view.findViewById<TextView>(R.id.m_message)
        var my_name = view.findViewById<TextView>(R.id.m_message_name)
        var my_time = view.findViewById<TextView>(R.id.m_message_time)
        var else_message = view.findViewById<TextView>(R.id.e_message)
        var else_name = view.findViewById<TextView>(R.id.e_message_name)
        var else_time = view.findViewById<TextView>(R.id.e_message_time)




    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):ViewHolder {
        if(viewType == 0){
            val view = LayoutInflater.from(parent!!.context).inflate(R.layout.my_message, parent, false) as CardView
            return ViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent!!.context).inflate(R.layout.else_message, parent, false) as CardView
            return ViewHolder(view)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val objects = items[position] as message_info

        if (objects.name == "Ted") {
            holder.my_name!!.text = "You"
            holder.my_time!!.text = objects.time

            holder.my_message!!.text = objects.message

        } else {
            holder.else_name!!.text = objects.name
            holder.else_time!!.text = objects.time
            holder.else_message!!.text = objects.message
        }
    }

    override fun getItemViewType(position: Int): Int {
        val objects =items[position].name

        if (objects == "Ted"){
            return 0
        }else{
            return 1
        }



        return super.getItemViewType(position)
    }
}