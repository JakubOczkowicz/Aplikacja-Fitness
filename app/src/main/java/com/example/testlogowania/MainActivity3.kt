package com.example.testlogowania

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject

class MainActivity3 : AppCompatActivity() {
    companion object {
        lateinit var ponTextViewsList: List<TextView>
        lateinit var wtTextViewsList: List<TextView>
        lateinit var śrTextViewsList: List<TextView>
        lateinit var czwTextViewsList: List<TextView>
        lateinit var ptTextViewsList: List<TextView>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ponTextViewsList = emptyList()
        wtTextViewsList= emptyList()
        śrTextViewsList= emptyList()
        czwTextViewsList= emptyList()
        ptTextViewsList= emptyList()
    }
    fun onCreatePlanClicked(view: View) {
        val intent = Intent(this, GenderSelectionAction::class.java)
        startActivity(intent)
    }
    fun closeac3(view: View){
        finish()
    }
    fun onTimetableCheckClicked(view: View) {
        val intent = Intent(this, Harmonogram1::class.java)
        startActivity(intent)
    }

    fun chcangeWindow(view: View) {
        val intent = Intent(this, HarmonogramTrener::class.java)
        startActivity(intent)
    }
}