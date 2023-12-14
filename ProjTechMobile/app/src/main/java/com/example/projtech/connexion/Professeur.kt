package com.example.projtech.connexion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projtech.R
import com.example.projtech.page.PageActivity

class Professeur : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professeur)
    }

    fun connexionProf(view: View) {
        val intent = Intent(this, PageActivity::class.java).apply {
        }
        startActivity(intent)
    }
}