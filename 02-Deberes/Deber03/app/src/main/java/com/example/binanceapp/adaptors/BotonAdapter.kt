package com.example.binanceapp.adaptors

import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.caverock.androidsvg.SVG
import com.example.binanceapp.R
import kotlin.math.roundToInt

data class BotonData(val label: String, val svgString: String)

class BotonAdapter(
    private val datos: List<BotonData>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<BotonAdapter.BotonViewHolder>() {

    class BotonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val boton: ImageButton = view.findViewById(R.id.boton)
        val texto: TextView = view.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BotonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_recycled_view_menu, parent, false)
        return BotonViewHolder(view)
    }

    override fun onBindViewHolder(holder: BotonViewHolder, position: Int) {
        val botonData = datos[position]
        holder.texto.text = botonData.label

        val drawable = svgStringToDrawable(holder.itemView.context, botonData.svgString)
        holder.boton.setImageDrawable(drawable)

        holder.itemView.setOnClickListener { onClick(botonData.label) }
    }

    override fun getItemCount() = datos.size

    private fun svgStringToDrawable(context: Context, svgString: String): PictureDrawable {
        val svg = SVG.getFromString(svgString)
        val density = context.resources.displayMetrics.density
        val defaultSize = (24 * density).roundToInt() // 24dp convertido a pixels

        svg.documentWidth = defaultSize.toFloat()
        svg.documentHeight = defaultSize.toFloat()

        val picture = svg.renderToPicture(defaultSize, defaultSize)
        return PictureDrawable(picture)
    }
}