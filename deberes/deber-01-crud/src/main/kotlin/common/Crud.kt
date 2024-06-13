abstract class Crud<T, ID> {
    protected abstract val items: MutableList<T>

    fun create(item: T): T {
        items.add(item)
        return item
    }

    fun read(id: ID): T? {
        return items.find { getItemId(it) == id }
    }

    fun readAll(): List<T> {
        return items.toList()
    }

    fun update(id: ID, item: T): Boolean {
        val index = items.indexOfFirst { getItemId(it) == id }
        if (index != -1) {
            items[index] = item
            return true
        }
        return false
    }

    open fun delete(id: ID): Boolean {
        return items.removeIf { getItemId(it) == id }
    }

    protected abstract fun getItemId(item: T): ID
}
