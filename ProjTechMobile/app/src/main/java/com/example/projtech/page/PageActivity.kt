package com.example.projtech.page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projtech.ProTechApplication
import com.example.projtech.R
import com.example.projtech.adaptater.ActionsAdaptater
import com.example.projtech.adaptater.OnItemClickListener
import com.example.projtech.connexion.Professeur
import com.example.projtech.database.dto.ActionDto
import com.example.projtech.database.dto.CodeDto
import com.example.projtech.database.dto.StockIdDTO
import com.example.projtech.service.ApiServices.codesApiService
import javax.security.auth.callback.Callback

class PageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)
//        val windowDao = ProTechApplication
        val roomsAdapter = ActionsAdaptater()

        val param = intent.getStringExtra(Professeur.USER_PROF)
        val profName = findViewById<TextView>(R.id.idNameProf)
        profName.text = param


        roomsAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(actionDto: ActionDto) {
                val actionName = actionDto.name
                val idAction = actionDto.id ;
                Toast.makeText(this@PageActivity, "You choose $actionName, d'id $idAction", Toast.LENGTH_LONG).show()

                // FAIRE UNE METHODE POST
                val stockIdDTO = StockIdDTO(idAction)

                try {
                    val response = codesApiService.addExecution(stockIdDTO).execute()
                    if (response.isSuccessful) {
                        Toast.makeText(this@PageActivity, "La commande est dans la file d'attente", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@PageActivity, "Problème dans l'envoi de la donnée", Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    // Gestion des échecs de requête ici
                }
            }
        })

        findViewById<RecyclerView>(R.id.list_actions).also { recyclerView -> // (1)
            recyclerView.layoutManager = LinearLayoutManager(this) // (2)
            recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL)) // (3)
            recyclerView.setHasFixedSize(true) // (4)
            recyclerView.adapter = roomsAdapter // (5)
        }

        roomsAdapter.setItems(ActionSource.ACTIONS)  // (6)


    }
}
