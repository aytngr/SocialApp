package com.example.socialapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.socialapp.R
import com.example.socialapp.model.Post

class GridViewAdapter(private val postList: List<Post>): BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null

    // below method is use to return the count of course list
    override fun getCount(): Int {
        return postList.size
    }

    // below function is use to return the item of grid view.
    override fun getItem(position: Int): Any? {
        return null
    }

    // below function is use to return item id of grid view.
    override fun getItemId(position: Int): Long {
        return 0
    }

    // in below function we are getting individual item of grid view.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        // on blow line we are checking if layout inflater
        // is null, if it is null we are initializing it.
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        // on the below line we are checking if convert view is null.
        // If it is null we are initializing it.
        if (convertView == null) {
            // on below line we are passing the layout file
            // which we have to inflate for each item of grid view.
            convertView = layoutInflater!!.inflate(R.layout.grid_post, null)
        }
        // on below line we are initializing our course image view
        // and course text view with their ids.
        var icon: ImageView = convertView!!.findViewById(R.id.icon)
        var name: TextView = convertView!!.findViewById(R.id.name)
        var image: ImageView = convertView!!.findViewById(R.id.post_image)
        // on below line we are setting image for our course image view.
        icon.setBackgroundResource(postList.get(position).icon!!)
        image.setBackgroundResource(postList.get(position).image!!)
        // on below line we are setting text in our course text view.
        name.setText(postList.get(position).name)
        // at last we are returning our convert view.
        return convertView
    }
}