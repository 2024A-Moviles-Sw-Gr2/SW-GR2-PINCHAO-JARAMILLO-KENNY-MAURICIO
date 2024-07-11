import database.Database
import modelos.Caracteristica
import repositorios.CaracteristicaRepositorio

fun main(args: Array<String>) {
    val db = Database.instance
    db.initialize()

    // Crear una instancia del repositorio de características
    val caracteristicaRepositorio = CaracteristicaRepositorio()

    // Crear una característica
    val nuevaCaracteristica = Caracteristica(1, "Descripción de la característica", 1)
    caracteristicaRepositorio.create(nuevaCaracteristica)

    // Leer una característica por su ID
    val caracteristicaLeida = caracteristicaRepositorio.read(1)
    println("Característica leída: $caracteristicaLeida")

    // Actualizar una característica
    val caracteristicaActualizada = Caracteristica(1, "Nueva descripción de la característica", 1)
    caracteristicaRepositorio.update(1, caracteristicaActualizada)

    // Eliminar una característica por su ID
    val caracteristicaEliminada = caracteristicaRepositorio.delete(1)
    if (caracteristicaEliminada) {
        println("Característica eliminada correctamente.")
    } else {
        println("No se encontró la característica para eliminar.")
    }

    db.saveToFile("database.json")
}