package com.example.projtech.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.projtech.database.dto.ActionDto

@Entity(tableName = "raction")
data class Action(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo val name: String,
    @ColumnInfo val action: String,
    @ColumnInfo val order: Int
) {
    fun toDto(): ActionDto =
        ActionDto(id, name, action, order)
}