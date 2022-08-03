package com.example.socialapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.socialapp.R
import com.example.socialapp.model.Comment
import com.example.socialapp.model.Status

class CommentAdapter(private val mList: ArrayList<Comment>): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    private lateinit var view: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.comment,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = mList[position]

        holder.commentIcon.setImageResource(comment.icon!!)
        holder.commentName.text = comment.name
        holder.commentText.text = comment.comment
    }
    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        var commentIcon: ImageView = itemView.findViewById(R.id.comment_icon)
        var commentName: TextView = itemView.findViewById(R.id.comment_name)
        var commentText: TextView = itemView.findViewById(R.id.comment_text)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}