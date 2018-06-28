package com.example.likunlin.italk.MyView

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet


class MyRecycleView : RecyclerView {
    var item_sizechange : onSizeChange? = null
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet):super(context,attr)
    constructor(context: Context, attr: AttributeSet, int: Int):super(context,attr,int)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        item_sizechange?.onChange()

    }

    fun setOnSizeChange(item : onSizeChange){
        this.item_sizechange = item
    }
    interface onSizeChange{
        fun onChange()
    }
}