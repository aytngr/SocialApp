package com.example.socialapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Status (
    @ColumnInfo(name = "icon") val icon: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0)
