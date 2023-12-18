package com.example.projtech.page

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projtech.R
import com.example.projtech.adaptater.ActionsAdapter
import com.example.projtech.service.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActionsActivity() : AppCompatActivity() {//, OnActionClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        val actionsAdapter = ActionsAdapter()


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
            recyclerView.adapter = actionsAdapter // (5)
        }

        lifecycleScope.launch(context = Dispatchers.IO) { // (1)
            runCatching { ApiServices.actionApiService.findAll().execute() }
                .onSuccess {
                    withContext(context = Dispatchers.Main) { // (2)
                        actionsAdapter.setItems(it.body() ?: emptyList())
                    }
                }
                .onFailure {
                    withContext(context = Dispatchers.Main) {
                        it.printStackTrace()
                        Toast.makeText(
                            applicationContext,
                            "Error on rooms loading $it",
                            Toast.LENGTH_LONG
                        )
                            .show()  // (3)
                    }
                }
        }


        //roomsAdapter.setItems(ActionSource.ACTIONS)  // (6)
//        runCatching { // (1)
//            ApiServices.codesApiService.findAll().execute() // (2)
//        }
//            .onSuccess { roomsAdapter.setItems(it.body() ?: emptyList()) }  // (3)
//            .onFailure {
//                it.printStackTrace() //(4)
//                Toast.makeText(this, "Error on rooms loading $it", Toast.LENGTH_LONG).show()  // (5)
//            }

        /*  lifecycleScope.launch(context = Dispatchers.IO) { // (1)
              runCatching { ApiServices.actionApiService.findAll().execute() }
                  .onSuccess {
                      withContext(context = Dispatchers.Main) { // (2)
                          println(it.body())
                          actionsAdapter.setItems(it.body() ?: emptyList())
                      }

                  }
                  .onFailure {
                      withContext(context = Dispatchers.Main) {
                          println("On est dans la bonne fonction mais ça a pas marché")

                          if (it is IOException) {
                              // Handle IO-related exceptions
                          }

                          it.printStackTrace()
                          Toast.makeText(
                              applicationContext,
                              "Error on rooms loading $it",
                              Toast.LENGTH_LONG
                          )
                              .show()  // (3)
                      }
                  }
          }

         */
    }

//    override fun selectAction(id: Long) {
//        val intent =
//            Intent(this, ActionActivity::class.java).putExtra(MainActivity.ROOM_ID_PARAM, id)
//        startActivity(intent)
//    }
}
