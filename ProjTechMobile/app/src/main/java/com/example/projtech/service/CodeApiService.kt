//package com.example.projtech.service
//
//import com.example.projtech.database.dto.ActionDto
//import com.example.projtech.database.dto.CodeDto
//import retrofit2.Call
//import retrofit2.http.Body
//import retrofit2.http.GET
//import retrofit2.http.POST
//import retrofit2.http.Path
//
//interface CodeApiService {
//    data class ActionRequestBody(val name: String, val instruction: String, val orderInCode: Int, val codeId: Int)
//    data class CodeRequestBody(val name: String, val actions: List<ActionRequestBody>)
//
//    @GET("instruction")
//    fun findAll(): Call<List<ActionDto>>
//
//    @GET("codes/{id}")
//    fun findById(@Path("id") id: Long): Call<CodeDto>
//
//    @POST("request")
//    fun addExecution(@Body id: Long): Call<CodeDto>
//}