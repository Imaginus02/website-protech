package com.example.projtech.service

import com.example.projtech.database.dto.CodeDto
import com.example.projtech.database.dto.StockIdDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CodeApiService {
    data class ActionRequestBody(val name: String, val action: String, val order: Int)
    data class CodeRequestBody(val name: String, val actions: List<ActionRequestBody>)

    @GET("codes")
    fun findAll(): Call<List<CodeDto>>

    @GET("codes/{id}")
    fun findById(@Path("id") id: Long): Call<CodeDto>

    @POST("execute")
    fun addExecution(@Body stockID: StockIdDTO): Call<CodeDto>
}