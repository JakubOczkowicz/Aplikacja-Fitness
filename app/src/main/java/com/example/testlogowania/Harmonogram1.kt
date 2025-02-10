package com.example.testlogowania

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Harmonogram1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_harmonogram1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun close(view: View){
        finish()
    }

    fun enroll(view: View){
        var textView = view as TextView
        var lines = textView.text.split("\n")
        var text = lines.get(lines.size - 1)
        var lines2 = text.split("/")
        var number = lines2.get(0).toInt()
        var string = lines.dropLast(1).joinToString("\n")
        if(number < 10){
            number++
            if(number == 10){
                textView.setBackgroundColor(Color.argb(128, 255, 0, 0))
            }
        }


        string += "\n" + number + "/10"


        textView.text = string
    }

    fun unregister(view: View){
        var textView = view as TextView
        var lines = textView.text.split("\n")
        var text = lines.get(lines.size - 1)
        var lines2 = text.split("/")
        var number = lines2.get(0).toInt()
        var string = lines.dropLast(1).joinToString("\n")
        if(number == 10){
            textView.setBackgroundColor(Color.argb(64, 50, 205, 50))
        }
        number--
        string += "\n" + number + "/10"

        textView.text = string
    }

}