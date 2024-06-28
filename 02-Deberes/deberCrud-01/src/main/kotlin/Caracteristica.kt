data class Caracteristica(
    var id: Int,
    val idPlaneta: Int,
    val nombre: String,
    val valor: String,
) {

    override fun toString(): String {
        return "Caracteristica(id=$id, idPlaneta=$idPlaneta, nombre='$nombre', valor='$valor')"
    }

    companion object {
        val caracteristicas: MutableList<Caracteristica> = mutableListOf()

        // que exista
        fun crear(caracteristica: Caracteristica) {
            caracteristicas.add(caracteristica)
        }

        fun actualizar(caracteristica: Caracteristica) {
            val index = caracteristicas.indexOfFirst { it.id == caracteristica.id }
            if (index != -1) {
                caracteristicas[index] = caracteristica
            }
        }

        fun eliminar(caracteristica: Caracteristica) {
            val index = caracteristicas.indexOfFirst { it.id == caracteristica.id }
            if (index != -1) {
                caracteristicas.removeAt(index)
            }
        }

        fun guardar() {
            FileManager.save("./src/main/kotlin/datosGuardados/caracteristicas.json", caracteristicas)
        }

        fun cargar() {
            FileManager.load("./src/main/kotlin/datosGuardados/caracteristicas.json", caracteristicas as MutableList<Any>)
        }
    }
}