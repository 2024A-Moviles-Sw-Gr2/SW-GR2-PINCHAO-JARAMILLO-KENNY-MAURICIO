package com.example.deber_02.activities

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.deber_02.R
import com.example.deber_02.adaptadores.PlanetaAdapter
import com.example.deber_02.datos.BDatosMemoriaPlaneta
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adaptador: PlanetaAdapter
    private var posicionItemSeleccionado = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initViews()
        setupListView()
        setupWindowInsets()
        setupButtons()
    }

    private fun initViews() {
        listView = findViewById(R.id.lv_planeta)
    }

    private fun setupListView() {
        adaptador = PlanetaAdapter(this, BDatosMemoriaPlaneta.obtenerPlanetas())
        listView.adapter = adaptador
        adaptador.notifyDataSetChanged()
        registerForContextMenu(listView)
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupButtons() {
        val botonCrear = findViewById<Button>(R.id.btn_crear_planeta)
        botonCrear.setOnClickListener {
            irActividad(PlanetasCrear::class.java, -1)
        }
    }

    private fun irActividad(clase: Class<*>, planetaId: Int?) {
        val intent = Intent(this, clase).apply {
            putExtra("planeta_id", planetaId)
        }
        startActivity(intent)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_planeta, menu)
        posicionItemSeleccionado = (menuInfo as AdapterView.AdapterContextMenuInfo).position
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val planetaId = info.targetView.tag as Int

        return when (item.itemId) {
            R.id.menu_planeta_editar -> {
                mostrarSnackbar("Editar $posicionItemSeleccionado")
                irActividad(PlanetasCrear::class.java, planetaId)
                true
            }
            R.id.menu_planeta_eliminar -> {
                mostrarSnackbar("Eliminar $posicionItemSeleccionado")
                BDatosMemoriaPlaneta.eliminarPlaneta(planetaId)
                mostrarSnackbar("Planeta con id: $planetaId eliminado")
                irActividad(MainActivity::class.java, -1)
                true
            }
            R.id.menu_planeta_ver -> {
                mostrarSnackbar("Características $posicionItemSeleccionado")
                irActividad(Caracteristicas::class.java, planetaId)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    private fun mostrarSnackbar(texto: String) {
        Snackbar.make(
            findViewById(R.id.main),
            texto,
            Snackbar.LENGTH_INDEFINITE
        ).show()
    }
}