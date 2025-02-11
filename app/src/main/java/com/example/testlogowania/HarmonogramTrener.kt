package com.example.testlogowania

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children

class HarmonogramTrener : AppCompatActivity() {
    lateinit var window : ConstraintLayout
    lateinit var textWindow : TextView
    lateinit var editText: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_harmonogram_trener)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        window = findViewById<ConstraintLayout>(R.id.hiddenLayout)
        window.visibility = View.GONE
        editText = findViewById<EditText>(R.id.editor)

        if(MainActivity3.ponTextViewsList.firstOrNull() != null){
            val pon = findViewById<LinearLayout>(R.id.pon)
            val wt = findViewById<LinearLayout>(R.id.wt)
            val śr = findViewById<LinearLayout>(R.id.śr)
            val czw = findViewById<LinearLayout>(R.id.czw)
            val pt = findViewById<LinearLayout>(R.id.pt)

            var ponTextViewsList = pon.children.filterIsInstance<TextView>().toList().drop(1)
            var wtTextViewsList = wt.children.filterIsInstance<TextView>().toList().drop(1)
            var śrTextViewsList = śr.children.filterIsInstance<TextView>().toList().drop(1)
            var czwTextViewsList = czw.children.filterIsInstance<TextView>().toList().drop(1)
            var ptTextViewsList = pt.children.filterIsInstance<TextView>().toList().drop(1)
            przepisz(ponTextViewsList, MainActivity3.ponTextViewsList)
            przepisz(wtTextViewsList, MainActivity3.wtTextViewsList)
            przepisz(śrTextViewsList, MainActivity3.śrTextViewsList)
            przepisz(czwTextViewsList, MainActivity3.czwTextViewsList)
            przepisz(ptTextViewsList, MainActivity3.ptTextViewsList)

        }

    }


    fun przepisz(obecny: List<TextView>, doSpisania: List<TextView> ){
        var i = 0
        for(item in obecny){
            println("i = " + i)
            item.text = doSpisania.get(i).text
            item.background = doSpisania.get(i).background
            i++
        }
    }

    fun closetrener(view: View){
        val pon = findViewById<LinearLayout>(R.id.pon)
        val wt = findViewById<LinearLayout>(R.id.wt)
        val śr = findViewById<LinearLayout>(R.id.śr)
        val czw = findViewById<LinearLayout>(R.id.czw)
        val pt = findViewById<LinearLayout>(R.id.pt)

        var ponTextViewsList = pon.children.filterIsInstance<TextView>()
        var wtTextViewsList = wt.children.filterIsInstance<TextView>()
        var śrTextViewsList = śr.children.filterIsInstance<TextView>()
        var czwTextViewsList = czw.children.filterIsInstance<TextView>()
        var ptTextViewsList = pt.children.filterIsInstance<TextView>()


        MainActivity3.ponTextViewsList = ponTextViewsList.drop(1).toList()
        MainActivity3.wtTextViewsList = wtTextViewsList.drop(1).toList()
        MainActivity3.śrTextViewsList = śrTextViewsList.drop(1).toList()
        MainActivity3.czwTextViewsList = czwTextViewsList.drop(1).toList()
        MainActivity3.ptTextViewsList = ptTextViewsList.drop(1).toList()
        finish()
    }

    fun createClasses(view : View){
        window.visibility = View.VISIBLE
        window.bringToFront()
        textWindow = view as TextView
    }

    fun save(view: View){
        var str = editText.text.toString()
        textWindow.setText(str + "-\nmiejsca\n0/10")
        textWindow.setBackgroundColor(Color.argb(64, 50, 205, 50))
        window.visibility = View.GONE
        editText.setText("")
    }
}