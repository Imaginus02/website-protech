package com.example.projtech.database.dto

data class ActionDto(
    val id: Long,
    val name: String,
    val action: String,
    val orderInCode: Int,
    val codeId: Long
)

data class ActionCommandDto(
    val name: String,
    val action: String,
    val orderInCode: Int,
    val codeId: Long
)
