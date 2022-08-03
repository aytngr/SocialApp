package com.example.socialapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.socialapp.R
import com.example.socialapp.model.Comment
import com.example.socialapp.model.Post
import com.example.socialapp.model.Status
import com.google.android.material.bottomsheet.BottomSheetDialog

class PostAdapter(private val mList: ArrayList<Post>, val context: Context): RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private lateinit var view: View


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.post,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = mList[position]

        val commentList = arrayListOf<Comment>(
            Comment(R.drawable.profile3,"Sarah","Very beautiful!"),
            Comment(R.drawable.profile4,"David","Interesing!")
        )

        holder.icon.setImageResource(post.icon!!)
        holder.name.text = post.name
        holder.image.setBackgroundResource(post.image!!)
        holder.like.setOnClickListener {
            if(!holder.liked){
                holder.like.setProgress(0F);
                holder.like.pauseAnimation();
                holder.like.playAnimation();
                holder.like_count.text = (holder.like_count.text.toString().toInt() + 1).toString()
                holder.liked = true
            }else if(holder.liked){
                holder.like.setProgress(0F);
                holder.like.pauseAnimation();
                holder.like_count.text = (holder.like_count.text.toString().toInt() - 1).toString()
                holder.liked = false
            }
        }
        holder.btnComment.setOnClickListener {
            Log.i("adapter", "clicked")
            val bottomSheetDialog = BottomSheetDialog(context);
            bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_layout);
            val comment_recyclerview = bottomSheetDialog.findViewById<RecyclerView>(R.id.comment_recyclerview)
            val comment_send = bottomSheetDialog.findViewById<ImageButton>(R.id.comment_send)
            val comment_text = bottomSheetDialog.findViewById<EditText>(R.id.et_comment)
            comment_send?.setOnClickListener {
                if(comment_text?.text.toString() != ""){
                    commentList.add(Comment(R.drawable.profile3,"aytn",comment_text?.text.toString()))
                    val commentRecyclerviewAdapter = CommentAdapter(commentList)
                    comment_recyclerview?.adapter = commentRecyclerviewAdapter
                    comment_text?.setText("")
                }
            }
            comment_recyclerview?.layoutManager = LinearLayoutManager(context)
            val commentRecyclerviewAdapter = CommentAdapter(commentList)
            comment_recyclerview?.adapter = commentRecyclerviewAdapter
            bottomSheetDialog.show();
        }
    }
    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        var liked: Boolean = false
        var icon: ImageView = itemView.findViewById(R.id.icon)
        var name: TextView = itemView.findViewById(R.id.name)
        var like_count: TextView = itemView.findViewById(R.id.like_count)
        var image: ImageView = itemView.findViewById(R.id.post_image)
        var like: LottieAnimationView = itemView.findViewById(R.id.lav_thumbUp)
        val btnComment:ImageButton = itemView.findViewById(R.id.btn_comment)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}