package com.example.projtech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projtech.connexion.EleveActivity
import com.example.projtech.connexion.Professeur

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        const val WINDOW_NAME_PARAM = "com.automacorp.windowname.attribute"
        const val ROOM_ID_PARAM = "com.automacorp.windowname.attribute"
    }

    fun openStudent(view: View) {
        val intent = Intent(this, EleveActivity::class.java).apply {
        }
        startActivity(intent)
    }
    fun openProfesseur(view: View) {
        val intent = Intent(this, Professeur::class.java).apply {
        }
        startActivity(intent)
    }
}