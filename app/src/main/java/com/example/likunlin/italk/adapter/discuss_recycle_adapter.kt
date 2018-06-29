package com.example.likunlin.italk.adapter

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.likunlin.italk.R
import com.example.likunlin.italk.information.discuss_info
import com.example.likunlin.italk.login

import com.example.likunlin.italk.talk.talk
import java.util.*


class discuss_recycle_adapter(val discuss_item:ArrayList<discuss_info>): RecyclerView.Adapter<discuss_recycle_adapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.discuss_recycleview, parent, false) as LinearLayoutCompat


        return ViewHolder(view)
    }

    override fun getItemCount():Int= discuss_item.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(view: View?) {

                val intent = Intent(view!!.context, talk::class.java)
                intent.putExtra("position",position.toString())
                view.context.startActivity(intent)

            }

        })

            holder!!.discuss_recycleview_img.setImageResource(discuss_item[position].img_path)
            holder!!.discuss_recycleview_title!!.text = discuss_item[position].title

    }



    class ViewHolder(view: LinearLayoutCompat) :RecyclerView.ViewHolder(view){


        var discuss_recycleview_img = view.findViewById<ImageView>(R.id.discuss_img)
        var discuss_recycleview_title = view.findViewById<TextView>(R.id.discuss_title)






    }






}


