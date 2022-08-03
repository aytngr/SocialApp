package com.example.socialapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post (
    @ColumnInfo(name = "icon") val icon: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "image") val image: Int?,
    @ColumnInfo(name = "like_count") val like_count: Int?,
    @ColumnInfo(name = "liked") var liked: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0)
