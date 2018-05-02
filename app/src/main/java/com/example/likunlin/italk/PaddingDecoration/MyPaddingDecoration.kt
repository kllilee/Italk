package com.example.likunlin.italk.PaddingDecoration

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class MyPaddingDecoration(context: Context) : RecyclerView.ItemDecoration() {
    val divider: Int = 40
    val drvider_1: Int = 60
    init {

    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = drvider_1;  //相当于 设置 left padding
        outRect.top = divider;   //相当于 设置 top padding
        outRect.right = drvider_1; //相当于 设置 right padding
        outRect.bottom = divider  //相当于 设置 bottom padding
    }
}