package com.example.recyclerapi.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerapi.R
import com.example.recyclerapi.models.AircraftModel
import kotlinx.android.synthetic.main.plane_row.view.*


class PlanesAdapter(private val planes: List<AircraftModel>) : RecyclerView.Adapter<PlanesAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val planeShort: TextView = itemView.planeShort
        val planeLong: TextView = itemView.planeLong
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plane_row, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = planes.size

    override fun onBindViewHolder(holder: PlanesAdapter.ViewHolder, position: Int) {
        holder.planeShort.text = planes[position].shortDescription
        holder.planeLong.text = planes[position].longDescription
    }

}