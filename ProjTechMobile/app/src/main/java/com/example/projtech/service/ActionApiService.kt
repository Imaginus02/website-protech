package com.example.projtech.service

import com.example.projtech.database.dto.ActionDto
import retrofit2.Call
import retrofit2.http.GET

interface ActionApiService {

    data class ActionRequest(val name: String, val instruction: String, val orderInCode: Int, val codeId: Int)

    @GET("instructions")
    fun findAll(): Call<List<ActionDto>>
}