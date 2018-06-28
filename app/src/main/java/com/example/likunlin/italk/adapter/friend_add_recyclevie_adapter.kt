package com.example.likunlin.italk.adapter


import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.likunlin.italk.R
import com.example.likunlin.italk.information.friends_info
import com.example.likunlin.italk.information.message_info
import com.example.likunlin.italk.talk.talk
import java.util.ArrayList


class friends_add_recycleview_adapter(val friends_item:ArrayList<friends_info>):RecyclerView.Adapter<friends_add_recycleview_adapter.viewholder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): viewholder{
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.friends_recycleview, parent, false) as CardView
        return viewholder(view)
    }


    override fun getItemCount():Int = friends_item.size+1


    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder!!.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {

            }

        })
        if(position == 0){
            holder.friends_add_recycleview_img.setImageResource(R.drawable.friend_add)

        }else{
            val objects = friends_item[position-1]
            holder.friends_add_recycleview_name.text = objects.name

        }



    }



    class viewholder(view: CardView) : RecyclerView.ViewHolder(view){
        var friends_add_recycleview_img = view.findViewById<ImageView>(R.id.friends_add_recycleview_img)
        var friends_add_recycleview_name = view.findViewById<TextView>(R.id.friends_add_recycleview_name)

    }

}