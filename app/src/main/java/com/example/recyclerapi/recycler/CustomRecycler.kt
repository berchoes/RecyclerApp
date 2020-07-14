package com.example.recyclerapi.recycler

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver

class CustomRecycler(context: Context) :
    RecyclerView(context) {

    override fun setAdapter(adapter: Adapter<*>?) {
        super.setAdapter(adapter)
    }




}