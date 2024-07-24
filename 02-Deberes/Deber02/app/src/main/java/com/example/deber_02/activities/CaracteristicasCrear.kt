package com.example.deber_02.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deber_02.R
import com.example.deber_02.datos.BDatosMemoriaCaracteristica
import com.example.deber_02.modelos.BCaracteristica
import com.google.android.material.snackbar.Snackbar

class CaracteristicasCrear : AppCompatActivity() {

    private lateinit var descripcionEditText: EditText
    private lateinit var tituloEditText: EditText
    private lateinit var botonGuardar: Button
    private lateinit var container: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_caracteristicas_crear)
        setupViews()
        setupInsets()

        val caracteristicaId = intent.getIntExtra("caracteristica_id", -1)

        botonGuardar.setOnClickListener {
            handleSaveClick(caracteristicaId)
        }
    }

    private fun setupViews() {
        descripcionEditText = findViewById(R.id.txt_descripcion_caracteristica)
        tituloEditText = findViewById(R.id.txt_titulo)
        botonGuardar = findViewById(R.id.btn_guardar_caracteristica)
        container = findViewById(R.id.cl_crear_caracteristica)
    }

    private fun setupInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(container) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun handleSaveClick(caracteristicaId: Int) {
        val titulo = tituloEditText.text.toString()
        val descripcion = descripcionEditText.text.toString()

        if (descripcion.isNotEmpty() && titulo != null) {
            val respuesta = if (caracteristicaId == -1) {
                crearNuevaCaracteristica(titulo, descripcion)
            } else {
                actualizarCaracteristicaExistente(caracteristicaId, titulo, descripcion)
            }

            if (respuesta) {
                irActividad(MainActivity::class.java)
            } else {
                mostrarSnackBar("Error al guardar la Característica.")
            }
        } else {
            mostrarSnackBar("Datos inválidos.")
        }
    }

    private fun crearNuevaCaracteristica(titulo: String, descripcion: String): Boolean {
        val id = BDatosMemoriaCaracteristica.idsCaracteristica + 1
        val nuevaCaracteristica = BCaracteristica(id, titulo, descripcion)
        return BDatosMemoriaCaracteristica.crearCaracteristica(nuevaCaracteristica).also {
            if (it) BDatosMemoriaCaracteristica.idsCaracteristica += 1
        }
    }

    private fun actualizarCaracteristicaExistente(
        caracteristicaId: Int,
        titulo: String,
        descripcion: String
    ): Boolean {
        val nuevaCaracteristica = BCaracteristica(caracteristicaId, titulo, descripcion)
        return BDatosMemoriaCaracteristica.actualizarCaracteristica(
            caracteristicaId,
            nuevaCaracteristica
        )
    }

    private fun irActividad(clase: Class<*>) {
        startActivity(Intent(this, clase))
    }

    private fun mostrarSnackBar(texto: String) {
        Snackbar.make(container, texto, Snackbar.LENGTH_INDEFINITE).show()
    }
}
