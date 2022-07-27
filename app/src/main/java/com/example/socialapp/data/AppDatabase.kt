package com.example.socialapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.socialapp.model.Status

@Database(entities = [Status::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun statusDao(): StatusDao
}