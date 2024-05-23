fun main(args: Array<String>) {
    /*
    println("Hello World!")

    val innmutable: String = "Kenny";
    var mutable: String = "Vicente";
    mutable = "Kenny P";
    // VAL > VAR

    // Duck Typing
    var ejemploVariable = "Kenny Pinchao";
    println(ejemploVariable)
    val edadEjemplo: Int = 12;

    //
    val nombre: String = "Kenny";
    val sueldo: Double;

    val estadoCivilWhen = "C";
    when (estadoCivilWhen) {
        ("C") -> {
            println("Casado")
        }

        "S" -> {
            println("Soltero")
        }

        else -> {
            println("No sabemos")
        }
    }

    val esSoltero = (estadoCivilWhen == "S")
    val coqueteo = if (esSoltero) "Si" else "No"

    fun imprimirNombre(nombre: String): Unit {
        println("Nombre: ${nombre}")
    }

    fun calcularSueldo(
        sueldo: Double,
        tasa: Double = 12.00,
        bonoEspecial: Double? = null
    ): Double {
        if (bonoEspecial == null) {
            return sueldo * (100 / tasa)
        } else {
            return sueldo * (100 / tasa) * bonoEspecial
        }
    }

    var calc1 = calcularSueldo(10.00);
    var calc2 = calcularSueldo(10.00, 15.00, 20.00)

    // named parameters
    //
    var calc4 = calcularSueldo(10.00, bonoEspecial = 20.00)
    var calc5 = calcularSueldo(bonoEspecial = 20.00, sueldo = 10.00, tasa = 14.00)
    // imprimir los calculos

    println("El calculo es: $calc1")
    println("El calculo es: $calc2")
    println("El calculo es: $calc4")
    println("El calculo es: $calc5")
*/
    val suma = Suma(1, 2)
    val suma2 = Suma(1, null)
    val suma3 = Suma(null, 2)
    val suma4 = Suma(null, null)
    println(suma.sumar())
    println(suma2.sumar())
    println(suma3.sumar())
    println(suma4.sumar())
    println(Suma.pi)
    println(Suma.elevarAlCuadrado(2))
    println(Suma.historialSumas)

    // arreglos staticos
    val arregloEstatico: Array<Int> = arrayOf(1, 2, 3)
    println(arregloEstatico)

    // dinamicos
    val arregloDinamico: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6)

    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    // FOR EACH => Unit
    // Iterar un arreglo
    val respuestaForEach1: Unit = arregloDinamico
        .forEach {
            println("Valor iterado: $it")
        }

    val respuestaForEach2: Unit = arregloDinamico
        .forEach { valorActual: Int ->
            println("Valor iterado: $valorActual")
        }
    // "it" => variable implicita
    arregloDinamico.forEach { println("Valor iterado: $it") }

    // MAP -> Muta el arreglo (cambia el arreglo)
    // 1) Enviemos el nuevo valor de la iteracion
    // 2) Nos devuelve un NUEVO ARREGLO con los valores modificados
    val respuestaMap: List<Double> = arregloDinamico
        .map { valorActual: Int ->
            return@map valorActual.toDouble() + 100.00
        }
    println(respuestaMap)

    val respuestaMap2: List<Double> = arregloDinamico
        .map { it.toDouble() + 15.00 }

    // Filter - > Filtrar el ARREGLO
    // 1) Devolver una expresion (TRUE o FALSE)
    // 2) Nuevo arreglo con los valores filtrados

    val respuestaFilter: List<Int> = arregloDinamico
        .filter { valorActual: Int ->
            val mayoresACinco: Boolean = valorActual > 5

            return@filter mayoresACinco
        }

    val respuestaFilter2: List<Int> = arregloDinamico.filter { it <= 5}
    println(respuestaFilter)
    println(respuestaFilter2)

    // OR AND
    // OR -> ANY (ALGUNO CUMPLE)
    // AND -> ALL (TODOS CUMPLEN)

    val respuestaAny: Boolean = arregloDinamico
        .any { valorActual: Int ->
            return@any valorActual > 5
        }

    println(respuestaAny)

    val respuestaAll: Boolean = arregloDinamico
        .all { valorActual: Int ->
            return@all valorActual > 5
        }

    println(respuestaAll)

    // REDUCE -> Valor acumulado
    // Valor acumulado = 0 (siempre empiezo en 0)
    // [1, 2, 3, 4, 5] -> Acumular "SUMAR" estos valores del arreglo
    // valorIteracion1 = valorInicial + 1 = 0 + 1 = 1 -> iteracion1
    // valorIteracion2 = valorIteracion1 + 2 = 1 + 2 = 3 -> iteracion2
    // valorIteracion3 = valorIteracion2 + 3 = 3 + 3 = 6 -> iteracion3
    // valorIteracion4 = valorIteracion3 + 4 = 6 + 4 = 10 -> iteracion4
    // valorIteracion5 = valorIteracion4 + 5 = 10 + 5 = 15 -> iteracion5
    val respuestaReduce: Int = arregloDinamico
        .reduce { acumulado: Int, valorActual: Int ->
            return@reduce acumulado + valorActual
        }

    println(respuestaReduce)

}

abstract class NumerosJava {
    protected val numeroUno: Int
    private val numeroDos: Int

    constructor(
        uno: Int,
        dos: Int
    ) {
        this.numeroUno = uno
        this.numeroDos = dos
        println("Constructor Primario")
    }
}

abstract class Numeros(
    // Caso 1) Parametro normal
    // uno: Int , (parametro(sin modificador))

    // Caso 2) Parametro y propiedad(atributo) (private)
    // private val uno: Int (propiedad "instancia.uno")

    protected var numeroUno: Int,
    protected var numeroDos: Int
) {

    init {
        this.numeroUno
        this.numeroDos
        println("Constructor Primario")
    }
}

class Suma(
    unoParametro: Int,
    dosParametro: Int
) : Numeros(
    unoParametro,
    dosParametro
) {
    public val soyPublicoExplicito: String = "Explicito"
    val soyPublicoImplicito: String = "Implícito"

    init {
        this.numeroUno
        this.numeroDos
        numeroUno
        numeroDos
        this.soyPublicoExplicito
        soyPublicoImplicito // this. OPCIONAL
    }

    constructor(
        uno: Int?,
        dos: Int
    ) : this(
        if (uno == null) 0 else uno,
        dos
    )

    constructor(
        uno: Int,
        dos: Int?
    ) : this(
        uno,
        if (dos == null) 0 else dos
    )

    constructor(
        uno: Int?,
        dos: Int?
    ) : this(
        if (uno == null) 0 else uno,
        if (dos == null) 0 else dos
    )

    fun sumar(): Int {
        val total = this.numeroUno + this.numeroDos
        agregarHistorial(total)
        return total
    }

    companion object {
        // comparte entre todas las instancias
        val pi = 3.1416
        fun elevarAlCuadrado(numero: Int): Int {
            return numero * numero
        }

        val historialSumas = arrayListOf<Int>()

        fun agregarHistorial(nuevaSuma: Int) {
            this.historialSumas.add(nuevaSuma)
        }

    }
}

