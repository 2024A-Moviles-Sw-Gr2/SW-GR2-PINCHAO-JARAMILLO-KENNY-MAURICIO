package com.example.a2024aswgr2pjkm

class BBaseDatosMemoria {
    companion object{
        val arregloEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloEntrenador
                .add(BEntrenador(1, "Juan", "Descripcion Juan"))
            arregloEntrenador
                .add(BEntrenador(2, "Karla", "Descripcion Karla"))
            arregloEntrenador
                .add(BEntrenador(3, "Luis", "Descripcion Luis"))
        }
    }
}