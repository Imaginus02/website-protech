
package com.example.projtech.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.projtech.database.model.Code

@Dao
interface CodeDao {

    @Query("select * from rcode order by name")
    fun findAll(): List<Code>

    @Query("select * from rcode where id=:id")
    fun findById(id: Long): Code
}