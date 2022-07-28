package com.example.socialapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.socialapp.R
import com.example.socialapp.adapter.StatusAdapter
import com.example.socialapp.model.Status

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val statusList = arrayListOf<Status>(Status(R.drawable.profile1,"Ali"),Status(R.drawable.profile2,"John"),
            Status(R.drawable.profile3,"Sarah"),Status(R.drawable.profile4,"Ray"),Status(R.drawable.profile5,"David"))

        val recyclerview = findViewById<RecyclerView>(R.id.status_recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val recyclerviewAdapter = StatusAdapter(statusList)
        recyclerview.adapter = recyclerviewAdapter
    }
}