package com.example.testlogowania

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Selectbodypart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_selectbodypart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun onCreateStomach(view: View) {
        val intent = Intent(this, Stomach::class.java)
        startActivity(intent)
    }
    fun onCreateArms(view: View) {
        val intent = Intent(this, Arms::class.java)
        startActivity(intent)
    }
    fun onCreateButtocks(view: View) {
        val intent = Intent(this, Buttocks::class.java)
        startActivity(intent)
    }
    fun onCreateBack(view: View) {
        val intent = Intent(this, Back::class.java)
        startActivity(intent)
    }
    fun onCreateChest(view: View) {
        val intent = Intent(this, Chest::class.java)
        startActivity(intent)
    }
    fun onCreateLegs(view: View) {
        val intent = Intent(this, Legs::class.java)
        startActivity(intent)
    }
    fun closeselectbody(view: View){
        finish()
    }
}