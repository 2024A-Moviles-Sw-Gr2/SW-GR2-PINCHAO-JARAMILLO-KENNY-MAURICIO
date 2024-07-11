package modelos

import java.util.*

class Planeta(
    val id: Int,
    val nombre: String,
    val diametro: Double,
    val tieneSatelites: Boolean,
    val fechaDescubrimiento: Date,
    val caracteristicas: MutableList<Caracteristica> = mutableListOf()
)