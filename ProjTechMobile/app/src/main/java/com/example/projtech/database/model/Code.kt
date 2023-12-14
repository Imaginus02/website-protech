package com.example.projtech.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.projtech.database.dto.CodeDto
import java.util.stream.Collectors

@Entity(tableName = "rcode")
data class Code(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo val name: String,
    @ColumnInfo val actions: List<Action>
) {
    fun toDto():
            CodeDto =
        CodeDto(
            id,
            name,
            actions.stream().map(Action::toDto).collect(Collectors.toList())
        )
}
