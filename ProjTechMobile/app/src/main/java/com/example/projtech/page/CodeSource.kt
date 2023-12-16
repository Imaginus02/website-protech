package com.example.projtech.page

import android.widget.Toast
import com.example.projtech.database.dto.ActionDto
import com.example.projtech.database.dto.CodeDto
import com.example.projtech.service.ApiServices
import com.example.projtech.service.CodeApiService
import javax.security.auth.callback.Callback
import retrofit2.Call
import retrofit2.Response
object CodeSource {

    var CODES: List<CodeDto> = ApiServices.codesApiService.findAll().execute().body() ?: emptyList()



    // var CODES: List<CodeDto> = emptyList() // Initialisez votre liste de codes vide
    /* fun loadCodes() {
        ApiServices.codesApiService.findAll().enqueue(object : retrofit2.Callback<List<CodeDto>> {
            override fun onResponse(call: Call<List<CodeDto>>, response: Response<List<CodeDto>>) {
                if (response.isSuccessful) {
                    val codeDtoList = response.body()
                    codeDtoList?.let {
                        CODES = it // Mettez à jour la liste de codes avec les données reçues
                    }
                } else {
                    // Gérer les erreurs de requête ici
                }
            }

            override fun onFailure(call: Call<List<CodeDto>>, t: Throwable) {
                // Gérer les échecs de requête ici
            }
        })
    }

     */
}
