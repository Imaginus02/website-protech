package com.example.projtech.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.projtech.database.dto.StockIdDTO
import com.example.projtech.database.model.Code

@Dao
interface StockIdDAO {
    @Insert
    suspend fun addExecution(stockId: StockIdDTO)

}