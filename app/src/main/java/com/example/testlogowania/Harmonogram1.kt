package com.example.testlogowania

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children

class Harmonogram1 : AppCompatActivity() {

    lateinit var clickedTextView: MutableList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_harmonogram1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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


        if(MainActivity3.ponTextViewsList.firstOrNull() != null){

            przepisz(ponTextViewsList, MainActivity3.ponTextViewsList)
            przepisz(wtTextViewsList, MainActivity3.wtTextViewsList)
            przepisz(śrTextViewsList, MainActivity3.śrTextViewsList)
            przepisz(czwTextViewsList, MainActivity3.czwTextViewsList)
            przepisz(ptTextViewsList, MainActivity3.ptTextViewsList)
        }

        podmienTextView(ponTextViewsList)
        podmienTextView(wtTextViewsList)
        podmienTextView(śrTextViewsList)
        podmienTextView(czwTextViewsList)
        podmienTextView(ptTextViewsList)

        clickedTextView = emptyList<TextView>().toMutableList()
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

    fun podmienTextView(list: List<TextView>){
        for(item in list){
            var lines = item.text.split("\n")
            if(lines.size<2)
            {
                item.setText("Brak zajęć")
            }
        }
    }

    fun closeHarmonogram(view: View){
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

    fun textViewClicked(view: View){
        print("CLICK!")
        val obj = view as TextView
        for(item in clickedTextView){
            if(item.equals(obj)){
                println("znaleziony!!!")
                unregister(view)
                clickedTextView.remove(item)
                return
            }
        }
        enroll(view, obj)
    }

    fun enroll(view: View, obj: TextView){


        var textView = view as TextView
        var lines = textView.text.split("\n")
        if(lines.size < 2)
            return
        var text = lines.get(lines.size - 1)
        var lines2 = text.split("/")
        var number = lines2.get(0).toInt()
        var string = lines.dropLast(1).joinToString("\n")
        if(number < 10){
            clickedTextView.add(obj)
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
        if(lines.size < 2)
            return
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