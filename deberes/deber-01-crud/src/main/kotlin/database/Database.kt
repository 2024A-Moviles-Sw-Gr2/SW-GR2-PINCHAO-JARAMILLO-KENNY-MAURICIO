package database

import modelos.Caracteristica
import java.io.File
import org.json.JSONArray
import org.json.JSONObject
class Database {
    companion object{
        val instance = Database()
    }
    private val tables = mutableMapOf<String, Table<*>>()
    fun initialize() {
        // Crear una tabla para las características
        createTable<Caracteristica>("caracteristicas",
            itemToJson = { caracteristica ->
                JSONObject().apply {
                    put("id", caracteristica.id)
                    put("descripcion", caracteristica.descripcion)
                    put("planetaId", caracteristica.planetaId)
                }
            },
            jsonToItem = { json ->
                Caracteristica(
                    json.getInt("id"),
                    json.getString("descripcion"),
                    json.getInt("planetaId")
                )
            }
        )
    }
    fun <T> createTable(name: String, itemToJson: (T) -> JSONObject, jsonToItem: (JSONObject) -> T) {
        tables[name] = Table(itemToJson, jsonToItem)
        println(tables[name])
    }

    //@Suppress("UNCHECKED_CAST")
    fun <T> getTable(name: String): Table<T>? = tables[name] as? Table<T>

    fun deleteTable(name: String) {
        tables.remove(name)
    }

    fun saveToFile(filename: String) {
        val jsonObject = JSONObject()
        for ((name, table) in tables) {
            jsonObject.put(name, (table as Table<Any>).toJsonArray())
        }
        File(filename).writeText(jsonObject.toString(4))
    }

    fun loadFromFile(filename: String) {
        val fileContent = File(filename).readText()
        val jsonObject = JSONObject(fileContent)
        for ((name, table) in tables) {
            if (jsonObject.has(name)) {
                val jsonArray = jsonObject.getJSONArray(name)
                (table as Table<Any>).fromJsonArray(jsonArray)
            }
        }
    }
}

class Table<T>(private val itemToJson: (T) -> JSONObject, private val jsonToItem: (JSONObject) -> T) {

    private val records = mutableListOf<T>()

    fun create(record: T) {
        records.add(record)
    }

    fun readAll(): List<T> = records.toList()

    fun  read(index: Int): T? {
        if (index in records.indices) {
            return records[index]
        } else {
            println(records.indices)
            return null
        }
    }
    fun update(index: Int, newRecord: T) {
        if (index in records.indices) {
            records[index] = newRecord
        } else {
            println("Registro no encontrado.")
        }
    }

    fun delete(index: Int) {
        if (index in records.indices) {
            records.removeAt(index)
        } else {
            println("Registro no encontrado.")
        }
    }

    fun toJsonArray(): JSONArray {
        val jsonArray = JSONArray()
        for (record in records) {
            jsonArray.put(itemToJson(record))
        }
        return jsonArray
    }
    fun fromJsonArray(jsonArray: JSONArray) {
        records.clear()
        for (i in 0 until jsonArray.length()) {
            records.add(jsonToItem(jsonArray.getJSONObject(i)))
        }
    }
}
