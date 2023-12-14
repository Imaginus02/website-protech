package com.example.projtech.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projtech.database.dao.ActionDao
import com.example.projtech.database.dao.CodeDao
import com.example.projtech.database.model.Action
import com.example.projtech.database.model.Code

@Database(entities = [Code::class, Action::class], version = 1)
abstract class ProTechDatabase : RoomDatabase() {
    abstract fun ActionDao(): ActionDao
    abstract fun CodeDao(): CodeDao

}