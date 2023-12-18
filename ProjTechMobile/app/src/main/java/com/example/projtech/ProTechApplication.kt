package com.example.projtech

import android.app.Application
import androidx.room.Room
import com.example.projtech.database.ProTechDatabase

class ProTechApplication : Application() {
    val database: ProTechDatabase by lazy {
        Room.databaseBuilder(this,ProTechDatabase::class.java, "protechdatabase")
            .build()
    }
    //val actionDao = database.ActionDao();
}