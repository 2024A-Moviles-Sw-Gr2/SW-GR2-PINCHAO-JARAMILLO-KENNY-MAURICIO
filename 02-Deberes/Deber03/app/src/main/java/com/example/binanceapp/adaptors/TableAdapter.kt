package com.example.binanceapp.adaptors

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.binanceapp.R

data class DataItem(
    val name: String,
    val lastPrice: String,
    val change24h: String
)

class TableAdapter(private val dataList: List<DataItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_ITEM = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_HEADER else VIEW_TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_HEADER) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.header_row, parent, false)
            HeaderViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
            ItemViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            val item = dataList[position - 1] // Offset by 1 for header
            holder.nameTextView.text = item.name
            holder.priceTextView.text = item.lastPrice
            holder.changeTextView.text = item.change24h

            // Cambiar color según el valor del cambio
            val changeValue = item.change24h
            val drawable = holder.changeTextView.background as GradientDrawable
            val context = holder.itemView.context

            if (changeValue.startsWith("+")) {
                // Positivo
                drawable.setColor(ContextCompat.getColor(context, R.color.color_succes))
            } else {
                // Negativo
                drawable.setColor(ContextCompat.getColor(context, R.color.color_error))
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size + 1 // Add 1 for the header
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val priceTextView: TextView = itemView.findViewById(R.id.textViewPrice)
        val changeTextView: TextView = itemView.findViewById(R.id.textViewChange)
    }
}
