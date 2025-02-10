package com.example.testlogowania

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject

class MainActivity2 : AppCompatActivity() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }


    fun onClickSwitchToLogin(v: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

//    fun onClickRegister(v: View) {
//        val user = findViewById<EditText>(R.id.registerUserEditText).text.toString()
//        val email = findViewById<EditText>(R.id.registerEmailEditText).text.toString()
//        val password = findViewById<EditText>(R.id.registerPasswordlEditText).text.toString()
//        val password2 = findViewById<EditText>(R.id.registerConfirmPasswordlEditText).text.toString()
//
//
//        if (password != password2) {
//            Toast.makeText(this, "Hasła nie pasują!", Toast.LENGTH_LONG).show()
//            return
//        }
//
//        val url = getString(R.string.db_url)
//        val jsonObject = JSONObject()
//
//        jsonObject.put("username", user)
//        jsonObject.put("password", password)
//        jsonObject.put("email", email)
//        jsonObject.put("query", "")
//
//        Log.d("Rejestracja", "Wysyłam JSON: $jsonObject na URL: $url") // <--- LOGUJEMY DANE!
//
//        val requestPOST = JsonObjectRequest(
//            Request.Method.POST, url, jsonObject,
//            Response.Listener { response ->
//                Log.d("Rejestracja", "Odpowiedź serwera: $response") // <--- LOGUJEMY ODPOWIEDŹ!
//                processResponse(response)
//            },
//            Response.ErrorListener { error ->
//                Log.e("Rejestracja", "Błąd Volley: ${error.message}") // <--- LOGUJEMY BŁĄD!
//                Toast.makeText(this, "Błąd sieci: ${error.message}", Toast.LENGTH_LONG).show()
//            }
//        )
//
//        VolleySingleton.getInstance(this).addToRequestQueue(requestPOST)
//    }

    fun onClickRegister(v: View) {
        val user = findViewById<EditText>(R.id.registerUserEditText).text.toString()
        val email = findViewById<EditText>(R.id.registerEmailEditText).text.toString()
        val password = findViewById<EditText>(R.id.registerPasswordlEditText).text.toString()
        val password2 = findViewById<EditText>(R.id.registerConfirmPasswordlEditText).text.toString()

        if (password != password2) {
            Toast.makeText(this, "Hasła nie pasują!", Toast.LENGTH_LONG).show()
            return
        }

        val url = getString(R.string.db_url)
        val jsonObject = JSONObject()

        jsonObject.put("username", user)
        jsonObject.put("password", password)
        jsonObject.put("email", email)
        jsonObject.put("query", "")

        Log.d("Rejestracja", "Wysyłam JSON: $jsonObject na URL: $url")

        val requestPOST = JsonObjectRequest(
            Request.Method.POST, url, jsonObject,
            Response.Listener { response ->
                Log.d("Rejestracja", "Odpowiedź serwera: $response")
                processResponse(response)
            },
            Response.ErrorListener { error ->
                Log.e("Rejestracja", "Błąd Volley: ${error.message}")
                Toast.makeText(this, "Błąd sieci: ${error.message}", Toast.LENGTH_LONG).show()
            }
        )

        VolleySingleton.getInstance(this).addToRequestQueue(requestPOST)
    }



    fun processResponse(response: JSONObject) {
        Log.d("processResponse", "Enter")
        if (response["success"]==1) {
            Toast.makeText(this, response["message"].toString(), Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        if (response["success"]==0) {
            Toast.makeText(this, response["message"].toString(), Toast.LENGTH_LONG).show()
        }

    }


}