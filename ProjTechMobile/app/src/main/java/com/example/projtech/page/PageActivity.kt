package com.example.projtech.page

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projtech.R
import com.example.projtech.adaptater.ActionsAdaptater
import com.example.projtech.database.dao.ActionDao
import com.example.projtech.service.ApiServices

class PageActivity(val actionDao: ActionDao) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)
//        val windowDao = ProTechApplication
        val roomsAdapter = ActionsAdaptater(actionDao)

        // val param = intent.getStringExtra(Professeur.USER_PROF)
        // val windowName = findViewById<TextView>(R.id.idUserProf)
        // windowName.text = param

        findViewById<RecyclerView>(R.id.list_actions).also { recyclerView -> // (1)
            recyclerView.layoutManager = LinearLayoutManager(this) // (2)
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    this,
                    DividerItemDecoration.VERTICAL
                )
            ) // (3)
            recyclerView.setHasFixedSize(true) // (4)
            recyclerView.adapter = roomsAdapter // (5)
        }


        //roomsAdapter.setItems(ActionSource.ACTIONS)  // (6)
        runCatching { // (1)
            ApiServices.codesApiService.findAll().execute() // (2)
        }
            .onSuccess { roomsAdapter.setItems(it.body() ?: emptyList()) }  // (3)
            .onFailure {
                it.printStackTrace() //(4)
                Toast.makeText(this, "Error on rooms loading $it", Toast.LENGTH_LONG).show()  // (5)
            }
    }
}
