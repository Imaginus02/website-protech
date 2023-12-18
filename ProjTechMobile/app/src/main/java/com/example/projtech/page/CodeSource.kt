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
    var CODES: List<CodeDto> = emptyList() // Initialisation avec une liste vide

    fun fetchCodes() {
        try {
            val response = ApiServices.codesApiService.findAll().execute()
            if (response.isSuccessful) {
                val codes = response.body()
                if (codes != null) {
                    CODES = codes // Mettre à jour les codes dans l'objet CodeSource
                    println("Données récupérées avec succès : $codes")
                } else {
                    println("Réponse vide")
                }
            } else {
                println("Réponse non réussie : ${response.code()}")
            }
        } catch (e: Exception) {
            println("Erreur lors de la récupération des données : ${e}")
            e.printStackTrace()
        }
    }
}


    // var CODES: List<CodeDto> = ApiServices.codesApiService.findAll().execute().body() ?: emptyList()


