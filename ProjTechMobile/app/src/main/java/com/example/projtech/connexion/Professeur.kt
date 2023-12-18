package com.example.projtech.connexion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.projtech.R
import com.example.projtech.page.ActionsActivity

class Professeur : AppCompatActivity() {
    companion object {
        const val USER_PROF = "com.automacorp.windowname.attribute"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professeur)
    }

    fun connexionProf(view: View) {
        val usernameProf = findViewById<EditText>(R.id.mailProf).text.toString()

//        val intent = Intent(this, ActionsActivity::class.java)
////            .apply {putExtra(USER_PROF, usernameProf) }
//
//        startActivity(intent)
        startActivity(Intent(this, ActionsActivity::class.java))
    }
}