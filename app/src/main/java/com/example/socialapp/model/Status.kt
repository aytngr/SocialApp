package com.example.socialapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Status (
    @ColumnInfo(name = "icon") val title: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "checked") var checked: Boolean = false,
    @ColumnInfo(name = "userCreatorId") val userCreatorId: Int?,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0)
