package com.example.s1reto1unai

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val etNombre = findViewById<EditText>(R.id.etNombre)
        val spinnerCursos = findViewById<Spinner>(R.id.spinner)
        val tvNivel = findViewById<TextView>(R.id.tvNivel)
        val seekBarNivel = findViewById<SeekBar>(R.id.seekBarNivel)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)


        seekBarNivel.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvNivel.text = "Nivel seleccionado: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        val listaCursos = arrayOf("Android Básico", "Jetpack Compose", "Kotlin Avanzado", "Flutter desde cero")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaCursos)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCursos.adapter = adaptador

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val cursoSeleccionado = spinnerCursos.selectedItem.toString()
            val nivelActual = seekBarNivel.progress

            if (nombre.isEmpty()) {
                etNombre.error = "Por favor, introduce tu nombre"
                return@setOnClickListener
            }

            val mensaje = "¡Guardado!\nNombre: $nombre\nCurso: $cursoSeleccionado\nNivel: $nivelActual"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }
}