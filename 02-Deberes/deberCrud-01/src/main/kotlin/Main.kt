val planeta1 = Planeta(1, "Tierra", "Rocoso", 5.97e24, 6371.0)
val planeta2 = Planeta(2, "Júpiter", "Gaseoso", 1.90e27, 69911.0)

val caracteristica1 = Caracteristica(1, 1, "Temperatura Media", "15°C")
val caracteristica2 = Caracteristica(2, 1, "Composición Atmosférica", "78% N2, 21% O2")
val caracteristica3 = Caracteristica(3, 2, "Temperatura Media", "-145°C")
val caracteristica4 = Caracteristica(4, 2, "Composición Atmosférica", "90% H2, 10% He")



fun main(args: Array<String>) {

    // CREACION DE DATOS
    Planeta.crear(planeta1)
    Planeta.crear(planeta2)

    Caracteristica.crear(caracteristica1)
    Caracteristica.crear(caracteristica2)
    Caracteristica.crear(caracteristica3)
    Caracteristica.crear(caracteristica4)


    // ACTUALIZACION DE DATOS
    println("==================== ACTUALIZACION DE DATOS ====================\n")
    println("Planeta antes de actualizar: $planeta1");

    val planetaActualizado = Planeta(1, "Tierra", "Rocoso", 5.0e24, 10000.0)
    Planeta.actualizar(planetaActualizado)
    println("Planeta después de actualizar: ${Planeta.planetas.find { it.id == 1 }}\n")


    println("Caracteristica antes de actualizar: $caracteristica1")
    val caracteristicaActualizada = Caracteristica(1, 1, "Temperatura Media", "20°C")
    Caracteristica.actualizar(caracteristicaActualizada)
    println("Caracteristica después de actualizar: ${Caracteristica.caracteristicas.find { it.id == 1 }}\n")

    // ELIMINACION DE DATOS
    println("==================== ELIMINACION DE DATOS ====================\n")
    println("Planeta antes de eliminar: ${Planeta.planetas.find { it.id == 1 }}")
    Planeta.eliminar(planeta1)
    println("Planeta después de eliminar: ${Planeta.planetas.find { it.id == 1 }}\n")

    println("Caracteristica antes de eliminar: ${Caracteristica.caracteristicas.find { it.id == 1 }}")
    Caracteristica.eliminar(caracteristica1)
    println("Caracteristica después de eliminar: ${Caracteristica.caracteristicas.find { it.id == 1 }}\n")

    // GUARDAR DATOS
    Planeta.guardar()
    Caracteristica.guardar()


    println("")
    readLine()


    // CARGAR DATOS
    Planeta.cargar()
    Caracteristica.cargar()

    // NUEVAS OPERACIONES
    println("==================== NUEVAS OPERACIONES ====================\n")
    // CREAR PLANETA
    val planeta3 = Planeta(3, "Neptuno", "Gaseoso", 1.02e26, 24622.0)
    val planeta4 = Planeta(4, "Saturno", "Gaseoso", 5.68e26, 58232.0)
    Planeta.crear(planeta3)
    Planeta.crear(planeta4)
    println("Planeta creado: ${Planeta.planetas.find { it.id == 3 }}")
    println("Planeta creado: ${Planeta.planetas.find { it.id == 4 }}\n")
    //GUARDAR
    Planeta.guardar()

}