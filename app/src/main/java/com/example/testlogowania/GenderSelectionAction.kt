package com.example.testlogowania

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GenderSelectionAction : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gender_selection_action)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
    fun onCreateMan(view: View) {
        val intent = Intent(this, Levelman::class.java)
        startActivity(intent)
    }
    fun onCreateWoman(view: View) {
        val intent = Intent(this, Levelwoman::class.java)
        startActivity(intent)
    }
    fun close(view: View){
        finish()
    }
}