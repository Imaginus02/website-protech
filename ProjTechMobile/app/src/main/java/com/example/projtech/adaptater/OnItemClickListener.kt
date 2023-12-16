package com.example.projtech.adaptater

import com.example.projtech.database.dto.ActionDto

interface OnItemClickListener {
    fun onItemClick(actionDto: ActionDto)
}