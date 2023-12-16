package com.example.projtech.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.projtech.database.model.Action
import com.example.projtech.database.model.Code

@Dao
interface ActionDao {

    @Query("select * from raction order by `order` and id")
    fun findAll(): List<Action>

    @Query("select * from raction where codeId=:id")
    fun findByCodeId(id: Long): List<Action>
}