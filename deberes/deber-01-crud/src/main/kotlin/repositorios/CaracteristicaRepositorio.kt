package repositorios

import common.Crud
import database.Database
import modelos.Caracteristica


class CaracteristicaRepositorio: Crud<Caracteristica, Int>{
    private val tableName = "caracteristicas"
    override fun create(item: Caracteristica): Caracteristica {
        val table = Database.instance.getTable<Caracteristica>(tableName)
        table?.create(item)
        return item
    }

    override fun read(id: Int): Caracteristica? {
        val table = Database.instance.getTable<Caracteristica>(tableName)

        return table?.read(id)
    }

    override fun readAll(): List<Caracteristica> {
        val table = Database.instance.getTable<Caracteristica>(tableName)
        return table?.readAll() ?: emptyList()
    }

    override fun delete(id: Int): Boolean {
        val table = Database.instance.getTable<Caracteristica>(tableName)
        val existingItem = table?.read(id)
        return if (existingItem != null) {
            table.delete(id)
            true
        } else {
            false
        }
    }

    override fun update(id: Int, item: Caracteristica): Boolean {
        val table = Database.instance.getTable<Caracteristica>(tableName)
        val existingItem = table?.read(id)
        return if (existingItem != null) {
            table.update(id, item)
            true
        } else {
            false
        }
    }
}

