
import org.json.JSONArray
import org.json.JSONObject
import java.io.File

class FileManager {
    companion object{
        private fun saveFile(fileName: String, content: String) {
            val file = File(fileName)
            file.writeText(content)
        }

        private fun readFile(fileName: String): String {
            val file = File(fileName)
            return file.readText()
        }

        fun save(fileName: String, lista: List<Any>) {
            val jsonArray = JSONArray()
            for (item in lista) {
                val jsonObject = JSONObject()
                val methods = item::class.java.methods
                methods.forEach { method ->
                    if (method.name.startsWith("get")) {
                        val name = method.name.drop(3).decapitalize()
                        val value = method.invoke(item).toString()
                        jsonObject.put(name, value)
                    }
                }
                // Agregar el campo "className" al objeto JSON
                jsonObject.put("className", item::class.java.name)
                jsonArray.put(jsonObject)
            }
            saveFile(fileName, jsonArray.toString())
        }

        fun load(fileName: String, lista: MutableList<Any>) {
            val data = readFile(fileName)
            if (data.isNotEmpty()) {
                val jsonArray = JSONArray(data)
                lista.clear()
                for (i in 0 until jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val className = jsonObject.getString("className")
                    val clazz = Class.forName(className)

                    if (clazz == Planeta::class.java) {
                        val planeta = Planeta(
                            jsonObject.getInt("id"),
                            jsonObject.getString("nombre"),
                            jsonObject.getString("tipo"),
                            jsonObject.getDouble("masa"),
                            jsonObject.getDouble("radio"),
                        )
                        lista.add(planeta)
                    } else {
                        val caracteristica = Caracteristica(
                            jsonObject.getInt("id"),
                            jsonObject.getInt("idPlaneta"),
                            jsonObject.getString("nombre"),
                            jsonObject.getString("valor"),
                        )
                        lista.add(caracteristica)
                    }
                }
            }
        }
    }
}