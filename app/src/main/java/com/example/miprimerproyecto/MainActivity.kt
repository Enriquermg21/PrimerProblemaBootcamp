package com.example.miprimerproyecto

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

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
            when (numeroAleatorio) {
                1 -> {
                    parrafo1.text = obtenerPalabras()
                }
                2 -> {
                    parrafo2.text = obtenerPalabras()
                }
                else -> {
                    parrafo1.text = obtenerPalabras()
                    parrafo2.text = obtenerPalabras()
                }
            }


        }
    }

    private fun obtenerPalabras(): String {
        val palabrasAleatorias = List(100) { palabras.random() }
        return palabrasAleatorias.joinToString(separator = " ")
    }
    private fun configurarAutoSizeText(textView: TextView) {
        textView.setAutoSizeTextTypeUniformWithConfiguration(
            8,
            24,
            1,
            TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM
        )
    }
}