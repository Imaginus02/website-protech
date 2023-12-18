package com.example.projtech.adaptater

import com.example.projtech.database.dto.ActionDto
import com.example.projtech.database.dto.CodeDto

interface OnItemClickListener {
    fun selectAction(id: Long)
}