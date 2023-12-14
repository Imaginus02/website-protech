package com.example.projtech.connexion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.projtech.MainActivity
import com.example.projtech.R
import com.example.projtech.page.PageActivity

class EleveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleve)
    }

        // val param = intent.getStringExtra(MainActivity.WINDOW_NAME_PARAM)
        // val windowName = findViewById<TextView>(R.id.txt_window_name)
       //  windowName.text =

    fun connexionEleve(view: View) {
        val intent = Intent(this, PageActivity::class.java).apply {
        }
        startActivity(intent)
    }
}