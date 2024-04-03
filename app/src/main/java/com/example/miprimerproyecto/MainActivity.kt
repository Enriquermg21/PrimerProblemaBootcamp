package com.example.miprimerproyecto

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var palabras: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val botonRandom = findViewById<Button>(R.id.botonRandom)
        val parrafo1 = findViewById<TextView>(R.id.parrafo1)
        val parrafo2 = findViewById<TextView>(R.id.parrafo2)

        palabras = resources.getString(R.string.lorem).split("\\s+".toRegex())

        configurarAutoSizeText(parrafo1)
        configurarAutoSizeText(parrafo2)

        botonRandom.setOnClickListener {
            val numeroAleatorio = (1..3).random()
            if(numeroAleatorio==1){
                parrafo1.text = obtenerPalabras().toString()
            }
            else if (numeroAleatorio==2){
                parrafo2.text = obtenerPalabras().toString()
            }
            else{
                parrafo1.text = obtenerPalabras().toString()
                parrafo2.text = obtenerPalabras().toString()
            }


        }
    }

    private fun obtenerPalabras(): String {
        val palabrasAleatorias = List(100) { palabras.random() } // Generar 20 palabras aleatorias
        return palabrasAleatorias.joinToString(separator = " ") // Unir las palabras con un espacio entre cada una
    }
//Preguntar por que tengo que hacer este metodo aparte
    private fun configurarAutoSizeText(textView: TextView) {
        textView.setAutoSizeTextTypeUniformWithConfiguration(
            8, // Tamaño mínimo en sp
            24, // Tamaño máximo en sp
            1, // Incremento en sp
            TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM
        )
    }
}

//
//ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//insets