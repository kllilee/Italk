package com.example.likunlin.italk.adapter

import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.likunlin.italk.R
import com.example.likunlin.italk.information.message_group_info
import com.example.likunlin.italk.talk.talk

class message_group_recycleview_adapter(val message_group_item:ArrayList<message_group_info>): RecyclerView.Adapter<message_group_recycleview_adapter.viewholder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): viewholder{
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.message_group_recycleview, parent, false) as CardView
        return viewholder(view)
    }


    override fun getItemCount():Int = message_group_item.size


    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder!!.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {

                val intent = Intent(view!!.context, talk::class.java)
                intent.putExtra("position",position.toString())
                view.context.startActivity(intent)

            }

        })

        val objects = message_group_item[position] as message_group_info


    }

    class viewholder(view: CardView) : RecyclerView.ViewHolder(view){
        var message_group_img = view.findViewById<ImageView>(R.id.message_group_image)
        var message_group_name = view.findViewById<TextView>(R.id.message_group_view_item)
        var message_group_time = view.findViewById<TextView>(R.id.message_group_time)
        var message_group_message = view.findViewById<TextView>(R.id.message_group_message)


    }

}