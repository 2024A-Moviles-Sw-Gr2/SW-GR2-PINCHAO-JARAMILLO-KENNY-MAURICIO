package repositorios

import common.Crud
import database.Database
import modelos.Planeta

class PlanetaRepositorio: Crud<Planeta, Int>{
    private val tableName = "planetas"

    override fun create(item: Planeta): Planeta {
        val table = Database.instance.getTable<Planeta>(tableName)
        table?.create(item)
        return item
    }

    override fun read(id: Int): Planeta? {
        val table = Database.instance.getTable<Planeta>(tableName)
        return table?.read(id)
    }

    override fun readAll(): List<Planeta> {
        val table = Database.instance.getTable<Planeta>(tableName)
        return table?.readAll() ?: emptyList()
    }

    override fun delete(id: Int): Boolean {
        val table = Database.instance.getTable<Planeta>(tableName)
        val existingItem = table?.read(id)
        return if (existingItem != null) {
            table.delete(id)
            true
        } else {
            false
        }
    }

    override fun update(id: Int, item: Planeta): Boolean {
        val table = Database.instance.getTable<Planeta>(tableName)
        val existingItem = table?.read(id)
        return if (existingItem != null) {
            table.update(id, item)
            true
        } else {
            false
        }
    }


}