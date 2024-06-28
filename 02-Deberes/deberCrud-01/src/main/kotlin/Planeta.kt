
data class Planeta(
    var id: Int,
    var nombre: String,
    var tipo: String,
    var masa: Double,
    var radio: Double,
) {
    override fun toString(): String {
        return "Planeta(id=$id, nombre='$nombre', tipo='$tipo', masa=$masa, radio=$radio)"
    }
    companion object{
        val planetas: MutableList<Planeta> = mutableListOf()
        fun crear(planeta: Planeta){
            planetas.add(planeta)
        }

        fun actualizar(planeta: Planeta){
            val index = planetas.indexOfFirst { it.id == planeta.id }
            if (index != -1) {
                planetas[index] = planeta
            }
        }

        fun eliminar(planeta: Planeta){
            val index = planetas.indexOfFirst { it.id == planeta.id }
            if (index != -1) {
                planetas.removeAt(index)
            }
        }

        fun guardar(){
            FileManager.save("./src/main/kotlin/datosGuardados/planetas.json", planetas)
        }

        fun cargar(){
            FileManager.load("./src/main/kotlin/datosGuardados/planetas.json", planetas as MutableList<Any>)
        }
    }
}