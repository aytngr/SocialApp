package com.example.socialapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.socialapp.R
import com.example.socialapp.model.Status

class StatusAdapter(private val mList: ArrayList<Status>): RecyclerView.Adapter<StatusAdapter.ViewHolder>() {
    private lateinit var view: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.status,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val status = mList[position]

        holder.statusIcon.setBackgroundResource(status.icon!!)
        holder.statusName.text = status.name
    }
    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        var statusIcon: ImageButton = itemView.findViewById(R.id.status_icon)
        var statusName: TextView = itemView.findViewById(R.id.status_name)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}