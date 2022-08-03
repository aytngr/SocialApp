package com.example.socialapp.ui

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.socialapp.R
import com.example.socialapp.adapter.CommentAdapter
import com.example.socialapp.adapter.GridViewAdapter
import com.example.socialapp.adapter.PostAdapter
import com.example.socialapp.adapter.StatusAdapter
import com.example.socialapp.model.Comment
import com.example.socialapp.model.Post
import com.example.socialapp.model.Status
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGrid:ImageButton = findViewById(R.id.btn_menu)
        val btnList:ImageButton = findViewById(R.id.btn_list)


        btnList.isSelected = true

        val post_recyclerview = findViewById<RecyclerView>(R.id.post_recyclerview)

        val post_gridview = findViewById<GridView>(R.id.gridView1)



        btnGrid.setOnClickListener {
            btnList.isSelected = false
            it.isSelected = true
            post_recyclerview.visibility = View.GONE
            post_gridview.visibility = View.VISIBLE
        }
        btnList.setOnClickListener {
            btnGrid.isSelected = false
            it.isSelected = true
            post_recyclerview.visibility = View.VISIBLE
            post_gridview.visibility = View.GONE
        }

        val statusList = arrayListOf<Status>(Status(R.drawable.profile4,"Brian"),Status(R.drawable.profile2,"John"),
            Status(R.drawable.profile3,"Sarah"),Status(R.drawable.profile4,"Ray"),Status(R.drawable.profile5,"David"))

        val postList = arrayListOf<Post>(Post(R.drawable.profile4,"Brian",R.drawable.cactus,123,false),
            Post(R.drawable.profile2,"Ray",R.drawable.sea,323,false),Post(R.drawable.profile3,"Sarah",R.drawable.sun,323,false),
            Post(R.drawable.profile5,"Ray",R.drawable.mountain,323,false)
        )



        val status_recyclerview = findViewById<RecyclerView>(R.id.status_recyclerview)
        status_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val statusRecyclerviewAdapter = StatusAdapter(statusList)
        status_recyclerview.adapter = statusRecyclerviewAdapter

        post_recyclerview.layoutManager = LinearLayoutManager(this)
        val postRecyclerviewAdapter = PostAdapter(postList,this)
        post_recyclerview.adapter = postRecyclerviewAdapter

        val gridViewAdapter = GridViewAdapter(postList)
        post_gridview.adapter = gridViewAdapter
    }
}