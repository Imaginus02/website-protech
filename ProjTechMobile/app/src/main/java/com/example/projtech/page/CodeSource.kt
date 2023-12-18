<<<<<<< HEAD
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


=======
//package com.example.projtech.page
//
//import android.widget.Toast
//import androidx.lifecycle.lifecycleScope
//import com.example.projtech.database.dto.ActionDto
//import com.example.projtech.database.dto.CodeDto
//import com.example.projtech.service.ApiServices
//import com.example.projtech.service.CodeApiService
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import javax.security.auth.callback.Callback
//import retrofit2.Call
//import retrofit2.Response
//object CodeSource {
//    var CODES: List<CodeDto> = emptyList() // Initialisation avec une liste vide
//
//    fun fetchCodes() {
////        try {
////            val response = ApiServices.codesApiService.findAll().execute()
////            if (response.isSuccessful) {
////                println("coucou")
////                println(response.body())
////                val codes = response.body()
////                if (codes != null) {
////                    CODES = codes // Mettre à jour les codes dans l'objet CodeSource
////                    println("Données récupérées avec succès : $codes")
////                } else {
////                    println("Réponse vide")
////                }
////            } else {
////                println("Réponse non réussie : ${response.code()}")
////            }
////        } catch (e: Exception) {
////            println("Erreur lors de la récupération des données : ${e}")
////            e.printStackTrace()
////        }
//        lifecycleScope.launch(context = Dispatchers.IO) { // (1)
//            runCatching { ApiServices.codesApiService.findAll().execute() }
//                .onSuccess {
//                    withContext(context = Dispatchers.Main) { // (2)
//                        roomsAdapter.setItems(it.body() ?: emptyList()) }
//                }
//                .onFailure {
//                    withContext(context = Dispatchers.Main) {
//                        it.printStackTrace()
//                        Toast.makeText(applicationContext, "Error on rooms loading $it", Toast.LENGTH_LONG)
//                            .show()  // (3)
//                    }
//                }
//        }
//    }
//}
>>>>>>> 8c3aca9d796ae01bf8337331e37b5e2b0251afdc
